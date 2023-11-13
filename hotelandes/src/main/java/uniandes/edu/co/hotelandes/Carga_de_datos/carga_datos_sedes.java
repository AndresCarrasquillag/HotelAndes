package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_sedes {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO SEDES (ID, NOMBRE, TELEFONO, DIRECCION, HOTELES_ID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 1; i <= 5000; i++) {
                int id = i;
                String nombre = "Sede" + i;
                int telefono = 1000000 + random.nextInt(9000000);
                String direccion = "Direccion" + i;

                int hotelesId = 1 + random.nextInt(5000); 
                if (checkHotelIdExists(connection, hotelesId)) {
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, nombre);
                    preparedStatement.setInt(3, telefono);
                    preparedStatement.setString(4, direccion);
                    preparedStatement.setInt(5, hotelesId);

                    preparedStatement.executeUpdate();
                } else {
                    System.out.println("Hotel ID " + hotelesId + " no existe, fila no insertada.");
                }
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkHotelIdExists(Connection connection, int hotelesId) throws SQLException {
        String checkSql = "SELECT COUNT(*) FROM HOTELES WHERE ID = ?";
        PreparedStatement checkStmt = connection.prepareStatement(checkSql);
        checkStmt.setInt(1, hotelesId);

        ResultSet resultSet = checkStmt.executeQuery();
        boolean exists = resultSet.next() && resultSet.getInt(1) > 0;
        
        resultSet.close();
        checkStmt.close();

        return exists;
    }
}
