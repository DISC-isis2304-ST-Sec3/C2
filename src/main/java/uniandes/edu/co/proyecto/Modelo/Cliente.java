package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
    private String nombre;
    private String apellido;

    @Id
    private Integer documento;

    private Integer edad;
    private Integer habitacion;
    private Integer consumo;

    @ManyToOne
    @JoinColumn(name = "hotel_nombre", referencedColumnName = "nombre")
    private Hotel hotel_nombre;

    @OneToOne
    @JoinColumn(name = "checksins_id", referencedColumnName = "id")
    private Checkin checksins_id;

    @OneToOne
    @JoinColumn(name = "checksouts_id", referencedColumnName = "id")
    private Checkout checksouts_id;

    @OneToOne
    @JoinColumn(name = "reservas_id", referencedColumnName = "id")
    private Reserva reservas_id;

    public Cliente(String nombre, String apellido, Integer documento, Integer edad, Integer habitacion, Integer consumo, Hotel hotel_nombre, Checkin checksins_id, Checkout checksouts_id, Reserva reservas_id)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.habitacion = habitacion;
        this.consumo = consumo;
        this.hotel_nombre = hotel_nombre;
        this.checksins_id = checksins_id;
        this.checksouts_id = checksouts_id;
    }

    public Cliente()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Integer habitacion) {
        this.habitacion = habitacion;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }

    public Hotel getHotel_nombre() {
        return hotel_nombre;
    }

    public void setHotel_nombre(Hotel hotel_nombre) {
        this.hotel_nombre = hotel_nombre;
    }

    public Checkin getChecksins_id() {
        return checksins_id;
    }

    public void setChecksins_id(Checkin checksins_id) {
        this.checksins_id = checksins_id;
    }

    public Checkout getChecksouts_id() {
        return checksouts_id;
    }

    public void setChecksouts_id(Checkout checksouts_id) {
        this.checksouts_id = checksouts_id;
    }

    public Reserva getReservas_id() {
        return reservas_id;
    }

    public void setReservas_id(Reserva reservas_id) {
        this.reservas_id = reservas_id;
    }
}
