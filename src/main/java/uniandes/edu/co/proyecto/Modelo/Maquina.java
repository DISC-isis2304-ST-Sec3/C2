package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="maquinas")
public class Maquina {
    @EmbeddedId
    private MaquinaPK pk;
    private String nombre;

    public Maquina(MaquinaPK pk, String nombre) {
        this.pk = pk;
        this.nombre = nombre;
    }

    public Maquina(){;}

    public MaquinaPK getPk() {
        return pk;
    }

    public void setPk(MaquinaPK pk) {
        this.pk = pk;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
