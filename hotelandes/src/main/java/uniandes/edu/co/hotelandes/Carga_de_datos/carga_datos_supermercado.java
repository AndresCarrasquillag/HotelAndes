package uniandes.edu.co.hotelandes.Carga_de_datos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_supermercado {
    public static void main(String[] args) {
        
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {
            String sql = "INSERT INTO SUPERMERCADO (ID, NOMBRE) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            
            for (int i = 1; i <= 20000; i++) {
                int id = i;
                
                String nombre = "Super" + random.nextInt(1000);

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nombre);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
