package hibernate.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "frases")
public class Frases implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfrase")
    private Integer idfrase;
    
    @Basic(optional = false)
    @Column(name = "frase")
    private String frase;
    
    @JoinColumn(name = "idautor", referencedColumnName = "idautor")
    @ManyToOne(optional = false)
    private Autores idautor;

    public Frases() {
    }

    public Frases(Integer idfrase) {
        this.idfrase = idfrase;
    }

    public Frases(Integer idfrase, String frase) {
        this.idfrase = idfrase;
        this.frase = frase;
    }

    public Integer getIdfrase() {
        return idfrase;
    }

    public void setIdfrase(Integer idfrase) {
        this.idfrase = idfrase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Autores getIdautor() {
        return idautor;
    }

    public void setIdautor(Autores idautor) {
        this.idautor = idautor;
    }

}
