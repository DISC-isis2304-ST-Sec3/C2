package uniandes.edu.co.proyecto.Modelo;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    public Bar(String nombre, String estilo, Integer costo, Integer capacdidad, Integer costocargado)
    {
        this.nombre = nombre;
        this.estilo = estilo;
        this.costo = costo;
        this.capacidad = capacdidad;
        this.costocargado = costocargado;
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
}
