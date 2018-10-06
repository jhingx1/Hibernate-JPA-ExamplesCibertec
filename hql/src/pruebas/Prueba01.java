package pruebas;

import hibernate.Alumnos;
import hibernate.HibernateUtil;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;

public class Prueba01 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();        
        session.beginTransaction();
        //--------
        String s = "from Alumnos";//sentencia hql, no es la tabla. Siempre com mayuscula la primera
        Query query = session.createQuery(s);
        Iterator<Alumnos> it = query.iterate();
        while (it.hasNext()) {
            Alumnos a = it.next();
            //
            System.out.println(a.getIdalumno() + "\t" + a.getNombre());
        }
        
        //Obligatorio        
        session.getTransaction().commit();
    }
}
