package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="planesconsumos")
public class Planconsumo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer tiempo;
    private String tipo;
    private Integer precio;
    private String promocion;
    private String beneficio;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombreHotel;

    public Planconsumo(Integer id, Integer tiempo, String tipo, Integer precio, String promocion, String beneficio, Hotel nombreHotel)
    {
        this.tiempo = tiempo;
        this.tipo = tipo;
        this.precio = precio;
        this.promocion = promocion;
        this.beneficio = beneficio;
        this.nombreHotel = nombreHotel;
    }
    
    public Planconsumo()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public Hotel getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(Hotel nombreHotel) {
        this.nombreHotel = nombreHotel;
    }
    
}

