package web.managedbean;

import dao.DaoAutores;
import dao.DaoFrases;
import dao.impl.DaoAutoresImpl;
import dao.impl.DaoFrasesImpl;
import hibernate.domain.Autores;
import hibernate.domain.Frases;
import hibernate.util.HibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;
import parainfo.convert.DeString;

@ManagedBean(name = "mbFrases")
@RequestScoped
public class ManagedBeanFrases {

    private Integer idfrase;
    private Integer idautor;
    private String frase;
    
    private String message;
    private String ids;

    public ManagedBeanFrases() {
    }

    // gettter y setter
    public Integer getIdfrase() {
        return idfrase;
    }

    public void setIdfrase(Integer idfrase) {
        this.idfrase = idfrase;
    }

    public Integer getIdautor() {
        return idautor;
    }

    public void setIdautor(Integer idautor) {
        this.idautor = idautor;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
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
        Session session = getSession();
        DaoFrases daoFrases = new DaoFrasesImpl(session);

        List<Object[]> list = daoFrases.frasesQry();
        if (list == null) {
            message = daoFrases.getMessage();
        }

        session.close();
        return list;
    }

    public List<Autores> getCombo() {
        Session session = getSession();
        DaoAutores daoAutores = new DaoAutoresImpl(session);

        List<Autores> list = daoAutores.autoresQry();
        if (list == null) {
            message = daoAutores.getMessage();
        }

        session.close();
        return list;
    }

    // gestion
    public String frasesIns() {
        Autores a = new Autores();
        a.setIdautor(idautor);
        
        Frases f = new Frases();
        f.setAutores(a);
        f.setFrase(frase);
        
        DaoFrases daoFrases = new DaoFrasesImpl(getSession());
        message = daoFrases.frasesInsUpd(f);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/frasesIns";
        }
    }

    public String frasesDel() {
        List<Integer> list_ids = DeString.ids(ids);

        if (list_ids != null) {
            DaoFrases daoFrases = new DaoFrasesImpl(getSession());
            message = daoFrases.frasesDel(list_ids);
        } else {
            message = "Lista de ID(s) incorrecta";
        }

        return "/index";
    }

    public String frasesGet() {
        Session session = getSession();
        DaoFrases daoFrases = new DaoFrasesImpl(session);
        Frases f = daoFrases.frasesGet(idfrase);
        
        String retorno = "/frasesUpd";
        if (f == null) {
            message = daoFrases.getMessage();
            retorno = "/index";
            
        } else {
            idfrase = f.getIdfrase();
            idautor = f.getAutores().getIdautor();
            frase = f.getFrase();
        }
        
        session.close();
        return retorno;
    }

    public String frasesUpd() {
        DaoFrases daoFrases = new DaoFrasesImpl(getSession());
        
        Autores a = new Autores();
        a.setIdautor(idautor);
        
        Frases f = daoFrases.frasesGet(idfrase);
        f.setAutores(a);
        f.setFrase(frase);

        message = daoFrases.frasesInsUpd(f);

        if (message == null) {
            return "/index?faces-redirect=true";
        } else {
            return "/frasesUpd";
        }
    }

    // utilidades
    private Session getSession() {
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }
}

