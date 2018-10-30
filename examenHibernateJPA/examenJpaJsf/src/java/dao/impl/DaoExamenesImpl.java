package dao.impl;

import dao.DaoExamenes;
import hibernate.domain.Examenes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoExamenesImpl implements DaoExamenes {

    private final EntityManagerFactory emf;
    private String message;

    public DaoExamenesImpl() {
        emf = Persistence.createEntityManagerFactory("examenJpaJsfPU");
    }

    @Override
    public List<Examenes> examenesQry() {
        message = null;
        List<Examenes> list = null;

        String s = "from Examenes";

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
    public String examenesIns(Examenes examenes) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(examenes);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public String examenesDel(List<Integer> idexamenes) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            for(Integer idexamene:idexamenes){
                em.getTransaction().begin();
                Examenes examenes = (Examenes) em.find(Examenes.class, idexamene);
                em.remove(examenes);
                em.getTransaction().commit();            
            }
            

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public Examenes examenesGet(Integer idautor) {
        message = null;
        Examenes examenes = null;

        EntityManager em = emf.createEntityManager();

        try {
            examenes = em.find(Examenes.class, idautor);

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return examenes;
    }

    @Override
    public String examenesUpd(Examenes examenes) {
        message = null;
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(examenes);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public List<Object[]> examenesCbo() {
         message = null;
        List<Object[]> list = null;

        String s = "select idautor, autor from Examenes";

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
