package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_planesdeconsumo {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";
        
        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {

            String sql = "INSERT INTO PLANES_DE_CONSUMO (ID, NOMBRE, DESCRIPCION, DESCUENTO, HOTELES_ID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 1; i <= 5000; i++) {
                int id = i;
                String nombre = "Plan " + i;
                String descripcion = "Descripción del plan " + i;
                int descuento = random.nextInt(100); 
                int hotelesId = 1 + random.nextInt(5000); 

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nombre);
                preparedStatement.setString(3, descripcion);
                preparedStatement.setInt(4, descuento);
                preparedStatement.setInt(5, hotelesId);

                preparedStatement.executeUpdate();
            }

            System.out.println("Datos insertados correctamente en la tabla PLANES_DE_CONSUMO.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar datos en la tabla PLANES_DE_CONSUMO: " + e.getMessage());
        }
    }
}

