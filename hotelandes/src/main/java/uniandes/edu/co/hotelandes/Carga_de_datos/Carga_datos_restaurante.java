package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Carga_datos_restaurante {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO restaurante (id, Estilo, CARTAS_ID) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
            Random random = new Random();

            
            String[] estilos = {"Italiano", "Mexicano", "Chino", "Americano", "Indio", "Francés", "Japonés"}; 

            for (int i = 1; i <= 5000; i++) {
                int id = i;
                String estilo = estilos[random.nextInt(estilos.length)]; 
                int cartasId = i; 
                
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, estilo);
                preparedStatement.setInt(3, cartasId);
            
                preparedStatement.executeUpdate();
            }
            
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }
}
