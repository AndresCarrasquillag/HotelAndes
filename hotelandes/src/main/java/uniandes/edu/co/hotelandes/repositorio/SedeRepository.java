package uniandes.edu.co.hotelandes.repositorio;


import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.hotelandes.modelo.Sede;

public interface SedeRepository extends JpaRepository<Sede, Integer> {
    
    @Query(value = "SELECT * FROM Sedes", nativeQuery = true)
    Collection<Sede> darSedes();

    @Query(value = "SELECT * FROM Sedes WHERE id= :id", nativeQuery = true)
    Sede darSede(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Sedes(id, nombre, telefono, direccion, hoteles_id) VALUES(SQ_SEDES.nextval, :nombre, :telefono, :direccion ,  :hoteles_id)", nativeQuery = true)
    void insertSede(@Param("nombre") String nombre, @Param("telefono") Integer telefono, @Param("direccion") String direccion, @Param("hoteles_id") Integer hoteles_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Sedes SET nombre = :nombre, telefono = :telefono, direccion = :direccion, hoteles_id = :hoteles_id WHERE id = :id", nativeQuery = true)
    void updateSede(@Param("id") Integer id, @Param("nombre") String nombre, @Param("telefono") Integer telefono, @Param("direccion") String direccion, @Param("hoteles_id") Integer hoteles_id );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Sedes WHERE id= :id", nativeQuery = true)
    void deleteSede(@Param("id") Integer id);

    


    
}