package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Hoteles")
public class Hotel {

    @Id
    @SequenceGenerator(name = "sq_hoteles", sequenceName = "sq_hoteles",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_hoteles")
    private Integer id;
    private String nombre; 
    private Integer telefono;
    public Hotel(Integer id, String nombre, Integer telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Hotel(){
        ;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getTelefono() {
        return telefono;
    }
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
    
}
