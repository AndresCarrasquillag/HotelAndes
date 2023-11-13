
package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_habitaciones{
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuarioDB = "ISIS2304D07202320"; 
        String contraseñaDB = "LyGscAGdEemx"; 

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuarioDB, contraseñaDB)) {
            String sql = "INSERT INTO habitaciones (ID, CAPACIDAD, COSTO, SEDES_ID, ID_TIPO) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Random random = new Random();
            for (int i = 1; i <= 5000; i++) {
                int id = i;
                int capacidad = 1 + random.nextInt(4);
                int costo = 1000000 + random.nextInt(5000000); 
                int sedesId = 1 + random.nextInt(10); 
                int idTipo = 1 + random.nextInt(5); 

                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, capacidad);
                preparedStatement.setInt(3, costo);
                preparedStatement.setInt(4, sedesId);
                preparedStatement.setInt(5, idTipo);

                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

