package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado {
    @Id
    private Integer documento;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String cargo;
    private Integer salario;

    @ManyToOne
    @JoinColumn(name = "hoteles_nombre", referencedColumnName = "nombre")
    private Hotel nombreHotel;

    public Empleado(Integer documento, String nombre, String apellido, Integer edad, String cargo, Integer salario, Hotel nombreHotel){
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cargo = cargo;
        this.salario = salario;
        this.nombreHotel = nombreHotel;
    }

    public Empleado()
    {;}

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Hotel getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(Hotel nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

}
