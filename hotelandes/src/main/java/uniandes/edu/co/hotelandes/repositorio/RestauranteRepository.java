package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{
    @Query(value= "SELECT * FROM Restaurante", nativeQuery=true)
    Collection<Restaurante> darRestaurantes();
    
    @Query(value="SELECT * FROM Restaurante WHERE id=id", nativeQuery=true)
    Restaurante darRestaurante(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO Restaurante (id, estilo) VALUES(1, :estilo)",  nativeQuery=true)
    void insertarRestaurante(@Param("estilo") String estilo);

    @Modifying
    @Transactional
    @Query(value="UPDATE Restaurante SET estilo=:estilo WHERE id=:id",  nativeQuery=true)
    void actualizarRestaurante(@Param("id") Integer id, @Param("estilo") String estilo);
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Restaurante WHERE id=:id", nativeQuery = true)
    void eliminarRestaurante(@Param("id") Integer id);

   
}
