package uniandes.edu.co.hotelandes.repositorio;


import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.TipoHabitacion;

public interface TipoHabitacionRepository extends JpaRepository<TipoHabitacion, Integer> {

    @Query(value = "SELECT * FROM Tipos_habitacion", nativeQuery = true)
    Collection<TipoHabitacion> darTiposHabitacion();

    @Query(value = "SELECT * FROM Tipos_habitacion WHERE id= :id", nativeQuery = true)
    TipoHabitacion darTipoHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Tipos_habitacion(id, descripcion, nombre_tipo) VALUES (1, :descripcion, :nombre_tipo)", nativeQuery = true)
    void insertTipoHabitacion(@Param("descripcion") String descripcion, @Param("nombre_tipo") String nombre_tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Tipos_habitacion SET descripcion= :descripcion, nombre_tipo= :nombre_tipo WHERE id= :id", nativeQuery = true)
    void updateTipoHabitacion(@Param("id") Integer id, @Param("descripcion") String descripcion, @Param("nombre_tipo") String nombre_tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Tipo_habitacion WHERE id= :id", nativeQuery = true)
    void deleteTipoHabiatcion(@Param("id") Integer id);
}
