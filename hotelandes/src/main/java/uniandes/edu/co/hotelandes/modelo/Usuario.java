package uniandes.edu.co.hotelandes.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    
    @Id
    @SequenceGenerator(name = "sq_usuarios", sequenceName = "sq_usuarios", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_usuarios")
    private Integer id;
    private String user;
    private String password;
    private String nombre;
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "Roles_id_rol", referencedColumnName = "id")
    private Rol rol;
    
    public Usuario(Integer id, String user, String password, String nombre, String telefono, Rol rol) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.telefono = telefono;
        this.rol= rol;
    }
    public void setRol(Rol rol){
        this.rol=rol;
    }
    public Rol getRol(Rol rol){
        return rol;
    }
    public Usuario(){;}

    public Integer getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
