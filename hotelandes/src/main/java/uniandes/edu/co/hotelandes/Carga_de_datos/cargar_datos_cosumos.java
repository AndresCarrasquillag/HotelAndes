
package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class cargar_datos_cosumos {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO consumos (ID, COSTO, FECHA_DE_PAGO, SERVICIOS_ID, DESCRIPCION, HABITACION_ID, ID_USUARIO, ALOJAMIENTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Random random = new Random();

            for (int i = 1; i <= 1000; i++) {
                preparedStatement.setInt(1, i); 
                preparedStatement.setInt(2, 1000 + random.nextInt(5000)); 
                preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis()));
                preparedStatement.setInt(4, 100 + random.nextInt(900)); 
                preparedStatement.setString(5, "Descripción del pago " + i);
                preparedStatement.setInt(6, 10 + random.nextInt(90));
                preparedStatement.setInt(7, 100000 + random.nextInt(900000)); 
                preparedStatement.setInt(8, 1 + random.nextInt(10)); 
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
