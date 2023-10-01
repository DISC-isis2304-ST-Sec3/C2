package uniandes.edu.co.proyecto.Modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="acompañantes")
public class Acompañante {
    @Id
    private Integer idacompañante;

    @ManyToOne
    @JoinColumn(name="cliente_documento", referencedColumnName = "documento")
    private Cliente cliente;

    public Acompañante(Integer idacompañante, Cliente cliente){
        this.idacompañante = idacompañante;
        this.cliente = cliente;
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
