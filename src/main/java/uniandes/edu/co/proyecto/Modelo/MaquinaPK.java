package uniandes.edu.co.proyecto.Modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MaquinaPK implements Serializable{
    @ManyToOne
    @JoinColumn(name="id_Gimnasio", referencedColumnName = "id")
    private Gimnasio id_Gimnasio;

    public MaquinaPK(Gimnasio id_Gimnasio) {
        super();
        this.id_Gimnasio = id_Gimnasio;
    }

    public Gimnasio getId_Gimnasio() {
        return id_Gimnasio;
    }

    public void setId_Gimnasio(Gimnasio id_Gimnasio) {
        this.id_Gimnasio = id_Gimnasio;
    }
    
}
