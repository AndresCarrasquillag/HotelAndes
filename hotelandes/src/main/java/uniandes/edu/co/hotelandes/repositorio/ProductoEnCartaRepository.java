package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.ProductosEnCarta;

public interface ProductoEnCartaRepository extends JpaRepository<ProductosEnCarta, Integer> {

    @Query(value = "SELECT * Productos_en_cartas", nativeQuery = true)
    Collection<ProductosEnCarta> darProductosEnCartas();

    @Query(value = "SELECT * FROM Productos_en_cartas WHERE producto_id= :producto_id AND carta_id= :carta_id", nativeQuery = true)
    ProductosEnCarta darProductoEnCarta(@Param("producto_id") Integer producto_id, @Param("carta_id") Integer carta_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Productos_en_cartas SET producto_id= :producto_id, carta_id= :carta_id WHERE carta_id= :carta_id AND producto_id= :producto_id", nativeQuery = true)
    void updateProductoEnCarta(@Param("carta_id") Integer carta_id, @Param("producto_id") Integer producto_id, @Param("producto_id") Integer producto, @Param("carta_id") Integer carta);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Productos_en_cartas (producto_id, carta_id) VALUES (:producto_id, :carta_id)", nativeQuery = true)
    void insertProductoEnCarta(@Param("producto_id") Integer producto_id, @Param("carta_id") Integer carta_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Productos_en_cartas WHERE producto_id= :producto_id AND carta_id= :carta_id", nativeQuery = true)
    void deleteProductoEnCarta(@Param("producto_id") Integer producto_id, @Param("carta_id") Integer carta_id);
    
}
