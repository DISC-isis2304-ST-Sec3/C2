package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private Integer precio;

    @ManyToOne
    @JoinColumn(name="id_super", referencedColumnName = "id")
    private Super supermercado;

    public Producto(String nombre, Integer precio, Super supermercado){
        this.nombre = nombre;
        this.precio = precio;
        this.supermercado = supermercado;
    }

    public Producto()
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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Super getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Super supermercado) {
        this.supermercado = supermercado;
    }

    
}
