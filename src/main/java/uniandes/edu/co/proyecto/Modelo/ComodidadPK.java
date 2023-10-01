package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ComodidadPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_Habitacion", referencedColumnName = "id")
    private Habitacion id_Habitacion;

    public ComodidadPK(Habitacion id_Habitacion) {
        super();
        this.id_Habitacion = id_Habitacion;
    }

    public Habitacion getId_Habitacion() {
        return id_Habitacion;
    }

    public void setId_Habitacion(Habitacion id_Habitacion) {
        this.id_Habitacion = id_Habitacion;
    }

    
}
