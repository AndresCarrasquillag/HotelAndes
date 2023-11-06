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

    @Query(value = "SELECT NVL((SELECT SUM(alojamiento.fecha_salida - alojamiento.fecha_ingreso) FROM alojamiento WHERE alojamiento.habitacion = habitaciones.id AND alojamiento.fecha_ingreso >= ADD_MONTHS(SYSDATE, -12) AND alojamiento.fecha_ingreso <= SYSDATE) / 365 * 100, 0) AS porcentaje_ocupacion FROM habitaciones WHERE habitaciones.id= :id", nativeQuery = true)
    Float darOcupacionHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Alojamiento(id, usuario, fecha_ingreso, fecha_salida) VALUES(ALOJAMIENTO_SEQ.NEXTVAL, :usuario, :fecha_ingreso, :fecha_salida)", nativeQuery = true)
    void insertarAlojamiento(@Param("usuario") Integer usuario, @Param("fecha_ingreso") String fecha_ingreso, @Param("fecha_salida") String fecha_salida);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Alojamiento SET fecha_ingreso = :fecha_ingreso, fecha_salida= :fecha_salida WHERE id= :id", nativeQuery = true)
    void updateAlojamiento(@Param("id") Integer id, @Param("fecha_ingreso") String fecha_ingreso, @Param("fecha_salida") String fecha_salida);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Alojamiento WHERE id= :id", nativeQuery = true)
    void deleteAlojamiento(@Param("id") Integer id);

}
