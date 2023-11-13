package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class carga_datos_reservas {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {

            String sql = "INSERT INTO RESERVAS (ID, FECHA_HORA_INICIO, FECHA_HORA_FIN, PRECIO, SEDES_ID, PLANES_DE_CONSUMO_ID, USUARIOS_ID) VALUES (?, TO_DATE(?, 'DD/MM/YY'), TO_DATE(?, 'DD/MM/YY'), ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 1; i <= 5000; i++) {
                int id = i;
                Calendar fechaInicio = Calendar.getInstance();
                fechaInicio.add(Calendar.DAY_OF_YEAR, random.nextInt(365)); // Fecha de inicio aleatoria en el año

                Calendar fechaFin = (Calendar) fechaInicio.clone();
                int dias = random.nextInt(30) + 1; // Duración de la reserva entre 1 y 30 días
                fechaFin.add(Calendar.DAY_OF_YEAR, dias); 

                String fechaInicioStr = dateFormat.format(fechaInicio.getTime());
                String fechaFinStr = dateFormat.format(fechaFin.getTime());

                long precio = 1000000L * dias; // Precio basado en la duración de la reserva

                int sedesId = 1 + random.nextInt(5000); 
                int planesDeConsumoId = 1 + random.nextInt(5000); 
                int usuariosId = 1 + random.nextInt(5000); 

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, fechaInicioStr);
                preparedStatement.setString(3, fechaFinStr);
                preparedStatement.setLong(4, precio);
                preparedStatement.setInt(5, sedesId);
                preparedStatement.setInt(6, planesDeConsumoId);
                preparedStatement.setInt(7, usuariosId);

                preparedStatement.executeUpdate();
            }

            System.out.println("Datos insertados correctamente en la tabla RESERVAS.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar datos en la tabla RESERVAS: " + e.getMessage());
        }
    }
}

