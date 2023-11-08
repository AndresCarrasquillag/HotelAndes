package uniandes.edu.co.hotelandes.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Gimnasio")
public class Gimnasio {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    private Servicio servicio;

   
    private Integer num_maquinas;

    public Gimnasio(){
        ;
    }

    public Gimnasio(Servicio servicio, Integer num_maquinas){
        this.servicio = servicio;
        this.num_maquinas = num_maquinas; 

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum_maquinas() {
        return num_maquinas;
    }

    
    public void setNum_maquinas(Integer num_maquinas) {
        this.num_maquinas = num_maquinas;
    } 

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
    
}
