package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    @Query(value = "SELECT * FROM Roles", nativeQuery = true)
    Collection<Rol> darRoles();

    @Query(value = "SELECT * FROM Roles WHERE id= :id", nativeQuery = true)
    Rol darRol(@Param("id") Integer id);
    
    @Modifying
    @Transactional
    @Query(value = "INSTERT INTO Roles(id_rol, rol, descripcion) VALUES(1, :rol, :descripcion)", nativeQuery = true)
    void insertarRol(@Param("rol") String rol, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Roles SET rol= :rol, descripcion= :descripcion WHERE id= :id", nativeQuery = true)
    void updateRol(@Param("id") Integer id, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Roles WHERE id= :id", nativeQuery = true)
    void deleteRol(@Param("id") Integer id);
}
