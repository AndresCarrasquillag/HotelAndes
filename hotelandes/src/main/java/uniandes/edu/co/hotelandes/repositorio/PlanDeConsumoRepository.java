package uniandes.edu.co.hotelandes.repositorio;


import java.util.Collection;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.PlanesDeConsumo;

public interface PlanDeConsumoRepository extends JpaRepository<PlanesDeConsumo, Integer>{

    @Query(value = "SELECT * FROM Planes_de_consumo", nativeQuery = true)
    Collection<PlanesDeConsumo> darPlanesDeConsumo();

    @Query(value = "SELECT FROM Planes_de_consumo WHERE id=:id", nativeQuery = true)
    PlanesDeConsumo darPlanDeConsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Planes_de_consumo (id, nombre, descripcion, descuento) VALUES(1, :nombre, :descripcion, :descuento)", nativeQuery = true)
    void insertPlanDeConsumo(@Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("descuento") Integer descuento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Planes_de_consumo SET nombre = :nombre, descripcion= :descripcion, descuento= :descuento WHERE id= :id", nativeQuery = true)
    void updatePlanDeConsumo(@Param("id") Integer id, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("descuento") Integer descuento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Planes_de_consumo WHERE id=:id", nativeQuery = true)
    void deletePlanesDeConsumo(@Param("id") Integer id);
    
}
