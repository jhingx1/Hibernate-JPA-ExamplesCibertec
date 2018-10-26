package web.managedbean;

import dao.DaoAutores;
import dao.impl.DaoAutoresImpl;
import hibernate.domain.Autores;
import hibernate.util.HibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
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
        Session session = getSession();
        DaoAutores daoAutores = new DaoAutoresImpl(session);
        
        List<Autores> list = daoAutores.autoresQry();
        if(list == null) {
            message = daoAutores.getMessage();
        }
        
        session.close();
        return list;
    }

    // gestion
    public String autoresIns() {
        DaoAutores daoAutores = new DaoAutoresImpl(getSession());
        message = daoAutores.autoresInsUpd(autores);
            
        if (message == null) {
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresIns";
        }
    }

    public String autoresDel() {
        List<Integer> list_ids = DeString.ids(ids);

        if (list_ids != null) {
            DaoAutores daoAutores = new DaoAutoresImpl(getSession());
            message = daoAutores.autoresDel(list_ids);
        } else {
            message = "Lista de ID(s) incorrecta";
        }

        return "/autoresQry";
    }

    public String autoresGet() {
        Session session = getSession();
        DaoAutores daoAutores = new DaoAutoresImpl(session);
        autores = daoAutores.autoresGet(autores.getIdautor());
        
        String retorno = "/autoresUpd";
        if (autores == null) {
            message = daoAutores.getMessage();
            retorno = "/autoresQry";
        }
        
        session.close();
        return retorno;
    }

    public String autoresUpd() {
        DaoAutores daoAutores = new DaoAutoresImpl(getSession());
        Autores a = daoAutores.autoresGet(autores.getIdautor());
        a.setAutor(autores.getAutor());
        
        message = daoAutores.autoresInsUpd(a);

        if (message == null) {
            return "/autoresQry?faces-redirect=true";
        } else {
            return "/autoresUpd";
        }
    }

    // utilidades
    private Session getSession() {
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }
}

