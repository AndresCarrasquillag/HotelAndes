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

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Servicios(id, costo, tipo_servicio, horario) VALUES(sq_servicios.nextval, :costo, :tipo_servicio, :horario)", nativeQuery = true)
    void insertServicio(@Param("costo") Integer costo,@Param("tipo") String tipo,@Param("horario") Date horario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Servicios costo= :costo, tipo_servicio=:tipo, horario= :horario  WHERE id= :id", nativeQuery = true)
    void updateServicio(@Param("id") Integer id,@Param("costo") Integer costo,@Param("tipo") String tipo,@Param("horario") Date horario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Servicios WHERE id= :id", nativeQuery = true)
    void deleteServicio(@Param("id") Integer id);
}
