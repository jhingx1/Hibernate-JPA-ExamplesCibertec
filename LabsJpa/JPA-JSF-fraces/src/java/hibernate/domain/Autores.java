package hibernate.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "autores")
public class Autores implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idautor")
    private Integer idautor;
    
    @Basic(optional = false)
    @Column(name = "autor")
    private String autor;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idautor")
    private Set<Frases> frasesSet;

    public Autores() {
    }

    public Autores(Integer idautor) {
        this.idautor = idautor;
    }

    public Autores(Integer idautor, String autor) {
        this.idautor = idautor;
        this.autor = autor;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @XmlTransient
    public Set<Frases> getFrasesSet() {
        return frasesSet;
    }

    public void setFrasesSet(Set<Frases> frasesSet) {
        this.frasesSet = frasesSet;
    }

}
