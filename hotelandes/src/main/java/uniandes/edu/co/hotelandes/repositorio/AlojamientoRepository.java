package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Alojamiento;

public interface AlojamientoRepository extends JpaRepository<Alojamiento, Integer>  {
 

        
    @Query(value = "SELECT * FROM Alojamiento", nativeQuery = true)
    Collection<Alojamiento> darAlojamientos();

    @Query(value = "SELECT * FROM Alojamiento WHERE id= :id", nativeQuery = true)
    Alojamiento darAlojamiento(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Alojamiento(id, USUARIO_ALOJAMIENTO_ID, CHECK_IN_ALOJAMIENTO_ID, CHECK_OUT_ALOJAMIENTO_ID) VALUES(1, :usuario_id, :checkInId, :checkOutId)", nativeQuery = true)
    void insertarAlojamiento(@Param("usuario_id") Integer usuario_id, @Param("checkInId") Integer checkInId, @Param("checkOutId") Integer checkOutId );

    @Modifying
    @Transactional
    @Query(value = "UPDATE Alojamiento CHECK_IN_ALOJAMIENTO_ID = :checkInId, CHECK_OUT_ALOJAMIENTO_ID= :checkOutId WHERE id= :id", nativeQuery = true)
    void updateAlojamiento(@Param("id") Integer id, @Param("checkInId") Integer checkInId, @Param("checkOutId") Integer checkOutId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Alojamiento WHERE id= :id", nativeQuery = true)
    void deleteAlojamiento(@Param("id") Integer id);

}
