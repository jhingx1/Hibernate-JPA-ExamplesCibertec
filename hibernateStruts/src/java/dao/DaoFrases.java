package dao;

import hibernate.domain.Frases;
import java.util.List;

public interface DaoFrases {
    
    public List<Object[]> frasesQry();
    
    public String frasesInsUpd(Frases frases);

    public String frasesDel(List<Integer> ids);

    public Frases frasesGet(Integer idfrase);
    
    public String getMessage();
}

