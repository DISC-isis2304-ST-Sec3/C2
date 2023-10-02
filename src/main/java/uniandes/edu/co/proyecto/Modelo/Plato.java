package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="platos")
public class Plato {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Integer costo;

    @ManyToOne
    @JoinColumn(name="nombre_restaurante", referencedColumnName = "nombre")
    private Restaurante nombre_restaurante;

    public Plato(String nombre, Integer costo, Restaurante nombre_restaurante){
        this.nombre = nombre;
        this.costo = costo;
        this.nombre_restaurante = nombre_restaurante;
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

    public Restaurante getRestaurante() {
        return nombre_restaurante;
    }

    public void setRestaurante(Restaurante nombre_restaurante) {
        this.nombre_restaurante = nombre_restaurante;
    }
    
}
