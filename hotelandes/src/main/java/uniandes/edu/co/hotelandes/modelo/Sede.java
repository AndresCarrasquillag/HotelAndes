package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sede")
public class Sede {
    
    @Id
    @SequenceGenerator(name = "sq_sede", sequenceName = "sq_sede", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_sede")
    private Integer id;
    private String nombre;
    private Integer telefono;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "HOTELES_ID", referencedColumnName = "id")
    private Hotel hotel;


    public Sede(Integer id, String nombre, Integer telefono, String direccion, Hotel hotel) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.hotel = hotel;
    }

    public Sede(){;}

    public Hotel getHotel(){
        return hotel;
    }
    public void setHotel(Hotel hotel){
        this.hotel=hotel;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    
}
