package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    
    @Query(value = "SELECT * FROM Reservas", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM Reservas WHERE id= :id", nativeQuery = true)
    Reserva darReserva(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Reservas (id, fecha_hora_inicio, fecha_hora_fin, precio) VALUES(1, :fecha_hora_inicio, :fecha_hora_fin, :precio)", nativeQuery = true)
    void insertReserva(@Param("fecha_hora_inicio") Date fecha_hora_inicio, @Param("fecha_hora_fin") Date fecha_hora_fin, @Param("precio") Integer precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Reservas SET fecha_hora_inicio= :fecha_hora_inicio, fecha_hora_fin= :fecha_hora_fin, precio= :precio precio= :precio WHERE id= :id", nativeQuery = true)
    void updateReservas(@Param("id") Integer id, @Param("fecha_hora_inicio") Date fecha_hora_inicio, @Param("fecha_hora_fin") Date fecha_hora_fin, @Param("precio") Integer precio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Reservas WHERE id= :id", nativeQuery = true)
    void deleteReserva(@Param("id") Integer id);
}
