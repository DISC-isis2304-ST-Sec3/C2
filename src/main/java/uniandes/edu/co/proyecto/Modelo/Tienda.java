package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tiendas")
public class Tienda {
    @Id
    private String nombre;
    private String tipo;
    private Integer consumo;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombre_hotel;

    public Tienda(String nombre, String tipo, Integer consumo, Hotel nombre_hotel)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.consumo = consumo;
        this.nombre_hotel = nombre_hotel;
    }

    public Tienda()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public Hotel getNombre_hotel() {
        return nombre_hotel;
    }

    public void setNombre_hotel(Hotel nombre_hotel) {
        this.nombre_hotel = nombre_hotel;
    }
    
}
