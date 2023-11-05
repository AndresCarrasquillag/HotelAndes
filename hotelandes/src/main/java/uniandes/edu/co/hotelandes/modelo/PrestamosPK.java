package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class PrestamosPK {
    @OneToOne
    @JoinColumn(name= "id", referencedColumnName = "id")
    private Servicio id;

    public PrestamosPK(){
     super();
    }

    public PrestamosPK(Servicio id){
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
