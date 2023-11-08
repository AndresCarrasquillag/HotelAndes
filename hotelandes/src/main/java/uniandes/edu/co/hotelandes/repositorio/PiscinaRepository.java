package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, Integer> {
    
    @Query(value= "SELECT * FROM Piscina", nativeQuery=true)
    Collection<Piscina> darPiscinas();
    
    @Query(value="SELECT * FROM Piscina WHERE id=id", nativeQuery=true)
    Piscina darPiscina(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO Piscina (id, profundidad) VALUES(:id, :profundidad)", nativeQuery=true)
    void insertarPiscina(@Param("id") Integer id,@Param("profundidad") Integer profundidad);

    @Modifying
    @Transactional
    @Query(value="UPDATE  Piscina  SET  profundidad=:profundidad WHERE id=:id", nativeQuery=true)
    void actualizarPiscina(@Param("id") Integer id, @Param("profundidad") Integer profundidad);
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Piscina WHERE id=:id", nativeQuery = true)
    void eliminarPiscina(@Param("id") Integer id);

}
