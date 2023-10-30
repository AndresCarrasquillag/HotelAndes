package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Check_out;

public interface CheckOutRepository extends JpaRepository<Check_out, Integer> {
    @Query(value= "SELECT * FROM CHECK_OUT", nativeQuery=true)
    Collection<Check_out> darCHECK_OUTs();
    
    @Query(value="SELECT * FROM CHECK_OUT WHERE id=:id", nativeQuery=true)
    Check_out darCHECK_OUT(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO CHECK_OUT (id, horaSalida) VALUES(1, :horaSalida)", nativeQuery = true)
    void insertarCHECK_OUT(@Param("horaSalida") String horaSalida);

    @Modifying
    @Transactional
    @Query(value="UPDATE CHECK_OUT SET horaSalida=:horaSalida WHERE id=:id", nativeQuery = true)
    void actualizarCHECK_OUT(@Param("id") Integer id, @Param("horaSalida") String horaSalida);
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CHECK_OUT WHERE id=:id", nativeQuery = true)
    void eliminarCHECK_OUT(@Param("id") Integer id);
    
}
 
