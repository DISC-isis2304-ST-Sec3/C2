package uniandes.edu.co.proyecto.Modelo;

import org.hibernate.id.IntegralDataTypeHolder;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="acompañantes")
public class Acompañante {
    @Id
    private Integer idacompañante;

    public Acompañante(Integer idacompañante){
        this.idacompañante = idacompañante;
    }

    public Acompañante()
    {;}

    public Integer getIdacompañante() {
        return idacompañante;
    }

    public void setIdacompañante(Integer idacompañante) {
        this.idacompañante = idacompañante;
    }
}
