package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Carga_datos_lavanderia {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO lavanderia (id, CANTIDADPRENDAS, PRECIOPORPRENDA) VALUES (?, ?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            
            for (int i = 1; i <= 2000; i++) {
                int id = i;
                int CANTIDADPRENDAS = 1 + random.nextInt(7); 
                int PRECIOPORPRENDA = 10000 + random.nextInt(60001);
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, CANTIDADPRENDAS);
                preparedStatement.setInt(3, PRECIOPORPRENDA);
            
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
}
