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

//para mostrar paginación

public class Prueba19 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------

        String s = "select iddepartamento, departamento from Departamentos";

        Query query = session.createQuery(s);
        query.setFirstResult(0); // 0, 5, 10, 15, 20 (a partir de)

        query.setMaxResults(5); // cantidad de filas
        Iterator it = query.iterate();
        while (it.hasNext()) {
            Object[] fil = (Object[]) it.next();
            System.out.println();
            for (Object obj : fil) {
                System.out.print(obj + "\t");
            }
        }

        //Obligatorio        
        session.getTransaction().commit();
    }
}
