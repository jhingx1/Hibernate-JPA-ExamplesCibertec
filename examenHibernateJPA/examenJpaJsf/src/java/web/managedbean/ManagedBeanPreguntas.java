package web.managedbean;

import dao.DaoPreguntas;
import dao.DaoExamenes;
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
    
    private Integer idpreguntas;
    private Integer idexamenes;
    private String pregunta;
    private Integer prioridad;
        
    private String message;
    private String ids;

    public ManagedBeanPreguntas() {
    }

    // gettter y setter

    public Integer getIdpreguntas() {
        return idpreguntas;
    }

    public void setIdpreguntas(Integer idpreguntas) {
        this.idpreguntas = idpreguntas;
    }

    public Integer getIdexamenes() {
        return idexamenes;
    }

    public void setIdexamenes(Integer idexamenes) {
        this.idexamenes = idexamenes;
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

    public String getMessage() {
        return message;
    }
   
    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
    
    // gestion
    public List<Object[]> getList() {
        DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
        
        List<Object[]> list = daoPreguntas.preguntasQry();

        if (list == null) {
            message = daoPreguntas.getMessage();
        }

        return list;
    }
    
    public List<Examenes> getCombo() {
        DaoExamenes daoExamenes = new DaoExamenesImpl();
        List<Examenes> list = daoExamenes.examenesQry();
        
        if (list == null) {
            message = daoExamenes.getMessage();
        }

        return list;
    }
    
    public String preguntasIns() {
        Examenes e = new Examenes();
        e.setIdexamen(idexamenes);
        
        Preguntas p = new Preguntas();
        p.setIdexamen(e);
        p.setPregunta(pregunta);
        p.setPrioridad(prioridad);
        
        DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
        message = daoPreguntas.preguntasIns(p);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/preguntasIns";
        }
    }

    public String preguntasDel() {
        Integer list_ids = DeString.aInteger(ids);

        if (list_ids != null) {
            DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
            message = daoPreguntas.preguntasDel(list_ids);
        } else {
            message = "IDs Incorrectos o no envíados";
        }

        return "/index";
    }

    public String preguntasGet() {
        DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
        Preguntas p = daoPreguntas.preguntasGet(idpreguntas);

        String retorno = "/preguntasUpd";
        if(p == null){
            message = daoPreguntas.getMessage();
            retorno ="/index";
        }else{
            idpreguntas = p.getIdpregunta();
            idexamenes = p.getIdexamen().getIdexamen();
            pregunta = p.getPregunta();
            prioridad = p.getPrioridad();
        }
        return retorno;
    }

    public String preguntasUpd() {
        DaoPreguntas daoPreguntas = new DaoPreguntasImpl();
        
        Examenes e = new Examenes();
        e.setIdexamen(idexamenes);
        
        Preguntas p = daoPreguntas.preguntasGet(idpreguntas);
        p.setIdexamen(e);
        p.setPregunta(pregunta);
        p.setPrioridad(prioridad);
        
        message = daoPreguntas.preguntasUpd(p);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/preguntasUpd";
        }
    }

}

