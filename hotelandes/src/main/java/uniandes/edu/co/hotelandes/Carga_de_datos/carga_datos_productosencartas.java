
package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_productosencartas {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {

            String sql = "INSERT INTO PRODUCTOS_EN_CARTAS (PRODUCTOS_ID, CARTAS_ID) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            
            int rangoProductos = 5000; 
            int rangoCartas = 5000;

            for (int i = 1; i <= 5000; i++) {
                int productosId = 1 + random.nextInt(rangoProductos); 
                int cartasId = 1 + random.nextInt(rangoCartas);

                preparedStatement.setInt(1, productosId);
                preparedStatement.setInt(2, cartasId);

                preparedStatement.executeUpdate();
            }

            System.out.println("Datos insertados correctamente en la tabla PRODUCTOS_EN_CARTAS.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar datos en la tabla PRODUCTOS_EN_CARTAS: " + e.getMessage());
        }
    }
}
