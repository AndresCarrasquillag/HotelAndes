package uniandes.edu.co.hotelandes.repositorio;

import java.util.Collection;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelandes.modelo.Carta;

public interface CartaRepository extends JpaRepository<Carta, Integer>{

    @Modifying
    @Transactional
    @Query(value ="INSERT INTO cartas (id) VALUES (sq_cartas.NEXTVAL)", nativeQuery=true)
    void insertarCarta();

    
    @Query(value= "SELECT * FROM cartas", nativeQuery=true)
    Collection<Carta> darCartas();
    
    @Query(value="SELECT * FROM cartas WHERE id=:id", nativeQuery=true)
    Carta darCarta(@Param("id") Integer id);

  

     
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cartas WHERE id=:id", nativeQuery = true)
    void eliminarCarta(@Param("id") Integer id);
}
