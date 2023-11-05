package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.ReservaHabitacion;

public interface ReservaHabitacionRepository extends JpaRepository<ReservaHabitacion, Integer> {

    @Query(value = "SELECT * FROM Reservas_habitaciones", nativeQuery = true)
    Collection<ReservaHabitacion> darReservasHabitacion();

    @Query(value = "SELECT * FROM Reservas_habitaciones WHERE habitaciones_id= :habitaciones_id AND reservas_id= :reservas_id", nativeQuery = true)
    ReservaHabitacion darReservaHabitacion(@Param("habitaciones_id") Integer habitaciones_id, @Param("reservas_id") Integer reservas_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Reservas_habitaciones (habitaciones_id, reservas_id) VALUES (:habitaciones_id, :reservas_id)", nativeQuery = true)
    void insertReservaHabitacion(@Param("habitaciones_id") Integer habitaciones_id, @Param("reservas_id") Integer reservas_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Reservas_habitaciones SET habitaciones_id= :habitaciones_id_nuevo, reservas_id= :reservas_id_nuevo WHERE habitaciones_id= :habitaciones_id AND reservas_id= :reservas_id", nativeQuery = true)
    void updateReservaHabitacion(@Param("habitaciones_id") Integer habitaciones_id, @Param("reservas_id") Integer reservas_id, @Param("habitaciones_id_nuevo") Integer habitaciones_id_nuevo, @Param("reservas_id_nuevo") Integer reservas_id_nuevo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Reservas_habitaciones WHERE habitaciones_id = :habitaciones_id AND reservas_id= :reservas_id", nativeQuery = true)
    void deleteReservaHabitacion(@Param("habitaciones_id") Integer habitaciones_id, @Param("reservas_id") Integer reservas_id);
    
}
