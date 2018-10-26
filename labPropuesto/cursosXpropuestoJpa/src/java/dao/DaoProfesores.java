package dao;

import hibernate.domain.Profesores;
import java.util.List;

public interface DaoProfesores {

    public List<Profesores> profesoresQry();

    public String profesoresIns(Profesores profesores);

    public String profesoresDel(Integer idprofesor);

    public Profesores profesoresGet(Integer idprofesor);

    public String profesoresUpd(Profesores profesores);

    public List<Object[]> profesoresCbo();
    
    public String getMessage();
}

