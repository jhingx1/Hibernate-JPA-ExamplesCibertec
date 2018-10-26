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

@Entity
@Table(name = "profesores")
public class Profesores implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprofesores")
    private Integer idprofesores;
    
    @Basic(optional = false)
    @Column(name = "nombreprofesores")
    private String nombreprofesores;
    
    @Basic(optional = false)
    @Column(name = "carrera")
    private String carrera;
    
    @Basic(optional = false)
    @Column(name = "fechaingreso")
    private Date fechaingreso;
    
    @Basic(optional = false)
    @Column(name = "tipocontrato")
    private String tipocontrato;
        
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprofesores")
    private Set<Cursos> cursosSet;

    public Profesores() {
    }

    public Profesores(Integer idprofesores) {
        this.idprofesores = idprofesores;
    }

    public Profesores(Integer idprofesores, String nombreprofesores) {
        this.idprofesores = idprofesores;
        this.nombreprofesores = nombreprofesores;
    }

    public Integer getIdprofesores() {
        return idprofesores;
    }

    public void setIdprofesores(Integer idprofesores) {
        this.idprofesores = idprofesores;
    }

    public String getNombreprofesores() {
        return nombreprofesores;
    }

    public void setNombreprofesores(String nombreprofesores) {
        this.nombreprofesores = nombreprofesores;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }
    
    @XmlTransient
    public Set<Cursos> getCursosSet() {
        return cursosSet;
    }

    public void setCursosSet(Set<Cursos> cursosSet) {
        this.cursosSet = cursosSet;
    }
    
    
    
        
}
