package web.validator;

import dto.Tutoriales;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import parainfo.convert.DeString;

/**
 * @author parainformaticos.com
 */
public class TutorialesValidator {

    public TutorialesValidator() {
    }

    /**
     * @param request
     * @param tutoriales
     * @param upd == true ("UPD") o false ("INS")
     * @return lista de ingresos incorrectos
     */
    public List<String> valida(
            HttpServletRequest request, Tutoriales tutoriales, 
            boolean upd) {
        List<String> list = new LinkedList<>();

        Integer idtutorial
                = DeString.aInteger(request.getParameter("idtutorial"));
        String titulo = request.getParameter("titulo");
        String tipo = request.getParameter("tipo");
        Double precio = DeString.aDouble(request.getParameter("precio"));

        if (upd && (idtutorial == null)) {
            list.add("ID incorrecto");
        }

        if ((titulo == null) || (titulo.trim().length() == 0)) {
            list.add("Ingrese T&iacute;tulo de Tutorial");
        }

        if ((tipo == null) || (tipo.trim().length() == 0)) {
            list.add("Seleccione Tipo de Tutorial");
        } else if ((tipo.compareTo("Separata") != 0)
                && (tipo.compareTo("Video") != 0)) {
            list.add("Tipo debe ser \"Separata\" o \"Video\"");
        }

        if (precio == null) {
            list.add("Ingrese Precio de Tutorial");
        } else if ((precio <= 0) || (precio > 100)) {
            list.add("Precio debe estar entre ]1, 100]");
        }

        tutoriales.setIdtutorial(idtutorial);
        tutoriales.setTitulo(titulo);
        tutoriales.setTipo(tipo);
        tutoriales.setPrecio(precio);

        return list;
    }
}

