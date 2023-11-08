package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_tienda {
    public static void main(String[] args) {
        // Reemplaza con tu URL de conexión, usuario y contraseña.
        String jdbcUrl = "jdbc:oracle:thin:@tu_servidor_oracle:puerto/servicio";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO TIENDA (ID, NOMBRE) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            // Asumiendo que quieres insertar 20000 registros con nombres de tienda aleatorios.
            for (int i = 1; i <= 20000; i++) {
                int id = i;
                String nombre = "Tienda" + i;

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nombre);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

