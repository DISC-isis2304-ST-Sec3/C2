package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer devuelto;
    private Integer malestado;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombreHotel;

    @ManyToOne
    @JoinColumn(name = "cuentas_id", referencedColumnName = "id")
    private Cuenta idCuenta;

    public Prestamo(Integer devuelto, Integer malestado, Hotel nombreHotel, Cuenta idCuenta)
    {
        this.devuelto = devuelto;
        this.malestado = malestado;
        this.nombreHotel = nombreHotel;
        this.idCuenta = idCuenta;
    }

    public Prestamo()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Integer devuelto) {
        this.devuelto = devuelto;
    }

    public Integer getMalestado() {
        return malestado;
    }

    public void setMalestado(Integer malestado) {
        this.malestado = malestado;
    }

    public Hotel getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(Hotel nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public Cuenta getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Cuenta idCuenta) {
        this.idCuenta = idCuenta;
    }

    
}


