package web.servlet;

import dao.DaoTutoriales;
import dao.impl.DaoTutorialesImpl;
import hibernate.domain.Tutoriales;
import hibernate.util.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import parainfo.convert.DeString;
import web.validator.TutorialesValidator;

@WebServlet(name = "TutorialesServlet", 
        urlPatterns = {"/Tutoriales", "/view/Tutoriales"})
public class TutorialesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "tutorialesQry.jsp";
        //
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        DaoTutoriales daoTutoriales = new DaoTutorialesImpl(session);

        switch (accion) {
            case "QRY":
                List<Tutoriales> list = daoTutoriales.tutorialesQry();

                if (list != null) {
                    request.setAttribute("list", list);
                } else {
                    result = daoTutoriales.getMessage();
                }
                break;

            case "INS":
                Tutoriales tutoriales = new Tutoriales();
                TutorialesValidator validator = new TutorialesValidator();
                result = validator.valida(request, tutoriales, "INS");

                if (result == null) {
                    result = daoTutoriales.tutorialesIns(tutoriales);
                }

                if (result != null) {
                    request.setAttribute("tutoriales", tutoriales);
                    target = "tutorialesIns.jsp";
                } else {
                    target = "redirect";
                }
                break;

            case "DEL":
                List<Integer> ids
                        = DeString.ids(request.getParameter("ids"));

                if (ids == null) {
                    result = "Lista de ID(s) incorrecta";
                } else {
                    result = daoTutoriales.tutorialesDel(ids);
                }

                if (result != null) {
                    target = "Tutoriales?accion=QRY";
                } else {
                    target = "redirect";
                }
                break;

            case "GET":
                Integer idtutorial
                        = DeString.aInteger(request.getParameter("idtutorial"));

                if (idtutorial != null) {
                    tutoriales = daoTutoriales.tutorialesGet(idtutorial);

                    if (tutoriales != null) {
                        request.setAttribute("tutoriales", tutoriales);
                        target = "tutorialesUpd.jsp";
                    } else {
                        result = daoTutoriales.getMessage();
                    }
                } else {
                    result = "ID incorrecto";
                }

                if (result != null) {
                    target = "Tutoriales?accion=QRY";
                }
                break;

            case "UPD":
                tutoriales = new Tutoriales();
                validator = new TutorialesValidator();
                result = validator.valida(request, tutoriales, "UPD");

                if (result == null) {
                    result = daoTutoriales.tutorialesUpd(tutoriales);
                }

                if (result != null) {
                    request.setAttribute("tutoriales", tutoriales);
                    target = "tutorialesUpd.jsp";
                } else {
                    target = "redirect";
                }
                break;

            case "":
                result = "Solicitud requerida";
                break;

            default:
                result = "Solicitud no reconocida";
        }

        if (session.isOpen()) {
            session.close();
        }

        if (result != null) {
            request.setAttribute("msg", result);
        }

        if (target.compareTo("redirect") == 0) {
            response.sendRedirect("../");

        } else {
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(target);
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}