package uniandes.edu.co.hotelandes.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "Piscina")
public class Piscina {
    @EmbeddedId
    private PiscinaPK pk;
    private Integer profundidad;

    public Piscina(){
        ;
    }

    public Piscina(Servicio id, Integer profundidad){
        this.pk = new PiscinaPK(id);
        this.profundidad = profundidad; 

    }

    public PiscinaPK getPk() {
        return pk;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setPk(PiscinaPK pk) {
        this.pk = pk;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }
    

    
}
