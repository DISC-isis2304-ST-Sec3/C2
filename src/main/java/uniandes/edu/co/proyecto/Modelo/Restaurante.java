package uniandes.edu.co.proyecto.Modelo;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="resturantes")
public class Restaurante {
    @Id
    private String nombre;
    private String estilo;
    private Integer capacidad;
    private Integer costo;
    private Integer costocargado;

    public Restaurante(String nombre, String estilo, Integer capacidad, Integer costo, Integer costocargado){
        this.nombre = nombre;
        this.estilo = estilo;
        this.capacidad = capacidad;
        this.costo = costo;
        this.costocargado = costocargado;
    }

    public Restaurante()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getCostocargado() {
        return costocargado;
    }

    public void setCostocargado(Integer costocargado) {
        this.costocargado = costocargado;
    }
    
}
