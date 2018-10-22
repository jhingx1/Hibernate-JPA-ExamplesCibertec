package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoAutores;
import dao.DaoFrases;
import dao.impl.DaoAutoresImpl;
import dao.impl.DaoFrasesImpl;
import hibernate.domain.Autores;
import hibernate.domain.Frases;
import hibernate.util.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import parainfo.convert.DeString;

public class FrasesAction
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;

    private Frases frases;

    public FrasesAction() {
    }

    // getter y setter
    public Frases getFrases() {
        return frases;
    }

    public void setFrases(Frases frases) {
        this.frases = frases;
    }

    public List<Object[]> getList() {
        Session session = getSession();
        DaoFrases daoFrases = new DaoFrasesImpl(session);
        List<Object[]> list = daoFrases.frasesQry();

        if (list == null) {
            String msg = daoFrases.getMessage();

            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", msg);
        }

        session.close();
        return list;
    }

    public List<Autores> getCboAutores() {
        Session session = getSession();
        DaoAutores daoAutores = new DaoAutoresImpl(session);

        List<Autores> list = daoAutores.autoresQry();
        if (list == null) {
            String msg = daoAutores.getMessage();

            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", msg);
        }

        session.close();
        return list;
    }

    // gestiona CRUD
    public String frasesQry() {
        return SUCCESS;
    }

    public String frasesIns() {
        DaoFrases daoFrases = new DaoFrasesImpl(getSession());
        String result = daoFrases.frasesInsUpd(frases);

        if (result == null) {
            return SUCCESS;
        } else {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        }
    }

    public String frasesDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Integer> ids = DeString.ids(request.getParameter("ids"));

        String result;
        if (ids == null) {
            result = "Lista de ID(s) incorrecta";
        } else {
            DaoFrases daoFrases = new DaoFrasesImpl(getSession());
            result = daoFrases.frasesDel(ids);
        }

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String frasesGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer idfrase
                = DeString.aInteger(request.getParameter("idfrase"));

        String result = null;
        if (idfrase != null) {
            Session session = getSession();
            DaoFrases daoFrases = new DaoFrasesImpl(session);
            frases = daoFrases.frasesGet(idfrase);

            if (frases == null) {
                result = daoFrases.getMessage();
            }
            
            session.close();
        } else {
            result = "ID incorrecto";
        }

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String frasesUpd() {
        DaoFrases daoFrases = new DaoFrasesImpl(getSession());
        Frases f = daoFrases.frasesGet(frases.getIdfrase());

        Autores a = new Autores();
        a.setIdautor(frases.getAutores().getIdautor());
        
        f.setAutores(a);
        f.setFrase(frases.getFrase());

        String result = daoFrases.frasesInsUpd(f);

        if (result == null) {
            return SUCCESS;
        } else {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        }
    }

    // validaciones
    @Override
    public void validate() {
        if (frases != null) {
            if ((frases.getAutores().getIdautor() == null)) {
                addFieldError("frases.autores.idautor",
                        "Seleccione Autor");
            }

            if ((frases.getFrase() == null)
                    || (frases.getFrase().trim().length() == 0)) {
                addFieldError("frases.frase",
                        "ingrese Frase Célebre");
            }
        }
    }

    // utilidad
    private Session getSession() {
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        return session;
    }
}

