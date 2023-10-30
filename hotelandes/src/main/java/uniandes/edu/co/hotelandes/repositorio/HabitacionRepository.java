package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

    @Query(value = "SELECT * FROM Habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();
    
    @Query(value = "SELECT * FROM Habitaciones WHERE id= :id", nativeQuery = true)
    Habitacion darHabitacion(@Param("id") Integer id);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Habitaciones (id, capacidad, costo) VALUES(1, :capacidad, :costo)", nativeQuery = true)
    void insertarHabitacion(@Param("capacidad") Integer capacidad, @Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Habitaciones SET capacidad= :capacidad, costo= :costo WHERE id= :id", nativeQuery = true)
    void updateHabitacion(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("costo") Integer costo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Habitaciones WHERE id= :id", nativeQuery = true)
    void deleteHabitacion(@Param("id") Integer id);

    @Modifying
    @Query(value = "SELECT SUM(consumos.costo) FROM Habitaciones INNER JOIN consumos ON consumos.habitacion_id = :id WHERE consumos.fecha_de_pago >= TO_DATE(:fecha, 'YYYY-MM-DD')", nativeQuery = true)
    Integer darIngreso(@Param("id") Integer id, @Param("fecha") String fecha);


}