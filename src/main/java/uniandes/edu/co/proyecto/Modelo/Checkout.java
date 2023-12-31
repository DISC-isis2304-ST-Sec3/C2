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
@Table(name="checksouts")
public class Checkout {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Date dia;
    private Integer cuentaabierta;
    private Integer cuentatotal;
    private Integer pagocuenta;

    @OneToOne
    @JoinColumn(name="clientes_documento", referencedColumnName = "documento")
    private Cliente clientes_documento;

    public Checkout(Date dia, Integer cuentaabierta, Integer cuentatotal, Integer pagocuenta, Cliente cliente) {
        this.dia = dia;
        this.cuentaabierta = cuentaabierta;
        this.cuentatotal = pagocuenta;
        this.clientes_documento = cliente;
    }

    public Checkout(){
        ;
    }
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Integer getCuentaabierta() {
        return cuentaabierta;
    }

    public void setCuentaabierta(Integer cuentaabierta) {
        this.cuentaabierta = cuentaabierta;
    }

    public Integer getCuentatotal() {
        return cuentatotal;
    }

    public void setCuentatotal(Integer cuentatotal) {
        this.cuentatotal = cuentatotal;
    }

    public Integer getPagocuenta() {
        return pagocuenta;
    }

    public void setPagocuenta(Integer pagocuenta) {
        this.pagocuenta = pagocuenta;
    }

    public Cliente getCliente() {
        return clientes_documento;
    }

    public void setCliente(Cliente cliente) {
        this.clientes_documento = cliente;
    }

}


