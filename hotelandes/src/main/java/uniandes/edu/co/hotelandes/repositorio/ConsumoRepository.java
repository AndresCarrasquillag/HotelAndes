package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.transaction.Transactional;
import uniandes.edu.co.hotelandes.modelo.Consumo;

public interface ConsumoRepository extends JpaRepository<Consumo, Integer> {

    public interface RespInfoConsumos {
        int getSuma();
        int getFRECUENCIA();
        int getservicios_id();
        int getid_usuario();
        int getingresos_totales();
        Date getFECHA_DE_PAGO();
    }

    
    @Query(value = "SELECT * FROM Consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();

    @Query(value = "SELECT servicios_id, COUNT(*) as FRECUENCIA FROM Consumos\r\n" + //
            "WHERE FECHA_DE_PAGO BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE\r\n" + //
            "GROUP BY servicios_id HAVING COUNT(*) < 156", nativeQuery = true)
    Collection<RespInfoConsumos> darServiciosDeBajaDemanda();

    @Query(value = "SELECT FECHA_DE_PAGO, SUM(COSTO) AS ingresos_totales\r\n" + //
            "FROM consumos\r\n" + //
            "GROUP BY FECHA_DE_PAGO\r\n" + //
            "ORDER BY ingresos_totales DESC", nativeQuery = true)
    Collection<RespInfoConsumos> darFechasConMayorIngreso();

    @Query(value="SELECT SUM(COSTO) AS Consumo_Total FROM CONSUMOS WHERE ID_USUARIO = :id AND FECHA_DE_PAGO BETWEEN TO_DATE(:fechaInicio,'YYYY-MM-DD') AND TO_DATE(:fechaFin,'YYYY-MM-DD')", nativeQuery=true)
    Integer darConsumosUsuario(@Param("id") Integer id, @Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);

    @Query(value = "SELECT servicios_id, COUNT(*) as frecuencia FROM Consumos WHERE FECHA_DE_PAGO BETWEEN TO_DATE(:fechaInicio,'YYYY-MM-DD') AND TO_DATE(:fechaFin,'YYYY-MM-DD') GROUP BY servicios_id ORDER BY frecuencia DESC FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<RespInfoConsumos> darServiciosPopulares(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);


    @Query(value = "SELECT FROM Consumos WHERE id= :id", nativeQuery = true)
    Consumo darConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Consumos(id, costo, fecha_de_pago, descripcion) VALUES(:id, :costo, :fecha_de_pago, :descripcion)", nativeQuery = true)
    void insertConsumo(@Param("id") Integer id, @Param("costo") Integer costo, @Param("fecha_de_pago") Date fecha_de_pago, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Consumos SET costo= :costo, fecha_de_pago= :fecha_de_pago, descripcion= :descripcion WHERE id= :id", nativeQuery = true)
    void updateConsumo(@Param("id") Integer id, @Param("costo") Integer costo, @Param("fecha_de_pago") Date fecha_de_pago, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Consumos WHERE id= :id", nativeQuery = true)
    void deleteConsumo(@Param("id") Integer id);

    @Query(value = "SELECT SUM(consumos.costo) FROM CONSUMOS WHERE consumos.habitacion_id=:id AND consumos.fecha_de_pago BETWEEN TRUNC(SYSDATE , 'Year') AND SYSDATE", nativeQuery = true)
    Integer darIngreso(@Param("id") Integer id);

    @Query(value = "SELECT CONSUMOS.ID_USUARIO, SUM(consumos.costo) AS suma FROM CONSUMOS WHERE CONSUMOS.FECHA_DE_PAGO BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE GROUP BY CONSUMOS.ID_USUARIO HAVING SUM(consumos.costo)>100", nativeQuery = true)
    Collection<RespInfoConsumos> darBuenosClientesPorConsumo();

}
