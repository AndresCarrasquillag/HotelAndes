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

    @Query(value = "SELECT * FROM Consumos", nativeQuery = true)
    Collection<Consumo> darConsumos();

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
