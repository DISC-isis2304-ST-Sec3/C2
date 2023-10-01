package uniandes.edu.co.proyecto.Modelo;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="supers")
public class Super {
    @Id
    private String nombre;
    private Integer consumo;

    public Super(String nombre, Integer consumo){
        this.nombre = nombre;
        this.consumo = consumo;
    }

    public Super()
    {;}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getConsumo() {
        return consumo;
    }

    public void setConsumo(Integer consumo) {
        this.consumo = consumo;
    }
}
