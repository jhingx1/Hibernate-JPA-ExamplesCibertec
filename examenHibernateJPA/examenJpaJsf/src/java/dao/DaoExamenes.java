package dao;

import hibernate.domain.Examenes;
import java.util.List;

public interface DaoExamenes {

    public List<Examenes> examenesQry();

    public String examenesIns(Examenes examenes);

    public String examenesDel(List<Integer> ids);

    public Examenes examenesGet(Integer idexamen);

    public String examenesUpd(Examenes examenes);

    public List<Object[]> examenesCbo();
    
    public String getMessage();
}

