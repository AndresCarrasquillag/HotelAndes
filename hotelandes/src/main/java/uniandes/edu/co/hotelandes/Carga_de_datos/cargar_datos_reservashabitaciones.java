
package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class cargar_datos_reservashabitaciones {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {

            String sql = "INSERT INTO RESERVAS_HABITACIONES (HABITACIONES_ID, RESERVAS_ID) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            
            int rangoHabitaciones = 5000; 
            int rangoReservas = 5000; 

            for (int i = 1; i <= 5000; i++) {
                int habitacionesId = 1 + random.nextInt(rangoHabitaciones); 
                int reservasId = 1 + random.nextInt(rangoReservas); 

                preparedStatement.setInt(1, habitacionesId);
                preparedStatement.setInt(2, reservasId);

                preparedStatement.executeUpdate();
            }

            System.out.println("Datos insertados correctamente en la tabla RESERVAS_HABITACIONES.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar datos en la tabla RESERVAS_HABITACIONES: " + e.getMessage());
        }
    }
}
