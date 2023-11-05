package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelandes.modelo.Salon;

public interface SalonRepository extends JpaRepository<Salon, Integer> {

<<<<<<< HEAD
     @Query(value = "SELECT * FROM Salones", nativeQuery = true)
    Collection<Salon> darSalones();

    @Query(value = "SELECT FROM Salones WHERE id= :id", nativeQuery = true)
=======
     @Query(value = "SELECT * FROM Salon", nativeQuery = true)
    Collection<Salon> darSalones();

    @Query(value = "SELECT  * FROM Salon WHERE id= :id", nativeQuery = true)
>>>>>>> origin/main
    Salon darSalon(@Param("id") Integer id);
    
    @Modifying
    @Transactional
<<<<<<< HEAD
    @Query(value = "INSTERT INTO Salones(id, disponibilidad, hora_limpieza,tipo ) VALUES(Hotleandes_sequence.nextval, : disponibilidad, :hora_limpieza, :tipo)", nativeQuery = true)
=======
    @Query(value = "INSTERT INTO Salon(id, disponibilidad, hora_limpieza,tipo ) VALUES(1, :disponibilidad, :hora_limpieza, :tipo)", nativeQuery = true)
>>>>>>> origin/main
    void insertarSalon(@Param("disponibilidad") String disponibilidad, @Param("hora_limpieza") String hora_limpieza,@Param("tipo") String tipo);

    @Modifying
    @Transactional
<<<<<<< HEAD
    @Query(value = "UPDATE Salones SET hora_limpieza= :hora_limpieza, disponibilidad= :disponibilidad WHERE id= :id, tipo= : tipo", nativeQuery = true)
=======
    @Query(value = "UPDATE Salon SET hora_limpieza= :hora_limpieza, disponibilidad= :disponibilidad WHERE id= :id, tipo= :tipo", nativeQuery = true)
>>>>>>> origin/main
    void updateSalon(@Param("id") Integer id,@Param("disponibilidad") String disponibilidad, @Param("hora_limpieza") String hora_limpieza,@Param("tipo") String tipo);

    @Modifying
    @Transactional
<<<<<<< HEAD
    @Query(value = "DELETE FROM Salones WHERE id= :id", nativeQuery = true)
    void deleteSalon(@Param("id") Integer id);
    
}

 
=======
    @Query(value = "DELETE FROM Salon WHERE id= :id", nativeQuery = true)
    void deleteSalon(@Param("id") Integer id);
    
}
>>>>>>> origin/main
