package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_hoteles {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {

            String sql = "INSERT INTO HOTELES (ID, NOMBRE, TELEFONO) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 3; i <= 5000; i++) {
                int id = i; 
                String nombre = "Hotel" + i; 
                int telefono = 1000000 + random.nextInt(9000000); 

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nombre);
                preparedStatement.setInt(3, telefono);

                preparedStatement.executeUpdate();
            }

            System.out.println("Datos insertados correctamente en la tabla HOTELES.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar datos en la tabla HOTELES: " + e.getMessage());
        }
    }
}
