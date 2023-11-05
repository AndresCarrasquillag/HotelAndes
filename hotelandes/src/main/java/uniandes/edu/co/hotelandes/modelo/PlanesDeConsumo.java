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
@Table(name = "Planes_de_consumo")
public class PlanesDeConsumo {
    
    @Id
    @SequenceGenerator(name = "sq_planes_de_consumo", sequenceName = "sq_planes_de_consumo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_planes_de_consumo")
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer descuento;
    
    @ManyToOne
    @JoinColumn(name = "HOTELES_ID", referencedColumnName = "id")
    private Hotel hotel;

    public PlanesDeConsumo(Integer id, String nombre, String descripcion, Integer descuento, Hotel hotel) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.hotel = hotel;
    }

    public PlanesDeConsumo(){;}

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    
    
    
}
