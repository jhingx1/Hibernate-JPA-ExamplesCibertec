package pruebas;

import hibernate.Alumnos;
import hibernate.Departamentos;
import hibernate.Distritos;
import hibernate.HibernateUtil;
import hibernate.Notas;
import hibernate.Provincias;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;

//Mostrar idalumno y nombre a través de alias:
public class Prueba09 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------

        String s = "select a.idalumno, a.nombre from Alumnos a";
        Query query = session.createQuery(s);
        Iterator it = query.iterate();
        
        while (it.hasNext()) {
            Object[] fil = (Object[]) it.next();
            System.out.println(fil[0] + "\t" + fil[1]);
        }

        //Obligatorio        
        session.getTransaction().commit();
    }
}
