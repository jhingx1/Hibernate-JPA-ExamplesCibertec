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

//para mostrar uso de parámetros (forma 1)
public class Prueba20 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------

        String s = "select idprovincia, provincia from Provincias "
                + "where iddepartamento = :pid";

        Query query = session.createQuery(s);
        query.setInteger("pid", 14); // provincias de Lima
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
