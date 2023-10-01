package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")
public class Habitacion {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String tipo;
    private Integer capacidad;
    private Integer precio;
    private Integer consumo;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombreHotel;

    public Habitacion(String tipo, Integer capacidad, Integer precio, Integer consumo, Hotel nombreHotel)
    {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precio = precio;
        this.consumo = consumo;
        this.nombreHotel = nombreHotel;
    }

    public Habitacion()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public Hotel getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(Hotel nombreHotel) {
        this.nombreHotel = nombreHotel;
    }


}
