package uniandes.edu.co.hotelandes.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consumos")
public class Consumo {
    
    @Id
    @SequenceGenerator(name = "sq_consumos", sequenceName = "sq_consumos", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_consumos")
    private Integer id;
    private Integer costo;
    private Date fecha_de_pago;
    private String descripcion;


    @ManyToOne
    @JoinColumn(name = "Servicios_id", referencedColumnName = "Id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "Id")
    private Usuario usuario;

    public Consumo(Integer id, Integer costo, Date fecha_de_pago, String descripcion, Servicio servicio) {
        this.id = id;
        this.costo = costo;
        this.fecha_de_pago = fecha_de_pago;
        this.descripcion = descripcion;
        this.servicio = servicio;
    }
    public void setServicio(Servicio servicio){
        this.servicio=servicio;
    }
    public Servicio getServicio(){
        return servicio;
    }

    public Consumo(){;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Date getFecha_de_pago() {
        return fecha_de_pago;
    }

    public void setFecha_de_pago(Date fecha_de_pago) {
        this.fecha_de_pago = fecha_de_pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
