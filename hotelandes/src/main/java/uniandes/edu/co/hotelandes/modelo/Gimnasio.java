package uniandes.edu.co.hotelandes.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "Gimnasio")
public class Gimnasio {
    @EmbeddedId
    private GimnasioPK pk;
    private Integer num_maquinas;

    public Gimnasio(){
        ;
    }

    public Gimnasio(Servicio id, Integer num_maquinas){
        this.pk = new GimnasioPK(id);
        this.num_maquinas = num_maquinas; 

    }

    public GimnasioPK getPk() {
        return pk;
    }

    public Integer getNum_maquinas() {
        return num_maquinas;
    }

    public void setPk(GimnasioPK pk) {
        this.pk = pk;
    }

    public void setNum_maquinas(Integer num_maquinas) {
        this.num_maquinas = num_maquinas;
    } 
    
    
}
