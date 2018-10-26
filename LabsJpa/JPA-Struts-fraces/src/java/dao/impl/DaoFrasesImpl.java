package dao.impl;

import dao.DaoFrases;
import hibernate.domain.Frases;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoFrasesImpl implements DaoFrases {

    private final EntityManagerFactory emf;
    private String message;

    public DaoFrasesImpl() {
        emf = Persistence.createEntityManagerFactory("JPAhibernateStruts_PU");
    }

    @Override
    public List<Object[]> frasesQry() {
        message = null;
        List<Object[]> list = null;

        String s = "select f.idfrase, a.autor, f.frase "
                + "from Frases f inner join f.idautor a";
        
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery(s);
            list = query.getResultList();

        } catch (Exception e) {
            message = e.getMessage();
        }

        //em.close();
        return list;
    }

    @Override
    public String frasesIns(Frases frases) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(frases);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public String frasesDel(Integer idfrase) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Frases frases = (Frases) em.find(Frases.class, idfrase);
            em.remove(frases);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public Frases frasesGet(Integer idfrase) {
        message = null;
        Frases frases = null;

        EntityManager em = emf.createEntityManager();

        try {
            frases = em.find(Frases.class, idfrase );

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return frases;
    }

    @Override
    public String frasesUpd(Frases frases) {
        message = null;
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(frases);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
