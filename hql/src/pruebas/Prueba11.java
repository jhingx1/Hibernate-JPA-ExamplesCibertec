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

//Mostrar INNER JOIN departamento, provincia y distrito.
public class Prueba11 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------
        
        String s = "select dep.departamento,p.provincia,d.distrito "
                +"from Departamentos dep inner join dep.provinciases p"
                +" inner join p.distritoses d";
                
        Query query = session.createQuery(s);
        Iterator it = query.iterate();
        while (it.hasNext()) {
            Object[] fil = (Object[]) it.next();
            System.out.println(fil[0] + "\t\t\t\t" + fil[1] +"\t\t\t\t"+ fil[2]);
        }

        //Obligatorio        
        session.getTransaction().commit();
    }
}
