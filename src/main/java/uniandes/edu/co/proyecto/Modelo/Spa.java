package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.CriteriaBuilder.In;

@Entity
@Table(name="spas")
public class Spa {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer duracion;
    private Integer costo;
    private Integer consumo;
    private String horario;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombre_hotel;
    

    public Spa(Integer duracion, Integer costo, Integer consumo, String horario, Hotel nombre_hotel)
    {
        this.duracion = duracion;
        this.costo = costo;
        this.consumo = consumo;
        this.horario = horario;
        this.nombre_hotel = nombre_hotel;
    }

    public Spa()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
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


