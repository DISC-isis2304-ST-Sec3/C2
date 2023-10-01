package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String tipo;
    private Integer numprendas;
    private Integer costos;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombre_hotel;

    public Servicio(String tipo, Integer numprendas, Integer costos, Hotel nombre_hotel)
    {
        this.tipo = tipo;
        this.numprendas = numprendas;
        this.costos = costos;
        this.nombre_hotel = nombre_hotel;
    }

    public Servicio()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumprendas() {
        return numprendas;
    }

    public void setNumprendas(Integer numprendas) {
        this.numprendas = numprendas;
    }

    public Integer getCostos() {
        return costos;
    }

    public void setCostos(Integer costos) {
        this.costos = costos;
    }

    public Hotel getNombre_hotel() {
        return nombre_hotel;
    }

    public void setNombre_hotel(Hotel nombre_hotel) {
        this.nombre_hotel = nombre_hotel;
    }

}



