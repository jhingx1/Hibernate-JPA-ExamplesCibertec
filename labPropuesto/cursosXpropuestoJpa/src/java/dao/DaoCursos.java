package dao;

import hibernate.domain.Cursos;
import java.util.List;

public interface DaoCursos {
    
    public List<Object[]> cursosQry();
    
    public String cursosIns(Cursos cursos);

    public String cursosDel(Integer idcurso);

    public Cursos cursosGet(Integer idcurso);

    public String cursosUpd(Cursos cursos);
    
    public String getMessage();
}

