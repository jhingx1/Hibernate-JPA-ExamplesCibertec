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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

//mostrar uso de parámetros (otro ejemplo)
public class Prueba26 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------

        Alumnos a = new Alumnos();
        a.setNombre("aaa bbb");
        //Para insetar notas hay que crear una notas.
        try {
            session.persist(a);
            session.getTransaction().commit();
            System.out.println("Ok");
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }

    }
}
