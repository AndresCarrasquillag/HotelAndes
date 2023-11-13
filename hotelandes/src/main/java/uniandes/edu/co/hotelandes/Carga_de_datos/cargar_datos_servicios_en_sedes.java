
package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class cargar_datos_servicios_en_sedes{

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {

            String sql = "INSERT INTO SERVICIOS_EN_SEDES (SEDE_ID, SERVICIO_ID) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            
            int rangoSedes = 5000; 
            int rangoServicios = 5000; 

            for (int i = 1; i <= 1000; i++) { 
                int sedeId = 1 + random.nextInt(rangoSedes); 
                int servicioId = 1 + random.nextInt(rangoServicios); 

                preparedStatement.setInt(1, sedeId);
                preparedStatement.setInt(2, servicioId);

                preparedStatement.executeUpdate();
            }

            System.out.println("Datos insertados correctamente en la tabla SERVICIOS_EN_SEDES.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar datos en la tabla SERVICIOS_EN_SEDES: " + e.getMessage());
        }
    }
}
