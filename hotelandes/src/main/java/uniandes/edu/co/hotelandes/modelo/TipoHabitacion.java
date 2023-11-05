package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipos_habitacion")
public class TipoHabitacion {

    @Id
    @SequenceGenerator(name = "sq_tipos_habitacion", sequenceName = "sq_tipos_habitacion", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_tipos_habitacion")
    private Integer id;
    private String descripcion;
    private String nombre_tipo;
    
    public TipoHabitacion(Integer id, String desripcion, String nombre_tipo) {
        this.id = id;
        this.descripcion = desripcion;
        this.nombre_tipo = nombre_tipo;
    }

    public TipoHabitacion(){;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

}
