package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="internets")

public class Internet {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer costo;
    private Integer capacidad;

    @OneToMany
    @JoinColumn(name="id_hotel", referencedColumnName = "id")
    private Hotel hotel;

    public Internet(Integer costo, Integer capacidad)
    {
        this.costo = costo;
        this.capacidad = capacidad;
    }

    public Internet()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
    
}

