package pruebas;

import hibernate.Alumnos;
import hibernate.Departamentos;
import hibernate.HibernateUtil;
import hibernate.Notas;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;

public class Prueba03 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();        
        session.beginTransaction();
        //--------
        String s = "from Departamentos";//sentencia hql, no es la tabla. Siempre com mayuscula la primera        
        
        Query query = session.createQuery(s);
        
        List<Departamentos> list = query.list();
        for(Departamentos  d:list){
            System.out.println(d.getDepartamento());
            /*
            Set<Notas> notaes = a.getNotases();
            for(Notas n:notaes){
                System.err.println("\t"+n.getNota());
            }
            */
        }
        
        //Obligatorio        
        session.getTransaction().commit();
    }
}
