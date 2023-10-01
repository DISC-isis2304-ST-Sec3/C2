package uniandes.edu.co.proyecto.Modelo;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="platos")
public class Plato {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Integer costo;

    @OneToMany
    @JoinColumn(name="nombre_restaurante", referencedColumnName = "id")
    private Restaurante restaurante;
    
    @OneToMany
    @JoinColumn(name="nombre_bar", referencedColumnName = "id")
    private Bar bar;

    public Plato(String nombre, Integer costo){
        this.nombre = nombre;
        this.costo = costo;
    }

    public Plato()
    {;}

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

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    
}
