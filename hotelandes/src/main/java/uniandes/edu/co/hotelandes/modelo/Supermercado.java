package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.*;


@Entity
@Table(name = "Supermercado")
public class Supermercado {
    @Id
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id")
    private Servicio servicio;

    private String nombre;

    public Supermercado() {
    }

    public Supermercado(Servicio servicio, String nombre) {
        this.servicio = servicio;
        this.nombre = nombre;

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }



}
