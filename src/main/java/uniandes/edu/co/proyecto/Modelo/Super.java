package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="supers")
public class Super {
    @Id
    private String nombre;
    private Integer consumo;

    @OneToOne
    @JoinColumn(name = "hotel_nombre", referencedColumnName = "nombre")
    private Hotel hotel_nombre;

    public Super(String nombre, Integer consumo, Hotel hotel_nombre){
        this.nombre = nombre;
        this.consumo = consumo;
        this.hotel_nombre = hotel_nombre;
    }

    public Super()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public Hotel getHotel_nombre() {
        return hotel_nombre;
    }

    public void setHotel_nombre(Hotel hotel_nombre) {
        this.hotel_nombre = hotel_nombre;
    }
}
