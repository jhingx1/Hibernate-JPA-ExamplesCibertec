package web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Validateable;
import dao.DaoAutores;
import dao.impl.DaoAutoresImpl;
import hibernate.domain.Autores;
import hibernate.util.HibernateUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import parainfo.convert.DeString;

public class AutoresAction
        extends ActionSupport implements Validateable {

    private static final long serialVersionUID = 1L;

    private Autores autores;

    public AutoresAction() {
    }

    // getter y setter
    public Autores getAutores() {
        return autores;
    }

    public void setAutores(Autores autores) {
        this.autores = autores;
    }

    public List<Autores> getList() {
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
    public String autoresQry() {
        return SUCCESS;
    }

    public String autoresIns() {
        DaoAutores daoAutores = new DaoAutoresImpl(getSession());
        String result = daoAutores.autoresInsUpd(autores);

        if (result == null) {
            return SUCCESS;
        } else {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        }
    }

    public String autoresDel() {
        HttpServletRequest request = ServletActionContext.getRequest();
        List<Integer> ids = DeString.ids(request.getParameter("ids"));

        String result;
        if (ids == null) {
            result = "Lista de ID(s) incorrecta";
        } else {
            DaoAutores daoAutores = new DaoAutoresImpl(getSession());
            result = daoAutores.autoresDel(ids);
        }

        if (result == null) {
            request.getSession().removeAttribute("msg");
            return SUCCESS;
        } else {
            request.getSession().setAttribute("msg", result);
            return ERROR;
        }
    }

    public String autoresGet() {
        HttpServletRequest request = ServletActionContext.getRequest();
        Integer idautor
                = DeString.aInteger(request.getParameter("idautor"));

        String result = null;
        if (idautor != null) {
            Session session = getSession();
            DaoAutores daoAutores = new DaoAutoresImpl(session);
            autores = daoAutores.autoresGet(idautor);

            if (autores == null) {
                result = daoAutores.getMessage();
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

    public String autoresUpd() {
        DaoAutores daoAutores = new DaoAutoresImpl(getSession());
        Autores a = daoAutores.autoresGet(autores.getIdautor());
        a.setAutor(autores.getAutor());

        String result = daoAutores.autoresInsUpd(a);

        if (result != null) {
            HttpServletRequest request
                    = ServletActionContext.getRequest();
            request.setAttribute("msg", result);
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    // validaciones
    @Override
    public void validate() {
        if (autores != null) {
            if ((autores.getAutor() == null)
                    || (autores.getAutor().trim().length() == 0)) {
                addFieldError("autores.autor",
                        "Ingrese nombre de Autor");
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
