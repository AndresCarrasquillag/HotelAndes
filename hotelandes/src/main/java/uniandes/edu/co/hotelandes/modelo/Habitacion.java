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
@Table(name="Habitaciones")
public class Habitacion {
    
    @Id
    @SequenceGenerator(name = "sq_habitaciones", sequenceName = "sq_habitaciones", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_habitaciones")
    private Integer id;
    private Integer capacidad;
    private Integer costo;

    @ManyToOne
    @JoinColumn(name = "Sedes_id", referencedColumnName = "id")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
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
    public TipoHabitacion getTipoHabitacion(){
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
