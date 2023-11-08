package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class carga_datos_alojamiento {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO ALOJAMIENTO (id, habitacion, fecha_ingreso, fecha_salida, usuario) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 1; i <= 30000; i++) {
                int id = i;
                int habitacion = 100 + random.nextInt(900); // Assuming room numbers range from 100 to 999
                long milis = System.currentTimeMillis() + (long) (random.nextDouble() * (10L * 365 * 24 * 60 * 60 * 1000)); // Up to 10 years into the future
                Date fechaIngreso = new Date(milis);
                Date fechaSalida = new Date(milis + (1 + random.nextInt(14)) * 24 * 60 * 60 * 1000); // Stays of 1 to 14 days
                String usuarioId = "USUARIO" + i; // Assuming you want to concatenate 'USUARIO' with the ID

                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, habitacion);
                preparedStatement.setString(3, dateFormat.format(fechaIngreso));
                preparedStatement.setString(4, dateFormat.format(fechaSalida));
                preparedStatement.setString(5, usuarioId);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}