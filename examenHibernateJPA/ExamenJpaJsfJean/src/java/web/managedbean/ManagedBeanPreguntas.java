package web.managedbean;

import dao.DaoExamenes;
import dao.DaoPreguntas;
import dao.impl.DaoExamenesImpl;
import dao.impl.DaoPreguntasImpl;
import hibernate.domain.Examenes;
import hibernate.domain.Preguntas;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbPreguntas")
@RequestScoped
public class ManagedBeanPreguntas {

    private Integer idpregunta;
    private Integer idexamen;
    private String pregunta;
    private Integer prioridad;    

    private String message;
    private String ids;

    public ManagedBeanPreguntas() {
    }

    // gettter y setter

    public Integer getIdpregunta() {
        return idpregunta;
    }

    public void setIdpregunta(Integer idpregunta) {
        this.idpregunta = idpregunta;
    }

    public Integer getIdexamen() {
        return idexamen;
    }

    public void setIdexamen(Integer idexamen) {
        this.idexamen = idexamen;
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



    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getMessage() {
        return message;
    }

    public List<Object[]> getList() {

        DaoPreguntas daoPreguntas = new DaoPreguntasImpl();

        List<Object[]> list = daoPreguntas.preguntasQry();
        if (list == null) {
            message = daoPreguntas.getMessage();
        }

       
        return list;
    }

    public List<Examenes> getComboDocumento() {

        DaoExamenes daoExamenes = new DaoExamenesImpl();

        List<Examenes> list = daoExamenes.examenesQry();
        if (list == null) {
            message = daoExamenes.getMessage();
        }

       
        return list;
    }

    
    // gestion
    public String preguntasIns() {
        Examenes a = new Examenes();
        a.setIdexamen(idexamen);

        Preguntas f = new Preguntas();
        f.setIdexamen(a);
        f.setPregunta(pregunta);
        f.setPrioridad(prioridad);
        
        DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
        message = daoPreguntas.preguntasIns(f);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/preguntasIns";
        }
    }

    public String preguntasDel() {
        List<Integer> list_ids = DeString.ids(ids);

        if (list_ids != null) {
            DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
            message = daoPreguntas.preguntasDel(list_ids);
        } else {
            message = "Lista de ID(s) incorrecta";
        }

        return "/index";
    }

    public String preguntasGet() {
        DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
        Preguntas f = daoPreguntas.preguntasGet(idpregunta);
        
        String retorno = "/preguntasUpd";
        if (f == null) {
            message = daoPreguntas.getMessage();
            retorno = "/index";
            
        } else {
            idpregunta = f.getIdpregunta();
            idexamen = f.getIdexamen().getIdexamen();
            pregunta = f.getPregunta();
            prioridad = f.getPrioridad();
     
        }
        
        return retorno;
    }

    public String preguntasUpd() {
        DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
           
        Examenes a = new Examenes();
        a.setIdexamen(idexamen);
        
        Preguntas f = daoPreguntas.preguntasGet(idpregunta);
        f.setIdexamen(a);
        f.setPregunta(pregunta);
        f.setPrioridad(prioridad);

        message = daoPreguntas.preguntasUpd(f);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/preguntasUpd";
        }
    }


}

