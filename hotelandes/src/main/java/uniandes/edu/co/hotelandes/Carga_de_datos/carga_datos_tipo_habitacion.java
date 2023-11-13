package uniandes.edu.co.hotelandes.Carga_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class carga_datos_tipo_habitacion {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        String[] nombresTipos = {
            "Estándar", "Junior Suite", "Suite", "Doble", "Familiar"
        };
        String[] descripciones = {
            "Habitación estándar con servicios básicos.",
            "Junior Suite con área de trabajo adicional.",
            "Suite amplia con sala de estar.",
            "Habitación doble con dos camas.",
            "Habitación familiar con múltiples camas y más espacio."
        };

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña)) {
            String sql = "INSERT INTO tipos_habitacion (NOMBRE_TIPO,  DESCRIPCION,ID) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            
            for (int i = 1; i <= 5000; i++) {
                
                int index = (i - 1) % nombresTipos.length;

                preparedStatement.setInt(3, i); 
                preparedStatement.setString(1, nombresTipos[index]); 
                preparedStatement.setString(2, descripciones[index]);

                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

