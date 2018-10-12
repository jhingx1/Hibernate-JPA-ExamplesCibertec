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

//Mostrar departamento con cantidad de provincias:
public class Prueba13 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //-----------------
        String s = "select dep.departamento, count(d.distrito) "
                +"from Departamentos dep inner join dep.provinciases p"
                +" inner join p.distritoses d"
                + " group by dep.departamento";

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
