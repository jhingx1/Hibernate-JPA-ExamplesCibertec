package web.managedbean;

import dao.DaoAutores;
import dao.impl.DaoAutoresImpl;
import hibernate.domain.Autores;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import parainfo.convert.DeString;

@ManagedBean(name = "mbAutores")
@RequestScoped
public class ManagedBeanAutores {

    private Autores autores = new Autores();
    private String message;
    private String ids;

    public ManagedBeanAutores() {
    }

    // gettter y setter
    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
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
    
    public List<Autores> getList() {
        
        DaoAutores daoAutores = new DaoAutoresImpl();
        
        List<Autores> list = daoAutores.autoresQry();
        if(list == null) {
            message = daoAutores.getMessage();
        }
        
        return list;
    }

    // gestion
    public String autoresIns() {
        DaoAutores daoAutores = new DaoAutoresImpl();
        message = daoAutores.autoresIns(autores);
            
        if (message == null) {
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresIns";
        }
    }

    public String autoresDel() {
       Integer list_ids = DeString.aInteger(ids);

        if (list_ids != null) {
            DaoAutores daoAutores = new DaoAutoresImpl();
            message = daoAutores.autoresDel(list_ids);
        } else {
            message = "Lista de ID(s) incorrecta";
        }

        return "/autoresQry";
    }

    public String autoresGet() {
        
        DaoAutores daoAutores = new DaoAutoresImpl();
        autores = daoAutores.autoresGet(autores.getIdautor());
        
        String retorno = "/autoresUpd";
        if (autores == null) {
            message = daoAutores.getMessage();
            retorno = "/autoresQry";
        }
        
        return retorno;
    }

    public String autoresUpd() {
        DaoAutores daoAutores = new DaoAutoresImpl();
        Autores a = daoAutores.autoresGet(autores.getIdautor());
        a.setAutor(autores.getAutor());
        
        message = daoAutores.autoresUpd(a);

        if (message == null) {
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresUpd";
        }
    }


}

