
package hibernate.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JAdv-VS
 */
@Entity
@Table(name = "examenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Examenes.findAll", query = "SELECT e FROM Examenes e")
    , @NamedQuery(name = "Examenes.findByIdexamen", query = "SELECT e FROM Examenes e WHERE e.idexamen = :idexamen")
    , @NamedQuery(name = "Examenes.findByTitulo", query = "SELECT e FROM Examenes e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "Examenes.findByDuracion", query = "SELECT e FROM Examenes e WHERE e.duracion = :duracion")
    , @NamedQuery(name = "Examenes.findByPublicacion", query = "SELECT e FROM Examenes e WHERE e.publicacion = :publicacion")
    , @NamedQuery(name = "Examenes.findByMinimanota", query = "SELECT e FROM Examenes e WHERE e.minimanota = :minimanota")
    , @NamedQuery(name = "Examenes.findByActivo", query = "SELECT e FROM Examenes e WHERE e.activo = :activo")})
public class Examenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamen")
    private Integer idexamen;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Lob
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "duracion")
    private int duracion;
    @Basic(optional = false)
    @Column(name = "publicacion")
    @Temporal(TemporalType.DATE)
    private Date publicacion;
    @Basic(optional = false)
    @Column(name = "minimanota")
    private double minimanota;
    @Basic(optional = false)
    @Column(name = "activo")
    private Character activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexamen")
    private Collection<Preguntas> preguntasCollection;

    public Examenes() {
    }

    public Examenes(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public Examenes(Integer idexamen, String titulo, int duracion, Date publicacion, double minimanota, Character activo) {
        this.idexamen = idexamen;
        this.titulo = titulo;
        this.duracion = duracion;
        this.publicacion = publicacion;
        this.minimanota = minimanota;
        this.activo = activo;
    }

    public Integer getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Integer idexamen) {
        this.idexamen = idexamen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Date publicacion) {
        this.publicacion = publicacion;
    }

    public double getMinimanota() {
        return minimanota;
    }

    public void setMinimanota(double minimanota) {
        this.minimanota = minimanota;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }

    @XmlTransient
    public Collection<Preguntas> getPreguntasCollection() {
        return preguntasCollection;
    }

    public void setPreguntasCollection(Collection<Preguntas> preguntasCollection) {
        this.preguntasCollection = preguntasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexamen != null ? idexamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examenes)) {
            return false;
        }
        Examenes other = (Examenes) object;
        if ((this.idexamen == null && other.idexamen != null) || (this.idexamen != null && !this.idexamen.equals(other.idexamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernate.domain.Examenes[ idexamen=" + idexamen + " ]";
    }
    
}
