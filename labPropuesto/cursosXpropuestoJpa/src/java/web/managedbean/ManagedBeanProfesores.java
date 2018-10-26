package web.managedbean;

import dao.DaoProfesores;
import dao.impl.DaoProfesoresImpl;
import hibernate.domain.Profesores;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbProfesores")
@RequestScoped
public class ManagedBeanProfesores {

    private Profesores profesores = new Profesores();
    private String message;
    private String ids;

    public ManagedBeanProfesores() {
    }

    // gettter y setter
    public Profesores getProfesores() {
        return profesores;
    }

    public void setProfesores(Profesores profesores) {
        this.profesores = profesores;
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
    
    //CRUD
    
    public List<Profesores> getList() {        
        DaoProfesores daoProfesores = new DaoProfesoresImpl();
        
        List<Profesores> list = daoProfesores.profesoresQry();
        if(list == null){
            message = daoProfesores.getMessage();
        }

        return list;
    }
    public String profesoresIns() {
        DaoProfesores daoProfesores = new DaoProfesoresImpl();
        message = daoProfesores.profesoresIns(profesores);

        if (message == null) {
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresIns";
        }
    }

    public String profesoresDel() {
        Integer list_ids = DeString.aInteger(ids);

        if (list_ids != null) {
            DaoProfesores daoProfesores = new DaoProfesoresImpl();
            message = daoProfesores.profesoresDel(list_ids);
        } else {
            message = "IDs Incorrectos o no envíados";
        }

        return "/autoresQry";
    }

    public String profesoresGet() {
        DaoProfesores daoProfesores = new DaoProfesoresImpl();
        profesores = daoProfesores.profesoresGet(profesores.getIdprofesores());

        if (profesores != null) {
            return "/autoresUpd";
        } else {
            message = daoProfesores.getMessage();
            return "/autoresQry";
        }
    }

    public String profesoresUpd() {
        DaoProfesores daoProfesores = new DaoProfesoresImpl();
        message = daoProfesores.profesoresUpd(profesores);

        if (message == null) {
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresUpd";
        }
    }
}

