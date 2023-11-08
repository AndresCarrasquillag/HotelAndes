package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class carga_datos_alojamiento {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {
            String sql = "INSERT INTO ALOJAMIENTO (id, habitacion, fecha_ingreso, fecha_salida, usuario) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 1; i <= 10000; i++) {
                int id = i;
                int habitacion = 100 + random.nextInt(900); 
                long milisIngreso = System.currentTimeMillis() + (long) (random.nextDouble() * (10L * 365 * 24 * 60 * 60 * 1000));
                long milisSalida = milisIngreso + (1 + random.nextInt(14)) * 24 * 60 * 60 * 1000; 
                int usuarioId = 1000 + random.nextInt(9000); 

                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, habitacion);
                preparedStatement.setDate(3, new Date(milisIngreso));
                preparedStatement.setDate(4, new Date(milisSalida));
                preparedStatement.setInt(5, usuarioId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
