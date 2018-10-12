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

//mostrar nombre de alumno y su promedio solo de aprobados, en
//orden de merito
public class Prueba16 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //-----------------
        String s = "select a.nombre, avg(n.nota) "
                + "from Alumnos as a inner join "
                + "a.notases as n "
                + "group by a.nombre "
                + "having avg(n.nota)>=11 "
                + "order by avg(n.nota) desc";
        Query query = session.createQuery(s);
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
