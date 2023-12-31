package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reservasservicios")
public class Reservaservicio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer habitacion;
    private String servicio;
    private String horainicio;
    private String horafin;

    @ManyToOne
    @JoinColumn(name="documento_cliente", referencedColumnName = "documento")
    private Cliente documento_cliente;

    public Reservaservicio(Integer habitacion, String servicio, String horainicio, String horafin, Cliente cliente)
    {
        this.habitacion = habitacion;
        this.servicio = servicio;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.documento_cliente = cliente;
    }

    public Reservaservicio()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Integer habitacion) {
        this.habitacion = habitacion;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHorafin() {
        return horafin;
    }

    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }

    public Cliente getDocumento_cliente() {
        return documento_cliente;
    }

    public void setDocumento_cliente(Cliente documento_cliente) {
        this.documento_cliente = documento_cliente;
    }

}

