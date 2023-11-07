package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="piscinas")
public class Piscina {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer capacidad;
    private Integer profundidad;
    private String horario;
    @ManyToOne
    @JoinColumn(name="nombre_hotel", referencedColumnName = "nombre")
    private Hotel nombre_hotel;

    public Piscina(Integer capacidad, Integer profundidad, String horario, Hotel nombre_hotel){
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horario = horario;
        this.nombre_hotel = nombre_hotel;
    }

    public Piscina()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Hotel getNombre_hotel() {
        return nombre_hotel;
    }

    public void setNombre_hotel(Hotel nombre_hotel) {
        this.nombre_hotel = nombre_hotel;
    }

}
