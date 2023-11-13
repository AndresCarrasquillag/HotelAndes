package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.sql.Date;

public class carga_datos_consumos {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {
            String sql = "INSERT INTO consumos (ID, COSTO, FECHA_DE_PAGO, SERVICIOS_ID, DESCRIPCION, HABITACION_ID, ID_USUARIO, ALOJAMIENTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 1; i <= 5000; i++) { 
                int id = i;
                int costo = 10000 + random.nextInt(500000); 
                long millis = System.currentTimeMillis() - ((long) random.nextInt(365) * 24 * 60 * 60 * 1000);
                Date fechaDePago = new Date(millis); 
                int serviciosId = 1 + random.nextInt(100);
                String descripcion = "Descripcion " + i; 
                int habitacionId = 1 + random.nextInt(200); 
                int idUsuario = 10000 + random.nextInt(90000); 
                int alojamiento = 1 + random.nextInt(1000); 

                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, costo);
                preparedStatement.setDate(3, fechaDePago);
                preparedStatement.setInt(4, serviciosId);
                preparedStatement.setString(5, descripcion);
                preparedStatement.setInt(6, habitacionId);
                preparedStatement.setInt(7, idUsuario);
                preparedStatement.setInt(8, alojamiento);

                preparedStatement.executeUpdate();
            }
            
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

