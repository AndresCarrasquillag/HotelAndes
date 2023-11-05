package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Alojamiento;

public interface AlojamientoRepository extends JpaRepository<Alojamiento, Integer>  {

    public interface RespInfoAlojamientos {
        int getSuma_dias();
        int getUsuario();
    }

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

    @Query(value = "SELECT usuario_id AS Usuario, NVL(Suma_dias, 0) AS Suma_dias\r\n" + //
            "FROM (\r\n" + //
            "    SELECT ALOJAMIENTO.USUARIO AS usuario_id, \r\n" + //
            "           SUM(alojamiento.fecha_salida - alojamiento.fecha_ingreso) AS Suma_dias \r\n" + //
            "    FROM alojamiento \r\n" + //
            "    WHERE alojamiento.fecha_ingreso BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE \r\n" + //
            "    GROUP BY ALOJAMIENTO.USUARIO\r\n" + //
            ") \r\n" + //
            "WHERE Suma_dias > 14", nativeQuery = true)
    Collection<RespInfoAlojamientos> darBuenosClientesPorAlojamiento();
}
