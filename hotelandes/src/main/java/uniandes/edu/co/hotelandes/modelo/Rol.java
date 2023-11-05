package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles")
public class Rol {
    
    @Id
    @SequenceGenerator(name = "sq_roles", sequenceName = "sq_roles", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_roles")
    private Integer id_rol;
    private String rol;
    private String descripcion;

    public Rol(Integer id_rol, String rol, String descripcion) {
        this.id_rol = id_rol;
        this.rol = rol;
        this.descripcion = descripcion;
    }

    public Rol(){;}

    public Integer getId() {
        return id_rol;
    }

    public void setId(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
