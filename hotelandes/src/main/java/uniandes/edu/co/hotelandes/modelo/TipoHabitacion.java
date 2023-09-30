package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipos_habitacion")
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String desripcion;
    private String nombre_tipo;
    
    public TipoHabitacion(Integer id, String desripcion, String nombre_tipo) {
        this.id = id;
        this.desripcion = desripcion;
        this.nombre_tipo = nombre_tipo;
    }

    public TipoHabitacion(){;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

}
