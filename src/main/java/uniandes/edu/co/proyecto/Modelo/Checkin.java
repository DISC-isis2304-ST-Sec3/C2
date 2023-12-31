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
@Table(name="checksins")
public class Checkin {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer documentocliente;
    private Date dia;
    private String realizadopor;
    private Integer cuentaabierta;

    @OneToOne
    @JoinColumn(name = "clientes_documento", referencedColumnName = "documento")
    private Cliente documentoCliente;

    @OneToOne
    @JoinColumn(name = "empleados_documento", referencedColumnName = "documento")
    private Empleado documentoEmpleado;


    public Checkin(Integer documentocliente, Date dia, String realizadopor, Integer cuentaabierta, Cliente documentoCliente, Empleado documentoEmpleado)
    {
        this.documentocliente = documentocliente;
        this.dia = dia;
        this.realizadopor = realizadopor;
        this.cuentaabierta = cuentaabierta;
        this.documentoCliente = documentoCliente;
        this.documentoEmpleado = documentoEmpleado;
    }

    public Checkin()
    {;}

    public Integer getId() {
        return id;
    }

    public Integer getDocumentocliente() {
        return documentocliente;
    }

    public Date getDia() {
        return dia;
    }

    public String getRealizadopor() {
        return realizadopor;
    }

    public Integer getCuentaabierta() {
        return cuentaabierta;
    }

    public Cliente getDocumentoCliente() {
        return documentoCliente;
    }

    public Empleado getDocumentoEmpleado() {
        return documentoEmpleado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDocumentocliente(Integer documentocliente) {
        this.documentocliente = documentocliente;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public void setRealizadopor(String realizadopor) {
        this.realizadopor = realizadopor;
    }

    public void setCuentaabierta(Integer cuentaabierta) {
        this.cuentaabierta = cuentaabierta;
    }

    public Cliente setDocumentoCliente(Cliente documentoCliente) {
        return this.documentoCliente = documentoCliente;
    }

    public Empleado getDocumentoEmpleado(Empleado documentoEmpleado) {
        return documentoEmpleado;
    }

}



