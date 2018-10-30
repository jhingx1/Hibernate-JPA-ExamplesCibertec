
package hibernate.domain;

import java.io.Serializable;
import java.util.Date;
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

/*
Esto hay que diseñarolo bien, sino genera el error de JDBC error.
Tambien este error puede ser por una mala consulta.

*/

@Entity
@Table(name = "examenes")
public class Examenes  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idexamen")
    private Integer idexamen;
    
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @Column(name = "duracion")
    private Integer duracion;
    
    @Basic(optional = false)
    @Column(name = "publicacion")
    private Date publicacion;
    
    @Basic(optional = false)
    @Column(name = "minimanota")
    private Double minimanota;
    
    @Basic(optional = false)
    @Column(name = "activo")
    private Character activo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idexamen")
    private Set<Preguntas> preguntasSet;

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

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Date getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Date publicacion) {
        this.publicacion = publicacion;
    }

    public Double getMinimanota() {
        return minimanota;
    }

    public void setMinimanota(Double minimanota) {
        this.minimanota = minimanota;
    }

    public Character getActivo() {
        return activo;
    }

    public void setActivo(Character activo) {
        this.activo = activo;
    }
    
    @XmlTransient
    public Set<Preguntas> getPreguntasSet() {
        return preguntasSet;
    }

    public void setPreguntasSet(Set<Preguntas> preguntasSet) {
        this.preguntasSet = preguntasSet;
    }
    
}
