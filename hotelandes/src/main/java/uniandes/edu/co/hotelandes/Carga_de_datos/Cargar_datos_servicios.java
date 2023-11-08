package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cargar_datos_servicios {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {
            String sql = "INSERT INTO SERVICIOS (ID, COSTO, TIPO_SERVICIO, HORARIO_DE_SERVICIO) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();
            String[] tipos = {"lavanderia", "spa", "salon", "tienda", "supermercado", "gimnasios", "alojamiento", "piscina", "restaurante"};

            for (int i =4858 ; i <= 250000; i++) {
                int id = i; 
                int costo = 100000 + random.nextInt(900000);
                String tipoServicio = tipos[random.nextInt(tipos.length)];

                long milisHoy = System.currentTimeMillis();
                long milis10Anios = 10L * 365 * 24 * 60 * 60 * 1000;
                long milisFechaAleatoria = ThreadLocalRandom.current().nextLong(milisHoy - milis10Anios, milisHoy);
                java.sql.Date fechaAleatoria = new java.sql.Date(milisFechaAleatoria);

                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, costo);
                preparedStatement.setString(3, tipoServicio);
                preparedStatement.setDate(4, fechaAleatoria);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    
    