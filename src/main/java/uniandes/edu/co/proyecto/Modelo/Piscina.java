package uniandes.edu.co.proyecto.Modelo;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
    @OneToMany
    @JoinColumn(name="id_hotel", referencedColumnName = "id")
    private Hotel hotel;

    public Piscina(Integer capacidad, Integer profundidad, String horario){
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horario = horario;
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

}
