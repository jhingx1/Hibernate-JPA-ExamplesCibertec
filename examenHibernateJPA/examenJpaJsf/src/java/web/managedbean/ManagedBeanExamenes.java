package web.managedbean;


import dao.DaoExamenes;
import dao.impl.DaoExamenesImpl;
import hibernate.domain.Examenes;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbExamenes")
@RequestScoped
public class ManagedBeanExamenes {

    private Examenes examenes = new Examenes();
    private String message;
    private String ids;

    public ManagedBeanExamenes() {
    }

    // gettter y setter
    public Examenes getExamenes() {
        return examenes;
    }

    public void setExamenes(Examenes examenes) {
        this.examenes = examenes;
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
    
    public List<Examenes> getList() {
        
        DaoExamenes daoExamenes = new DaoExamenesImpl();
        
        List<Examenes> list = daoExamenes.examenesQry();
        if(list == null) {
            message = daoExamenes.getMessage();
        }
        
        return list;
    }

    // gestion
    public String examenesIns() {
        DaoExamenes daoExamenes = new DaoExamenesImpl();
        //message : es un mensaje de excepcion y debe de ser nulo.
        //si paso la insercion.
        message = daoExamenes.examenesIns(examenes);
            
        if (message == null) {
            return "/examenesQry?faces-redirect=true";
        } else {
            return "/examenesIns";
        }
    }

    public String examenesDel() {
        List<Integer> list_ids = DeString.ids(ids);

        if (list_ids != null) {
            DaoExamenes daoExamenes = new DaoExamenesImpl();
            message = daoExamenes.examenesDel(list_ids);
        } else {
            message = "Lista de ID(s) incorrecta";
        }

        return "/examenesQry";
    }

    public String examenesGet() {
        
        DaoExamenes daoExamenes = new DaoExamenesImpl();
        examenes = daoExamenes.examenesGet(examenes.getIdexamen());
        
        String retorno = "/examenesUpd";
        if (examenes == null) {
            message = daoExamenes.getMessage();
            retorno = "/examenesQry";
        }
        
        return retorno;
    }

    public String examenesUpd() {
        DaoExamenes daoExamenes = new DaoExamenesImpl();
        Examenes a = daoExamenes.examenesGet(examenes.getIdexamen());
        a.setTitulo(examenes.getTitulo());
        a.setDescripcion(examenes.getDescripcion());
        a.setDuracion(examenes.getDuracion());
        a.setPublicacion(examenes.getPublicacion());
        a.setMinimanota(examenes.getMinimanota());
        a.setActivo(examenes.getActivo());
        
        
        message = daoExamenes.examenesUpd(a);

        if (message == null) {
            return "/examenesQry?faces-redirect=true";
        } else {
            return "/examenesUpd";
        }
    }
}

