package dao.impl;

import dao.DaoPreguntas;
import hibernate.domain.Preguntas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoPreguntasImpl implements DaoPreguntas {

    private final EntityManagerFactory emf;
    private String message;

    public DaoPreguntasImpl() {
        emf = Persistence.createEntityManagerFactory("ExamenPersistenciaPU");
    }

    @Override
    public List<Object[]> preguntasQry() {
        message = null;
        List<Object[]> list = null;

        String s = "select a.idpregunta, e.titulo,a.pregunta ,a.prioridad "
                + "from Preguntas a inner join a.idexamen e ";

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
    public String preguntasIns(Preguntas preguntas) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(preguntas);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public String preguntasDel(List<Integer> ids) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            for (Integer idpregunta : ids) {
            em.getTransaction().begin();
            Preguntas preguntas = (Preguntas) em.find(Preguntas.class, idpregunta);
            em.remove(preguntas);
            em.getTransaction().commit();
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public Preguntas preguntasGet(Integer idpregunta) {
        message = null;
        Preguntas preguntas = null;

        EntityManager em = emf.createEntityManager();

        try {
            preguntas = em.find(Preguntas.class, idpregunta);

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return preguntas;
    }

    @Override
    public String preguntasUpd(Preguntas preguntas) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(preguntas);
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
