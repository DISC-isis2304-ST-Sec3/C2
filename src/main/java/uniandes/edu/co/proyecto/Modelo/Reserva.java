package uniandes.edu.co.proyecto.Modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer numpersonas;
    private Date fechaentrada;
    private Date fechasalida;

    @OneToOne
    @JoinColumn(name = "clientes_documento", referencedColumnName = "documento")
    private Cliente clientes_documento;

    public Reserva(Integer numpersonas, Date fechaentrada, Date fechasalida, Cliente clientes_documento){
        this.numpersonas = numpersonas;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.clientes_documento = clientes_documento;
    }

    public Reserva()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumpersonas() {
        return numpersonas;
    }

    public void setNumpersonas(Integer numpersonas) {
        this.numpersonas = numpersonas;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Cliente getCliente_documento() {
        return clientes_documento;
    }

    public void setCliente_documento(Cliente clientes_documento) {
        this.clientes_documento = clientes_documento;
    }
}
