package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Check_In;

public interface CheckInRepository extends JpaRepository<Check_In, Integer> {
    @Query(value= "SELECT * FROM CHECK_IN", nativeQuery=true)
    Collection<Check_In> darCHECK_INs();
    
    @Query(value="SELECT * FROM CHECK_IN WHERE id=:id", nativeQuery=true)
    Check_In darCHECK_IN(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO CHECK_IN (id, horaEntrada) VALUES(1, :horaEntrada)", nativeQuery = true)
    void insertarCHECK_IN(@Param("horaEntrada") String horaEntrada);

    @Modifying
    @Transactional
    @Query(value="UPDATE CHECK_IN SET horaEntrada=:horaEntrada WHERE id=:id", nativeQuery = true)
    void actualizarCHECK_IN(@Param("id") Integer id, @Param("horaEntrada") String horaEntrada);
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CHECK_IN WHERE id=:id", nativeQuery = true)
    void eliminarCHECK_IN(@Param("id") Integer id);
    
}
 
