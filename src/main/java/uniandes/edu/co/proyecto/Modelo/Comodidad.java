package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="comodidades")
public class Comodidad {
    @EmbeddedId
    private ComodidadPK pk;
    private String comodidad;

    public Comodidad(Habitacion id, String comodidad){
        this.pk=new ComodidadPK(id);
        this.comodidad = comodidad;
    }

    public Comodidad(){;}

    public ComodidadPK getPk() {
        return pk;
    }

    public void setPk(ComodidadPK pk) {
        this.pk = pk;
    }

    public String getComodidad() {
        return comodidad;
    }

    public void setComodidad(String comodidad) {
        this.comodidad = comodidad;
    }
}
