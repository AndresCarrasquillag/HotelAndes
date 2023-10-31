package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Prestamos;
public interface PrestamosRepository extends JpaRepository<Prestamos, Integer>  {
    
     @Query(value= "SELECT * FROM Prestamos", nativeQuery=true)
    Collection<Prestamos> darPrestamos();
    
    @Query(value="SELECT * FROM Prestamos WHERE id=id", nativeQuery=true)
    Prestamos darPrestamo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO Prestamos (id, nombre_utensilio,estado,precio_utensilio) VALUES(sq_prestamos.nextval, :nombre_utensilio, :estado, :precio_utensilio)", nativeQuery = true)
    void insertarPrestamo(@Param("nombre_utensilio") String nombre_utensilio, @Param("estado") String estado, @Param("precio_utensilio") String precio_utensilio );

    @Modifying
    @Transactional
    @Query(value="UPDATE Prestamos SET nombre_utensilio=:nombre_utensilio, estado=:estado, precio_utensilio:precio_utensilio WHERE id=:id ", nativeQuery = true)
    void actualizarPrestamo(@Param("id") Integer id, @Param("nombre_utensilio") String nombre_utensilio, @Param("estado") String estado, @Param("precio_utensilio") String precio_utensilio );
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Prestamos WHERE id=:id", nativeQuery = true)
    void eliminarPrestamo(@Param("id") Integer id);

    
    
}
