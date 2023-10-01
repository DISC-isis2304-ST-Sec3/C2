package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hoteles")

public class Hotel {
    @Id
    private String nombre;
    private String tipo;
    private String ciudad;
    private String pais;

    @OneToOne
    @JoinColumn(name = "internets_id", referencedColumnName = "id")
    private Internet internets_id;

    public Hotel(String nombre, String tipo, String ciudad, String pais, Internet internets_id)
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.internets_id = internets_id;
    }

    public Hotel()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Internet getInternets_id() {
        return internets_id;
    }

    public void setInternets_id(Internet internets_id) {
        this.internets_id = internets_id;
    }

    
}

