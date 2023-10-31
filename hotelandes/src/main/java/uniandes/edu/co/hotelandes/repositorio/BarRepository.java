package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Bar;


public interface BarRepository extends JpaRepository<Bar, Integer> {
    @Query(value= "SELECT * FROM Bares", nativeQuery=true)
    Collection<Bar> darBares();
    
    @Query(value="SELECT * FROM Bares WHERE id=:id", nativeQuery=true)
    Bar darBar(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO Bares (id, estilo) VALUES(1, :estilo)", nativeQuery = true)
    void insertarBar(@Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value="UPDATE Bares SET estilo=:estilo WHERE id=:id", nativeQuery = true)
    void actualizarBar(@Param("id") Integer id, @Param("estilo") String estilo);
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Bares WHERE id=:id", nativeQuery = true)
    void eliminarBar(@Param("id") Integer id);
    
}
