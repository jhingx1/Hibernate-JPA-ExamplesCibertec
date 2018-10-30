package dao;

import hibernate.domain.Preguntas;
import java.util.List;

public interface DaoPreguntas {

    public List<Object[]> preguntasQry();

    public String preguntasIns(Preguntas preguntas);

    public String preguntasDel(List<Integer> ids);

    public Preguntas preguntasGet(Integer idpregunta);

    public String preguntasUpd(Preguntas preguntas);
    
    public String getMessage();
}

