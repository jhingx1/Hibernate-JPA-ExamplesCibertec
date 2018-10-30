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
@Table(name = "preguntas")
public class Preguntas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpregunta")
    private Integer idpregunta;
    
    @Basic(optional = false)
    @Column(name = "pregunta")
    private String pregunta;
    
    @Basic(optional = false)
    @Column(name = "prioridad")
    private Integer prioridad;
    
    @JoinColumn(name = "idexamen", referencedColumnName = "idexamen")
    @ManyToOne(optional = false)
    private Examenes idexamen;

    public Preguntas() {
    }

    public Preguntas(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

    public Preguntas(Integer idpregunta, String pregunta) {
        this.idpregunta = idpregunta;
        this.pregunta = pregunta;
    }

    public Integer getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }

    public Examenes getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Examenes idexamen) {
        this.idexamen = idexamen;
    }
    
}
