package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    
    @Query(value = "SELECT * FROM Usuarios", nativeQuery = true)
    Collection<Usuario> darUsuarios();

    @Query(value = "SELECT NVL((SELECT roles.id_rol FROM usuarios INNER JOIN roles ON roles.id_rol = usuarios.roles_id_rol WHERE usuarios.\"user\" = :usuario AND usuarios.\"PASSWORD\" = :contraseña), -1) FROM dual", nativeQuery = true)
    Integer logIn(@Param("usuario") String usuario, @Param("contraseña") String contraseña);


    @Query(value = "SELECT DISTINCT consumos.id_usuario FROM consumos INNER JOIN servicios ON consumos.servicios_id = servicios.id WHERE servicios.costo > 400 AND consumos.alojamiento IS NOT NULL", nativeQuery = true)
    Collection<Integer> clientesServicioCaro(@Param("costo") Integer costo);

    @Query(value = "SELECT DISTINCT consumos.id_usuario FROM consumos INNER JOIN servicios ON consumos.servicios_id = servicios.id WHERE servicios.costo > 400 AND consumos.alojamiento IS NOT NULL", nativeQuery = true)
    Collection<Integer> clientesSalonSpa();

    @Query(value = "SELECT id FROM (SELECT EXTRACT(YEAR FROM alojamiento.fecha_ingreso) AS year, CEIL(EXTRACT(MONTH FROM alojamiento.fecha_ingreso) / 3) AS quarter, usuarios.id FROM alojamiento INNER JOIN usuarios ON alojamiento.usuario = usuarios.id GROUP BY EXTRACT(YEAR FROM alojamiento.fecha_ingreso), CEIL(EXTRACT(MONTH FROM alojamiento.fecha_ingreso) / 3), usuarios.id) GROUP BY id HAVING COUNT(*) > 3", nativeQuery = true)
    Collection<Integer> estanciasTrimestrales();

    @Query(value = "SELECT ID, user, PASSWORD, NOMBRE, TELEFONO, ROLES_ID_ROL, ALOJAMIENTO_ID1 FROM Usuarios WHERE id= :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuarios(id, \"user\", password, nombre, telefono, roles_id_rol) VALUES(SQ_USUARIOS.nextval, :user, :password, :nombre, :telefono, :roles_id_rol)", nativeQuery = true)
    void insertUsuario(@Param("user") String user, @Param("password") String password, @Param("nombre") String nombre, @Param("telefono") String telefono, @Param("roles_id_rol") Integer roles_id_rol);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuarios SET \"user\"= :user, password= :password, nombre= :nombre, telefono= :telefono, roles_id_rol= :roles_id_rol WHERE id= :id", nativeQuery = true)
    void updateUsuarios(@Param("id") Integer id, @Param("user") String user, @Param("password") String password, @Param("nombre") String nombre, @Param("telefono") String telefono, @Param("roles_id_rol") Integer roles_id_rol);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuarios WHERE id= :id", nativeQuery = true)
    void deleteUsuario(@Param("id") Integer id);
}
