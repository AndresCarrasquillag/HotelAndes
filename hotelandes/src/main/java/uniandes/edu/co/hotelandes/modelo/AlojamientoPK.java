package uniandes.edu.co.hotelandes.modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class AlojamientoPK  implements Serializable  {
    @OneToOne
    @JoinColumn(name= "id", referencedColumnName = "id")
    private Servicio id;


    public AlojamientoPK (){
         super();
    }

    public AlojamientoPK (Servicio id){
        super();
        this.id = id;
    }

    public Servicio getId() {
        return id;
    }

    public void setId(Servicio id) {
        this.id = id;
    }

    
    
}
