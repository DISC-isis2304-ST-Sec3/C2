package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="gimnasios")

public class Gimnasio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer capacidad;
    private Date horario;
    
    @OneToMany(mappedBy="gimnasio")
    @JoinColumn(name="id_hotel", referencedColumnName = "id")
    private Hotel hotel;

    public Gimnasio(Integer capacidad, Date horario)
    {
        this.capacidad = capacidad;
        this.horario = horario;
    }

    public Gimnasio()
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

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }
    
}



