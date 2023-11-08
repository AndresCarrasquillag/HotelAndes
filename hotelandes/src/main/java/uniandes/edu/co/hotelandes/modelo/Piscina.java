package uniandes.edu.co.hotelandes.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Piscina")
public class Piscina {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    private Servicio servicio;

    private Integer profundidad;

    public Piscina(){
 
    }

    public Piscina(Servicio servicio, Integer profundidad){
        this.servicio = servicio;
        this.profundidad = profundidad; 

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

   

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }
    

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
