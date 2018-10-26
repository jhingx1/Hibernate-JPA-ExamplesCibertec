package dao.impl;

import dao.DaoAutores;
import hibernate.domain.Autores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoAutoresImpl implements DaoAutores {

    private final EntityManagerFactory emf;
    private String message;

    public DaoAutoresImpl() {
        emf = Persistence.createEntityManagerFactory("JPAhibernateStruts_PU");
    }

    @Override
    public List<Autores> autoresQry() {
        message = null;
        List<Autores> list = null;

        String s = "from Autores";

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
    public String autoresIns(Autores autores) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(autores);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public String autoresDel(Integer idautor) {
         message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Autores autores = (Autores) em.find(Autores.class, idautor);
            em.remove(autores);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public Autores autoresGet(Integer idautor) {
        message = null;
        Autores autores = null;

        EntityManager em = emf.createEntityManager();

        try {
            autores = em.find(Autores.class, idautor);

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return autores;
    }

    @Override
    public String autoresUpd(Autores autores) {
        message = null;
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(autores);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public List<Object[]> autoresCbo() {
         message = null;
        List<Object[]> list = null;

        String s = "select idautor, autor from Autores";

        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery(s);
            list = query.getResultList();

        } catch (Exception e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
