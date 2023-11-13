package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class carga_datos_salon {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320"; 
        String contraseña = "LyGscAGdEemx"; 

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO salon (ID, DISPONIBILIDAD, HORA_LIMPIEZA, TIPO, DURACION) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            String[] tipo = {"reuniones", "conferencias"};
            for (int i = 1; i <= 2000; i++) {
                int id = i;
                String disponibilidad = random.nextBoolean() ? "Y" : "N"; 
                long offset = TimeUnit.HOURS.toMillis(random.nextInt(24)); 
                long startOfDay = System.currentTimeMillis() - System.currentTimeMillis() % (24 * 60 * 60 * 1000); 
                Timestamp horaLimpieza = new Timestamp(startOfDay + offset); 
                String tipoServicio = tipo[random.nextInt(tipo.length)];
                int duracion = 1 + random.nextInt(8);

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, disponibilidad);
                preparedStatement.setTimestamp(3, horaLimpieza);
                preparedStatement.setString(4, tipoServicio );
                preparedStatement.setInt(5, duracion);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

