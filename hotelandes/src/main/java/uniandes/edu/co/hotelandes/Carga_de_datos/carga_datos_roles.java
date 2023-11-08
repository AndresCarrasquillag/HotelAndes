package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_roles {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        
        String[] tiposRoles = {"cliente", "recepcionista", "empleado", "administrador", "gerente"};

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO roles (id_rol, rol, descripcion) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Random random = new Random();

            for (int i = 1; i <= 5998; i++) {
                int id_rol = i;
                
                String rol = tiposRoles[random.nextInt(tiposRoles.length)];
                String descripcion = "Descripción del rol " + rol; 

                preparedStatement.setInt(1, id_rol);
                preparedStatement.setString(2, rol);
                preparedStatement.setString(3, descripcion);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

