package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicios_en_sedes")
public class ServicioEnSede {

    @EmbeddedId
    private ServicioEnSedePK pk;

    public ServicioEnSede(Servicio id_servicio, Sede id_sede) {

        this.pk = new ServicioEnSedePK(id_servicio, id_sede);

    }

    public ServicioEnSede(){
        super();
    }

    public ServicioEnSedePK getPk() {
        return pk;
    }

    public void setPk(ServicioEnSedePK pk) {
        this.pk = pk;
    }
    
    
}
