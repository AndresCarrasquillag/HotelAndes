package uniandes.edu.co.hotelandes.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicios")
public class Servicio {
    
    @Id
    @SequenceGenerator(name = "sq_servicios", sequenceName = "sq_servicios", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_servicios")
    private Integer id;
    // Importante colocar el formato de la fecha
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date horario_de_servicio;
    private Integer costo;
    private String tipo_servicio;
    

    

    public Servicio(){}

    public Servicio(Integer id, Date horario_de_servicio, Integer costo, String tipo_servicio) {
        this.id = id;
        this.costo = costo;
        this.tipo_servicio = tipo_servicio;
        this.horario_de_servicio = horario_de_servicio;
        
        
    }
    public String getTipo_servicio() {
        return tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        this.tipo_servicio = tipo_servicio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHorario_de_servicio() {
        return horario_de_servicio;
    }

    public void setHorario_de_servicio(Date horario_de_servicio) {
        this.horario_de_servicio = horario_de_servicio;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    
    
}
