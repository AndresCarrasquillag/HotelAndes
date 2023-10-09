package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservas_habitaciones")
public class ReservaHabitacion {

    @EmbeddedId
    private ReservaHabitacionPK pk;

    public  ReservaHabitacion(Reserva id_reserva, Habitacion id_habitacion) {

        this.pk = new ReservaHabitacionPK(id_habitacion, id_reserva);
    }

    public ReservaHabitacion(){
        super();
    }

    public ReservaHabitacionPK getPk() {
        return pk;
    }

    public void setPk(ReservaHabitacionPK pk) {
        this.pk = pk;
    }

    
}
