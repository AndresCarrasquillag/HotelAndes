package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Habitaciones")
public class Habitacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer capacidad;
    private Integer costo;

    @ManyToOne
    @JoinColumn(name = "Sedes", referencedColumnName = "id")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "Tipos_habitacion", referencedColumnName = "nombre_tipo")
    private TipoHabitacion tipoHabitacion;

    public Habitacion(Integer capacidad, Integer costo, Sede sede, TipoHabitacion tipoHabitacion) {
        this.sede = sede;
        this.capacidad = capacidad;
        this.costo = costo;
        this.tipoHabitacion = tipoHabitacion;

    }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion){
        this.tipoHabitacion = tipoHabitacion;
    }
    public TipoHabitacion geTipoHabitacion(){
        return tipoHabitacion;
    }

    public void setSede(Sede sede){
        this.sede = sede;
    }
    public Sede getSede(){
        return sede;
    }

    public Habitacion(){;}

    public Integer getId() {
        return id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }


    
}
