package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="salones")
public class Salon {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer capacidad;
    private Integer costo;
    private Boolean tienecostoad;
    private Integer costoad;
    private Date tiempolimpieza;

    @ManyToOne
    @JoinColumn(name = "hotel_nombre", referencedColumnName = "nombre")
    private Hotel hotel_nombre;


    public Salon(Integer capacidad, Integer costo, Boolean tienecostoad, Integer costoad, Date tiempolimpieza, Hotel hotel_nombre)
    {
        this.capacidad = capacidad;
        this.costo = costo;
        this.tienecostoad = tienecostoad;
        this.costoad = costoad;
        this.tiempolimpieza = tiempolimpieza;
        this.hotel_nombre = hotel_nombre;
    }

    public Salon()
    {;}

    public Integer getId() {
        return id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public Boolean getTienecostoad() {
        return tienecostoad;
    }

    public Integer getCostoad() {
        return costoad;
    }

    public Date getTiempolimpieza() {
        return tiempolimpieza;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public void setTienecostoad(Boolean tienecostoad) {
        this.tienecostoad = tienecostoad;
    }

    public void setCostoad(Integer costoad) {
        this.costoad = costoad;
    }

    public void setTiempolimpieza(Date tiempolimpieza) {
        this.tiempolimpieza = tiempolimpieza;
    }

    public Hotel getHotel_nombre() {
        return hotel_nombre;
    }

    public void setHotel_nombre(Hotel hotel_nombre) {
        this.hotel_nombre = hotel_nombre;
    }
}
