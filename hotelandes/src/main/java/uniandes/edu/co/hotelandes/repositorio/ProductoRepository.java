package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
    
    @Query(value= "SELECT * FROM productos", nativeQuery=true)
    Collection<Producto> darProductos();
    
    @Query(value="SELECT * FROM productos WHERE id=:id", nativeQuery=true)
    Producto darProducto(@Param("id") Integer id);

    @Modifying
    @Transactional
<<<<<<< HEAD
    @Query(value ="INSERT INTO productos (id, nombre, costo) VALUES(Hotelandes_sequence.nextval, :nombre, :costo)")
    void insertarProducto(@Param("nombre") String nombre,@Param("costo") Integer costo);
=======
    @Query(value ="INSERT INTO productos (id, nombre, costo) VALUES(1, :nombre, :costo)", nativeQuery = true)
    void insertarProducto(@Param("nombre") String nombre, @Param("costo") Integer costo);
>>>>>>> origin/main

    @Modifying
    @Transactional
    @Query(value="UPDATE productos  SET nombre=:nombre,  costo=:costo WHERE id=:id", nativeQuery = true)
    void actualizarProducto(@Param("id") Integer id, @Param("nombre") String nombre,@Param("costo") Integer costo);
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id=:id", nativeQuery = true)
    void eliminarProducto(@Param("id") Integer id);
}



   