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

//modificar datos de un alumno
public class Prueba27 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------

        // asume que idalumno=143
        Alumnos a = (Alumnos) session.get(Alumnos.class, 6);
        a.setNombre("aaax bbbx");
        session.update(a);
        System.out.println("Ok");
        
        session.getTransaction().commit();
        
    }
}
