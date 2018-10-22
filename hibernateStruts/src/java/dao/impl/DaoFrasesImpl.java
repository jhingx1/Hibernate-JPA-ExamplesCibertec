package dao.impl;

import dao.DaoFrases;
import hibernate.domain.Frases;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoFrasesImpl implements DaoFrases {

    private final Session session;
    private final Transaction tx;
    private String message;

    //Envia una session hibernate session(tener presente la session)
    //ocurre un mejor desacoplamiento.
    public DaoFrasesImpl(Session session) {
        this.session = session;
        this.tx = this.session.beginTransaction();
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> frasesQry() {
        List<Object[]> list = null;

        String s = "select f.idfrase,a.autor,f.frase "
                + "from Frases f inner join f.autores a";
        
        try {
            Query query = session.createQuery(s);
            list = query.list();

        } catch (HibernateException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String frasesInsUpd(Frases frases) {
        try {
            session.persist(frases);
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
        }

        return message;
    }

    @Override
    public String frasesDel(List<Integer> ids) {
        try {
            String hql = "delete Frases f where f.idfrase = :id";
            Query query = session.createQuery(hql);

            for (Integer idautor : ids) {
                query.setInteger("id", idautor);
                int ctos = query.executeUpdate();

                if (ctos == 0) {
                    throw new HibernateException("0 filas afectadas.");
                }
            }
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
        }

        return message;
    }

    @Override
    public Frases frasesGet(Integer idfrase) {
        Frases frases
                = (Frases) session.get(Frases.class, idfrase);
        
        return frases;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

