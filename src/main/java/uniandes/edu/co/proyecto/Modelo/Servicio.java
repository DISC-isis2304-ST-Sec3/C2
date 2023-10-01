package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Servicio(String tipo, Integer numprendas, Integer costos)
    {
        this.tipo = tipo;
        this.numprendas = numprendas;
        this.costos = costos;
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
}



