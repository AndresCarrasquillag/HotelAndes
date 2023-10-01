package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Supermercado;

public interface SupermercadoRepository extends JpaRepository<Supermercado, Integer>  {
 

        
    @Query(value = "SELECT * FROM Supermercados", nativeQuery = true)
    Collection<Supermercado> darSupermercados();

    @Query(value = "SELECT FROM Supermercados WHERE id= :id", nativeQuery = true)
    Supermercado darSupermercado(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Supermercados(id, nombre) VALUES(Hotelandes_sequence.nextval, :nombre)", nativeQuery = true)
    void insertarSupermercado(@Param("nombre") String string);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Supermercados nombre= :nombre WHERE id= :id", nativeQuery = true)
    void updateSupermercado(@Param("id") Integer id, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Supermercados WHERE id= :id", nativeQuery = true)
    void deleteSupermercado(@Param("id") Integer id);

}
