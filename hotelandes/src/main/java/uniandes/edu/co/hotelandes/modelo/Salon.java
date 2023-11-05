package uniandes.edu.co.hotelandes.modelo;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Salon")
public class Salon {
    @EmbeddedId
    private SalonPK pk;
    private String disponibilidad;
    private String hora_limpieza;
    private String tipo;


    public Salon(){
        ;
    }

    public Salon(Servicio id, String disponibilidad, String  hora_limpieza, String tipo){
        this.pk = new SalonPK(id);
        this.disponibilidad = disponibilidad;
        this.hora_limpieza = hora_limpieza;
         this.tipo = tipo;

    }

    public SalonPK getPk() {
        return pk;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public String getHora_limpieza() {
        return hora_limpieza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPk(SalonPK pk) {
        this.pk = pk;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setHora_limpieza(String hora_limpieza) {
        this.hora_limpieza = hora_limpieza;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/main
