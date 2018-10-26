package dao.impl;

import dao.DaoTutoriales;
import hibernate.domain.Tutoriales;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoTutorialesImpl implements DaoTutoriales {

    private final EntityManagerFactory emf;
    private String message;

    public DaoTutorialesImpl() {//El constructor esta completamente desacoplado debido a que no se le pasa ningun parametro
        this.emf = Persistence.createEntityManagerFactory("jpaTutorialesPU");//Cambiar si es necesario
    }

    @Override
    public List<Tutoriales> tutorialesQry() {
        message = null;
        List<Tutoriales> list = null;

        String s = "from Tutoriales";

        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery(s);
            list = query.getResultList();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return list;
    }

    @Override
    public String tutorialesIns(Tutoriales tutoriales) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(tutoriales);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public String tutorialesDel(Integer idtutorial) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Tutoriales tutoriales = (Tutoriales) em.find(Tutoriales.class, idtutorial);
            em.remove(tutoriales);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public Tutoriales tutorialesGet(Integer idtutorial) {
        message = null;
        Tutoriales tutoriales = null;

        EntityManager em = emf.createEntityManager();

        try {
            tutoriales = em.find(Tutoriales.class, idtutorial);

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return tutoriales;
    }

    @Override
    public String tutorialesUpd(Tutoriales tutoriales) {
        message = null;
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(tutoriales);
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
