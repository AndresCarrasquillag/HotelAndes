package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {
    
    @Query(value = "SELECT * FROM Servicios", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM Servicios WHERE id= :id", nativeQuery = true)
    Servicio darServicio(@Param("id") Integer id);

    @Query(value = "SELECT * FROM Servicios WHERE COSTO BETWEEN :precioBajo AND :precioAlto", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecioEnRango(@Param("precioBajo") Integer precioBajo, @Param("precioAlto") Integer precioAlto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Servicios(id, horario, costo, tipo_servicio) VALUES(1, :horario, :costo, :tipo)", nativeQuery = true)
    void insertServicio(@Param("horario") Date horario, @Param("costo") Integer costo, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Servicios horario= :horario, costo= :costo, tipo_servicio=:tipo WHERE id= :id", nativeQuery = true)
    void updateServicio(@Param("id") Integer id, @Param("horario") Date horario, @Param("costo") Integer costo, @Param("tipo") String tipo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Servicios WHERE id= :id", nativeQuery = true)
    void deleteServicio(@Param("id") Integer id);
}
