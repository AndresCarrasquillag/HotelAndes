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

    @Query(value = "SELECT NVL((SELECT roles.id_rol FROM usuarios INNER JOIN roles ON roles.id_rol = usuarios.roles_id_rol WHERE usuarios.\"user\" = :usuario AND usuarios.\"PASSWORD\" = :contraseña), -1) FROM dual", nativeQuery = true)
    Integer estanciasTrimestrales(@Param("usuario") String usuario, @Param("contraseña") String contraseña);

    @Query(value = "SELECT ID, user, PASSWORD, NOMBRE, TELEFONO, ROLES_ID_ROL, ALOJAMIENTO_ID1 FROM Usuarios WHERE id= :id", nativeQuery = true)
    Usuario darUsuario(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Usuarios(id, user, password, nombre, telefono) VALUES(1, :user, :password, :nombre, :telefono)", nativeQuery = true)
    void insertUsuario(@Param("user") String user, @Param("password") String password, @Param("nombre") String nombre, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Usuarios SET user= :user, password= :password, nombre= :nombre, telefono= :telefono WHERE id= :id", nativeQuery = true)
    void updateUsuarios(@Param("id") Integer id, @Param("user") String user, @Param("password") String password, @Param("nombre") String nombre, @Param("telefono") String telefono);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuarios WHERE id= :id", nativeQuery = true)
    void deleteUsuario(@Param("id") Integer id);
}
