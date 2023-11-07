package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Supermercado;
import uniandes.edu.co.hotelandes.modelo.Servicio;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer>  {
 

        
    @Query(value = "SELECT * FROM Supermercado", nativeQuery = true)
    Collection<Supermercado> darSupermercados();

    @Query(value = "SELECT * FROM Supermercado WHERE id= :id", nativeQuery = true)
    Supermercado darSupermercado(@Param("id") Integer id);

    @Modifying    
    @Transactional
    @Query(value = "INSERT INTO Supermercado(id, nombre) VALUES(:id, :nombre)", nativeQuery = true)
    void insertarSupermercado(@Param("id") Integer id,@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Supermercado SET nombre= :nombre WHERE id= :id", nativeQuery = true)
    void updateSupermercado(@Param("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Supermercado WHERE id= :id", nativeQuery = true)
    void deleteSupermercado(@Param("id") Integer id);

}

