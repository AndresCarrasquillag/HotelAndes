package uniandes.edu.co.hotelandes.repositorio;
import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Lavanderia;
public interface LavanderiaRepository extends JpaRepository<Lavanderia, Integer> {
    @Query(value= "SELECT * FROM Lavanderia", nativeQuery=true)
    Collection<Lavanderia> darLavanderias();
    
    @Query(value="SELECT * FROM Lavanderia WHERE id=id", nativeQuery=true)
    Lavanderia darLavanderia(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO Lavanderia (id,precioPorPrenda,cantidadPrendas) VALUES(1,  :precioPorPrendas, :cantidadPrendas)" ,nativeQuery=true)
    void insertarLavanderia(@Param("precioPorPrenda") Integer precioPorPrenda, @Param("cantidadPrendas") Integer cantidadPrendas);

    @Modifying
    @Transactional
    @Query(value="UPDATE Lavanderia SET precioPorPrenda=:precioPorPrenda, cantidadPrendas=:cantidadPrendas WHERE id=:id", nativeQuery=true)
    void actualizarLavanderia(@Param("id") Integer id, @Param("cantidadPrendas") Integer cantidadPrendas, @Param("precioPorPrenda") Integer precioPorPrenda);
     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Lavanderia WHERE id=:id", nativeQuery = true)
    void eliminarLavanderia(@Param("id") Integer id);

    
}

