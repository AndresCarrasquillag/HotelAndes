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
@Table(name = "Reservas")
public class Reserva {
    
    @Id
    @SequenceGenerator(name = "sq_reservas", sequenceName = "sq_reservas", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_reservas")
    private Integer id;
    private Date fecha_hora_inicio;
    private Date fecha_hora_fin;
    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "Planes_de_consumo", referencedColumnName = "id")
    private PlanesDeConsumo planDeConsumo;

    @ManyToOne
    @JoinColumn(name = "Sedes", referencedColumnName = "id")
    private Sede sede;

    @ManyToOne
    @JoinColumn(name = "Usuarios", referencedColumnName = "id")
    private Usuario usuario;


    public Reserva(Date fecha_hora_inicio, Date fecha_hora_fin, Integer precio, PlanesDeConsumo planDeConsumo, Sede sede, Usuario usuario) {
        
        this.fecha_hora_fin = fecha_hora_fin;
        this.fecha_hora_inicio = fecha_hora_inicio;
        this.precio = precio;
        this.planDeConsumo = planDeConsumo;
        this.sede = sede;
        this.usuario = usuario;
    }

    public Reserva(){;}

    public void setUsuario(Usuario usuario){
        this.usuario=usuario;
    }
    public Usuario getUsuario(){
        return usuario;
    }

    public Sede getSede(){
        return sede;
    }
    public void setSede(Sede sede){
        this.sede=sede;
    }

    public PlanesDeConsumo getPlanDeConsumo(){
        return planDeConsumo;
    }

    public  void setPlanDeConsumo(PlanesDeConsumo planDeConsumo){
        this.planDeConsumo= planDeConsumo;
    }


    public Integer getId() {
        return id;
    }

    public Date getFecha_hora_inicio() {
        return fecha_hora_inicio;
    }

    public Date getFecha_hora_fin() {
        return fecha_hora_fin;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha_hora_inicio(Date fecha_hora_inicio) {
        this.fecha_hora_inicio = fecha_hora_inicio;
    }

    public void setFecha_hora_fin(Date fecha_hora_fin) {
        this.fecha_hora_fin = fecha_hora_fin;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    
}
