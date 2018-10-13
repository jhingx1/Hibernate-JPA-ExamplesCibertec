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

//mostrar uso de parámetros (otro ejemplo)
public class Prueba23 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------

        String s = "select iddepartamento, departamento from Departamentos "
                + "where iddepartamento=1";
        Query query = session.createQuery(s);
        Object[] fila = (Object[]) query.uniqueResult();
        System.out.println(fila[0] + "\t" + fila[1]);

        //Obligatorio        
        session.getTransaction().commit();
    }
}