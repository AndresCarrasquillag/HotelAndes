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
        int getFRECUENCIA();
        int getservicios_id();
    }

    
    @Query(value = "SELECT * FROM Consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();

    @Query(value = "SELECT servicios_id, COUNT(*) as FRECUENCIA FROM Consumos\r\n" + //
            "WHERE FECHA_DE_PAGO BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE\r\n" + //
            "GROUP BY servicios_id HAVING COUNT(*) < 156", nativeQuery = true)
    Collection<RespInfoConsumos> darServiciosDeBajaDemanda();
    
    @Query(value="SELECT SUM(COSTO) AS Consumo_Total FROM CONSUMOS WHERE ID_USUARIO = :id AND FECHA_DE_PAGO BETWEEN TO_DATE(:fechaInicio,'YYYY-MM-DD') AND TO_DATE(:fechaFin,'YYYY-MM-DD')", nativeQuery=true)
    Integer darConsumosUsuario(@Param("id") Integer id, @Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);

    @Query(value = "SELECT servicios_id, COUNT(*) as frecuencia FROM Consumos GROUP BY servicios_id ORDER BY frecuencia DESC FETCH FIRST 20 ROWS ONLY", nativeQuery = true)
    Collection<RespInfoConsumos> darServiciosPopulares();


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

}
