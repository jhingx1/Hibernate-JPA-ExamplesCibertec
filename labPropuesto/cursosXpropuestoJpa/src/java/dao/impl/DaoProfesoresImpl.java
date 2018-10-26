package dao.impl;

import dao.DaoProfesores;
import hibernate.domain.Profesores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoProfesoresImpl implements DaoProfesores {

    private final EntityManagerFactory emf;
    private String message;

    public DaoProfesoresImpl() {
        emf = Persistence.createEntityManagerFactory("cursosXpropuestoJpaPU");
    }

    @Override
    public List<Profesores> profesoresQry() {
        message = null;
        List<Profesores> list = null;

        String s = "from Profesores";

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
    public String profesoresIns(Profesores profesores) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(profesores);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public String profesoresDel(Integer idautor) {
         message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Profesores profesores = (Profesores) em.find(Profesores.class, idautor);
            em.remove(profesores);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public Profesores profesoresGet(Integer idautor) {
        message = null;
        Profesores profesores = null;

        EntityManager em = emf.createEntityManager();

        try {
            profesores = em.find(Profesores.class, idautor);

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return profesores;
    }

    @Override
    public String profesoresUpd(Profesores profesores) {
        message = null;
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(profesores);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public List<Object[]> profesoresCbo() {
         message = null;
        List<Object[]> list = null;

        String s = "select idautor, autor from Profesores";

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
