package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
    
    @Query(value= "SELECT * FROM hoteles", nativeQuery=true)
    Collection<Hotel> darHoteles();
    
    @Query(value="SELECT * FROM hoteles WHERE id=:id", nativeQuery=true)
    Hotel darHotel(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO hoteles (id, nombre, telefono) VALUES(SQ_HOTELES.nextval, :nombre, :telefono)", nativeQuery = true)
    void insertHotel(@Param("nombre") String nombre, @Param("telefono") Integer telefono);

    @Modifying
    @Transactional
    @Query(value="UPDATE hoteles  SET nombre = :nombre, telefono = :telefono WHERE id = :id", nativeQuery = true)
    void updateHotel(@Param("id") Integer id, @Param("nombre") String nombre, @Param("telefono") Integer telefono);
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE id= :id", nativeQuery = true)
    void deleteHotel(@Param("id") Integer id);
}
