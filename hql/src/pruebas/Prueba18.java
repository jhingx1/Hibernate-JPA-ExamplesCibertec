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

//mostrar lista de alumnos que tienen alguna nota 11 o alguna nota 12
public class Prueba18 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //-----------------
        String s = "select idalumno, nombre from Alumnos where "
                + "idalumno in"
                + "(select alumnos.idalumno from Notas "
                + "where nota=11)"
                + " and "
                + "idalumno in"
                + "(select alumnos.idalumno from Notas "
                + "where nota=12)";
        Query query = session.createQuery(s);
        Iterator it = query.iterate();
        while (it.hasNext()) {
            Object[] fil = (Object[]) it.next();
            ///System.out.println();
            for (Object obj : fil) {
                System.out.print(obj + "\t");
            }
        }
        //Obligatorio        
        session.getTransaction().commit();
    }
}
