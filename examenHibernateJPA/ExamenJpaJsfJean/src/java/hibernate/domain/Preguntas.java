/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JAdv-VS
 */
@Entity
@Table(name = "preguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preguntas.findAll", query = "SELECT p FROM Preguntas p")
    , @NamedQuery(name = "Preguntas.findByIdpregunta", query = "SELECT p FROM Preguntas p WHERE p.idpregunta = :idpregunta")
    , @NamedQuery(name = "Preguntas.findByPrioridad", query = "SELECT p FROM Preguntas p WHERE p.prioridad = :prioridad")})
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpregunta")
    private Integer idpregunta;
    @Basic(optional = false)
    @Lob
    @Column(name = "pregunta")
    private String pregunta;
    @Basic(optional = false)
    @Column(name = "prioridad")
    private int prioridad;
    @JoinColumn(name = "idexamen", referencedColumnName = "idexamen")
    @ManyToOne(optional = false)
    private Examenes idexamen;

    public Preguntas() {
    }

    public Preguntas(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

    public Preguntas(Integer idpregunta, String pregunta, int prioridad) {
        this.idpregunta = idpregunta;
        this.pregunta = pregunta;
        this.prioridad = prioridad;
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

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Examenes getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Examenes idexamen) {
        this.idexamen = idexamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpregunta != null ? idpregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preguntas)) {
            return false;
        }
        Preguntas other = (Preguntas) object;
        if ((this.idpregunta == null && other.idpregunta != null) || (this.idpregunta != null && !this.idpregunta.equals(other.idpregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.domain.Preguntas[ idpregunta=" + idpregunta + " ]";
    }
    
}
