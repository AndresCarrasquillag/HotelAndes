package uniandes.edu.co.hotelandes.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Alojamiento")
public class Alojamiento {
    @EmbeddedId
    private AlojamientoPK pk;
    private String fecha_ingreso;
    private String fecha_salida;

    
    
    @OneToOne
    @JoinColumn(name = "habitacion", referencedColumnName = "id")
    private Habitacion habitacion;

    @OneToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    private Usuario usuario;


    public Alojamiento(){;}

    

    public Alojamiento(Servicio id, String fecha_ingreso, String fecha_salida, Habitacion habitacion,
            Usuario usuario) {
        this.pk = new AlojamientoPK(id);
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
        this.habitacion = habitacion;
        this.usuario = usuario;
    }



    public AlojamientoPK getPk() {
        return pk;
    }

    public void setPk(AlojamientoPK pk) {
        this.pk = pk;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }


    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }


    public String getFecha_salida() {
        return fecha_salida;
    }


    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }


    public Habitacion getHabitacion() {
        return habitacion;
    }


    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
