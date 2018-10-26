package dao.impl;

import dao.DaoCursos;
import hibernate.domain.Cursos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DaoCursosImpl implements DaoCursos {

    private final EntityManagerFactory emf;
    private String message;

    public DaoCursosImpl() {
        emf = Persistence.createEntityManagerFactory("cursosXpropuestoJpaPU");
    }

    @Override
    public List<Object[]> cursosQry() {
        message = null;
        List<Object[]> list = null;

        String s = "select c.idcursos, p.nombreprofesores,p.carrera,c.nombrecursos,c.descripcion,c.horas,c.fechainicio,c.fechafin "
                + "from Cursos c inner join c.idprofesores p";
        
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
    public String cursosIns(Cursos cursos) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(cursos);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public String cursosDel(Integer idfrase) {
        message = null;
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Cursos cursos = (Cursos) em.find(Cursos.class, idfrase);
            em.remove(cursos);
            em.getTransaction().commit();

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return message;
    }

    @Override
    public Cursos cursosGet(Integer idfrase) {
        message = null;
        Cursos cursos = null;

        EntityManager em = emf.createEntityManager();

        try {
            cursos = em.find(Cursos.class, idfrase );

        } catch (Exception e) {
            message = e.getMessage();
        }

        em.close();
        return cursos;
    }

    @Override
    public String cursosUpd(Cursos cursos) {
        message = null;
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            em.merge(cursos);
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
