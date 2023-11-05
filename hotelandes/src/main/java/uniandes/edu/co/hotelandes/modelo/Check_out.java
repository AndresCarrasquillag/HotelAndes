package uniandes.edu.co.hotelandes.modelo;
<<<<<<< HEAD
import java.sql.Date;
=======
>>>>>>> origin/main

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Check_In")
public class Check_out {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date hora_salida;
    

    
=======
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Check_Out")
public class Check_out {
    
    public Check_out(){;}
    @Id
    @SequenceGenerator(name = "sq_check_out", sequenceName = "sq_check_out", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_check_out")
    private Integer id;
    private String horaSalida;

    public Check_out(Integer id, String horaSalida) {
        this.id = id;
        this.horaSalida = horaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    

    
    
>>>>>>> origin/main
}
