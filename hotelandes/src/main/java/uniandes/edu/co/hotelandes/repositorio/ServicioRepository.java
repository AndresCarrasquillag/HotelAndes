package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;
import java.util.Date;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    public interface RespInfoServs {
        int getid_Servicio();
        int getcosto_servicio();
        String getTipo_servicio();
        Date getFecha_de_pago();
    }
    
    @Query(value = "SELECT SERVICIOS.ID AS id_Servicio, CONSUMOS.COSTO AS costo_servicio, SERVICIOS.TIPO_SERVICIO AS Tipo_servicio, CONSUMOS.FECHA_DE_PAGO AS Fecha_de_pago FROM SERVICIOS, CONSUMOS WHERE SERVICIOS.ID = CONSUMOS.SERVICIOS_ID AND FECHA_DE_PAGO BETWEEN TO_DATE(:fechaInicio, 'YYYY-MM-DD') AND TO_DATE(:fechaFin, 'YYYY-MM-DD') AND CONSUMOS.COSTO BETWEEN :costo1 AND :costo2 AND SERVICIOS.TIPO_SERVICIO=:tipo_servicio", nativeQuery = true)
    Collection<RespInfoServs> darServiciosCombinado(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin, @Param("costo1") int costo1, @Param("costo2") int costo2, @Param("tipo_servicio") String tipo_servicio);

    @Query(value = "SELECT * FROM Servicios WHERE servicios.id<200", nativeQuery = true)
    Collection<Servicio> darServicios();

    @Query(value = "SELECT * FROM Servicios WHERE id= :id", nativeQuery = true)
    Servicio darServicio(@Param("id") Integer id);

    @Query(value = "SELECT * FROM Servicios WHERE COSTO BETWEEN :precioBajo AND :precioAlto", nativeQuery = true)
    Collection<Servicio> darServiciosPorPrecioEnRango(@Param("precioBajo") Integer precioBajo, @Param("precioAlto") Integer precioAlto);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Servicios(id, costo, tipo_servicio, horario) VALUES(sq_servicios.nextval, :costo, :tipo_servicio, :horario)", nativeQuery = true)
    void insertServicio(@Param("costo") Integer costo,@Param("tipo") String tipo,@Param("horario") Date horario);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Servicios costo= :costo, tipo_servicio=:tipo, horario= :horario  WHERE id= :id", nativeQuery = true)
    void updateServicio(@Param("id") Integer id,@Param("costo") Integer costo,@Param("tipo") String tipo,@Param("horario") Date horario);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Servicios WHERE id= :id", nativeQuery = true)
    void deleteServicio(@Param("id") Integer id);
}
