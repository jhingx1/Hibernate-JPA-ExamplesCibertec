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

//Consultar las Notas y que tenga un listado de nombre de alumno con sus respectivas nota.
public class Prueba07 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------
        String s = "from Notas";//sentencia hql, no es la tabla. Siempre com mayuscula la primera        

        Query query = session.createQuery(s);

        Iterator it = query.iterate();
        while (it.hasNext()) {
            Notas n = (Notas) it.next();
            System.out.println(
                    n.getAlumnos().getNombre() + "\t" + n.getNota());            
        }

        //Obligatorio        
        session.getTransaction().commit();
    }
}
