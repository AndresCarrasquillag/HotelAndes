  
package uniandes.edu.co.hotelandes.Carga_de_datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class carga_datos_usuario {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@fn4.oracle.virtual.uniandes.edu.co:1521/PROD";
        String usuario = "ISIS2304D07202320";
        String contraseña = "LyGscAGdEemx";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            String sql = "INSERT INTO USUARIOS (ID, USUARIO, PASSWORD, NOMBRE, TELEFONO, ROLES_ID_ROL) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            Random random = new Random();

            for (int i = 1; i <= 20000; i++) {
                int id = i;
                String usuarioId = "usuario" + i;
                String password = "password" + i;
                String nombre = "Nombre" + i;
                String telefono = "300" + (1000000 + random.nextInt(9000000));
                int rolesIdRol = 1 + random.nextInt(20000);

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, usuarioId);
                preparedStatement.setString(3, password);
                preparedStatement.setString(4, nombre);
                preparedStatement.setString(5, telefono);
                preparedStatement.setInt(6, rolesIdRol);
                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
