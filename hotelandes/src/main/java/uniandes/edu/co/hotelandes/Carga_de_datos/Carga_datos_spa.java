package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Carga_datos_spa {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO SPA (id,DURACION, TIPO_SERVICIO) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 1; i <= 1000; i++) {
                int id = i;
                int duracion = 1 + random.nextInt(8); 
                String tipoServicio = "s" ;

                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, duracion);
                preparedStatement.setString(3, tipoServicio);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
