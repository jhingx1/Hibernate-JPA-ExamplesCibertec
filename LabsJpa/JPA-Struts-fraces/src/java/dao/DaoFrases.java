package dao;

import hibernate.domain.Frases;
import java.util.List;

public interface DaoFrases {
    
    public List<Object[]> frasesQry();
    
    public String frasesIns(Frases frases);

    public String frasesDel(Integer idfrase);

    public Frases frasesGet(Integer idfrase);

    public String frasesUpd(Frases frases);
    
    public String getMessage();
}

