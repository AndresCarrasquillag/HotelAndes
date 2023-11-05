package uniandes.edu.co.hotelandes.modelo;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "Lavanderia")
public class Lavanderia {
    @EmbeddedId
    private LavanderiaPK pk;
    private Integer precioPorPrenda;
    private Integer cantidadPrendas;

    public Integer getCantidadPrenda() {
        return cantidadPrendas;
    }

    public void setCantidadPrenda(Integer cantidadPrenda) {
        this.cantidadPrendas = cantidadPrenda;
    }

    public Integer getPrecioPorPrenda() {
        return precioPorPrenda;
    }

    public void setPrecioPorPrenda(Integer precioPorPrenda) {
        this.precioPorPrenda = precioPorPrenda;
    }

    public Lavanderia(){
        ;
    }

    public Lavanderia(Servicio id, Integer cantidadPrendas, Integer precioPorPrenda){
        this.pk = new LavanderiaPK(id);

        
        this.precioPorPrenda = precioPorPrenda; 
        this.precioPorPrenda = precioPorPrenda;
    }


    public LavanderiaPK getPk() {
        return pk;
    }

    public void setPk(LavanderiaPK pk) {
        this.pk = pk;
    }
    
}
