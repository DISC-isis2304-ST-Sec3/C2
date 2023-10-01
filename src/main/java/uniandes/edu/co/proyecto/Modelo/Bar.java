package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="bares")
public class Bar {
    @Id
    private String nombre;
    private String estilo;
    private Integer costo;
    private Integer capacidad;
    private Integer costocargado;

    @ManyToOne
    @JoinColumn(name = "hotel_nombre", referencedColumnName = "nombre")
    private Hotel hotel_nombre;


    public Bar(String nombre, String estilo, Integer costo, Integer capacidad, Integer costocargado, Hotel hotel_nombre)
    {
        this.nombre = nombre;
        this.estilo = estilo;
        this.costo = costo;
        this.capacidad = capacidad;
        this.costocargado = costocargado;
        this.hotel_nombre = hotel_nombre;
    }

    public Bar(){
        ;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public Integer getCosto() {
        return costo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getCostocargado() {
        return costocargado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCostocargado(Integer costocargado) {
        this.costocargado = costocargado;
    }

    public Hotel getHotel_nombre() {
        return hotel_nombre;
    }

    public void setHotel_nombre(Hotel hotel_nombre) {
        this.hotel_nombre = hotel_nombre;
    }

}
