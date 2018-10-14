package dao.impl;

import dao.DaoTutoriales;
import hibernate.domain.Tutoriales;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoTutorialesImpl implements DaoTutoriales {

    private Session session = null;
    private Transaction tx = null;
    private String message;

    public DaoTutorialesImpl(Session session) {
        this.session = session;
        tx = this.session.beginTransaction();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Tutoriales> tutorialesQry() {
        List<Tutoriales> list = null;
        String s = "from Tutoriales";

        try {
            Query query = session.createQuery(s);
            list = query.list();

        } catch (HibernateException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String tutorialesIns(Tutoriales tutoriales) {
        try {
            session.persist(tutoriales);
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
        }

        return message;
    }

    @Override
    public String tutorialesDel(List<Integer> ids) {
        try {
            String hql = "delete Tutoriales t where t.idtutorial = :id";
            Query query = session.createQuery(hql);

            for (Integer idproducto : ids) {
                query.setInteger("id", idproducto);
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
    public Tutoriales tutorialesGet(Integer idtutorial) {
        Tutoriales tutoriales = 
                (Tutoriales) session.get(Tutoriales.class, idtutorial);
        
        return tutoriales;
    }

    @Override
    public String tutorialesUpd(Tutoriales tutoriales) {
        try {
            session.update(tutoriales);
            tx.commit();

        } catch (HibernateException e) {
            message = e.getMessage();
            tx.rollback();
        }

        return message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

