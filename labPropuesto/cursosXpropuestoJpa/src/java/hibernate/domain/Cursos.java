package hibernate.domain;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "cursos")
public class Cursos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcursos")
    private Integer idcursos;
    
    @Basic(optional = false)
    @Column(name = "nombrecursos")
    private String nombrecursos;
    
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @Column(name = "fechainicio")
    private Date fechainicio;
    
    @Basic(optional = false)
    @Column(name = "fechafin")
    private Date fechafin;
    
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    
    @Basic(optional = false)
    @Column(name = "horas")
    private String horas;
    
    @JoinColumn(name = "idprofesores", referencedColumnName = "idprofesores")
    @ManyToOne(optional = false)
    private Profesores idprofesores;

    public Cursos() {
    }

    public Cursos(Integer idcursos) {
        this.idcursos = idcursos;
    }

    public Cursos(Integer idcursos, String nombrecursos) {
        this.idcursos = idcursos;
        this.nombrecursos = nombrecursos;
    }

    public Integer getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(Integer idcursos) {
        this.idcursos = idcursos;
    }

    public String getNombrecursos() {
        return nombrecursos;
    }

    public void setNombrecursos(String nombrecursos) {
        this.nombrecursos = nombrecursos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public Profesores getIdprofesores() {
        return idprofesores;
    }

    public void setIdprofesores(Profesores idprofesores) {
        this.idprofesores = idprofesores;
    }
    
    
    
}
