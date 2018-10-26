package web.managedbean;

import dao.DaoCursos;
import dao.DaoProfesores;
import dao.impl.DaoProfesoresImpl;
import dao.impl.DaoCursosImpl;
import hibernate.domain.Profesores;
import hibernate.domain.Cursos;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbCursos")
@RequestScoped
public class ManagedBeanCursos {
    
    private Integer idcursos;
    private Integer idprofesores;
    private String nombrecursos;
    private String descripcion;
    private Date fechainicio;
    private Date fechafin;
    private String tipo;
    private String horas;
    
    private String message;
    private String ids;

    public ManagedBeanCursos() {
    }

    // gettter y setter

    public Integer getIdcursos() {
        return idcursos;
    }

    public void setIdcursos(Integer idcursos) {
        this.idcursos = idcursos;
    }

    public Integer getIdprofesores() {
        return idprofesores;
    }

    public void setIdprofesores(Integer idprofesores) {
        this.idprofesores = idprofesores;
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
   
    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getMessage() {
        return message;
    }
    
    // gestion
    public List<Object[]> getList() {
        DaoCursos daoCursos = new DaoCursosImpl();
        
        List<Object[]> list = daoCursos.cursosQry();

        if (list == null) {
            message = daoCursos.getMessage();
        }

        return list;
    }
    
    public List<Profesores> getCombo() {
        DaoProfesores daoProfesores = new DaoProfesoresImpl();
        List<Profesores> list = daoProfesores.profesoresQry();
        
        if (list == null) {
            message = daoProfesores.getMessage();
        }

        return list;
    }
    
    public String cursosIns() {
        Profesores p = new Profesores();
        p.setIdprofesores(idprofesores);
        
        Cursos c = new Cursos();
        c.setIdprofesores(p);
        c.setNombrecursos(nombrecursos);
        c.setDescripcion(descripcion);
        c.setFechainicio(new java.sql.Date(fechainicio.getTime()));
        c.setFechafin(new java.sql.Date(fechafin.getTime()));
        c.setTipo(tipo);
        c.setHoras(horas);
        
        DaoCursos daoCursos = new DaoCursosImpl();
        message = daoCursos.cursosIns(c);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/frasesIns";
        }
    }

    public String cursosDel() {
        Integer list_ids = DeString.aInteger(ids);

        if (list_ids != null) {
            DaoCursos daoCursos = new DaoCursosImpl();
            message = daoCursos.cursosDel(list_ids);
        } else {
            message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String cursosGet() {
        DaoCursos daoCursos = new DaoCursosImpl();
        Cursos c = daoCursos.cursosGet(idcursos);

        String retorno = "/frasesUpd";
        if(c == null){
            message = daoCursos.getMessage();
            retorno ="/index";
        }else{
            idcursos = c.getIdcursos();
            idprofesores = c.getIdprofesores().getIdprofesores();
            nombrecursos = c.getNombrecursos();
            descripcion = c.getDescripcion();
            fechainicio = c.getFechafin();
            fechafin = c.getFechafin();
            tipo = c.getTipo();
            horas = c.getHoras();
        }
        return retorno;
    }

    public String cursosUpd() {
        DaoCursos daoCursos = new DaoCursosImpl();
        
        Profesores p = new Profesores();
        p.setIdprofesores(idprofesores);
        
        Cursos c = daoCursos.cursosGet(idcursos);
        c.setIdprofesores(p);
        c.setNombrecursos(nombrecursos);
        c.setDescripcion(descripcion);
        c.setFechafin(new java.sql.Date(fechafin.getTime()));
        c.setFechainicio(new java.sql.Date(fechainicio.getTime()));
        c.setTipo(tipo);
        c.setHoras(horas);
        
        message = daoCursos.cursosUpd(c);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/frasesUpd";
        }
    }

}

