package uniandes.edu.co.hotelandes.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Spa")
public class Spa {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    private Servicio servicio;

    private Integer duracion;
    private String Tipo_servicio;


    public Spa(){
    }

    public Spa(Servicio servicio, Integer duracion, String Tipo_servicio){
        this.servicio = servicio;
        this.duracion = duracion;
        this.Tipo_servicio = Tipo_servicio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getTipo_servicio() {
        return Tipo_servicio;
    }

    public void setTipo_servicio(String tipo_servicio) {
        Tipo_servicio = tipo_servicio;
    }
    
    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    
}
