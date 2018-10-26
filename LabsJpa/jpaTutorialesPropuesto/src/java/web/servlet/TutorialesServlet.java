package web.servlet;

import dao.DaoTutoriales;
import dao.impl.DaoTutorialesImpl;
import hibernate.domain.Tutoriales;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import parainfo.convert.DeString;
import web.validator.TutorialesValidator;

@WebServlet(name = "TutorialesServlet",
        urlPatterns = {"/Tutoriales", "/view/Tutoriales"})
public class TutorialesServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "tutorialesQry.jsp";
        List<String> message = new LinkedList<>();
        //
        DaoTutoriales daoTutoriales = new DaoTutorialesImpl();

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
                String msg = daoTutoriales.tutorialesIns(tutoriales);

                if (message.isEmpty()) {
                    result = daoTutoriales.tutorialesIns(tutoriales);
                }

                if (message.isEmpty() && (result == null)) {
                    target = "redirect";
                } else {
                    request.setAttribute("tutoriales", tutoriales);
                    target = "tutorialesIns.jsp";
                }

                break;

            case "DEL":

                List<Integer> ids = DeString.ids(request.getParameter("ids"));

                for (Integer i : ids) {                    
                    
                    if (i == null) {
                        result = "Lista de ID(s) incorrecta";
                    } else {
                        result = daoTutoriales.tutorialesDel(i);
                    }
                }

                target = (result == null)
                        ? "redirect" // resetea request
                        : "Tutoriales?accion=QRY"; // conserva request

                break;

            case "GET":
                Integer idtutorial
                        = DeString.aInteger(
                                request.getParameter("idtutorial"));

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

                break;

            case "":
                result = "Solicitud requerida";
                break;

            default:
                result = "Solicitud no reconocida";
        }

        if (result != null) {
            message.add(result);
        }

        if (!message.isEmpty()) {
            request.setAttribute("msg", message);
        }

        if (target.compareTo("redirect") == 0) {
            response.sendRedirect("../"); // resetea request

        } else { // conserva request
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(target);
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="doGet y doPost.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
