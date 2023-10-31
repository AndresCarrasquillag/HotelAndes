package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Spa;


public interface SpaRepository extends JpaRepository<Spa, Integer> {


      @Query(value = "SELECT * FROM Spa", nativeQuery = true)
    Collection<Spa> darSpas();

    @Query(value = "SELECT * FROM Spa WHERE id= :id", nativeQuery = true)
    Spa darSpa(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Spa(id, duracion, tipo_servicio) VALUES(1, :duracion, :tipo_servicio)", nativeQuery = true)
    void insertSpa(@Param("duracion") String duracion, @Param("tipo_servicio") String tipo_servicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Spa duracion= :duracion, Tipo_servicio= :Tipo_servicio WHERE id= :id", nativeQuery = true)
    void updateSpa(@Param("id") Integer id, @Param("duracion") String duracion, @Param("Tipo_servicio") String Tipo_servicio);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Spa WHERE id= :id", nativeQuery = true)
    void deleteSpa(@Param("id") Integer id);
    
}
