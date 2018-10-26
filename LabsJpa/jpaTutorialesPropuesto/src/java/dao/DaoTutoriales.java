package dao;

import hibernate.domain.Tutoriales;
import java.util.List;

public interface DaoTutoriales {

    public List<Tutoriales> tutorialesQry();

    public String tutorialesIns(Tutoriales tutoriales);
    //Se debe de hacer 
    public String tutorialesDel(Integer idtutorial);//eliminado fila por fila, no grupo de filas

    public Tutoriales tutorialesGet(Integer idtutorial);

    public String tutorialesUpd(Tutoriales tutoriales);
    
    public String getMessage();
}

