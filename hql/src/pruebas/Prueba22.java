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
public class Prueba22 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------

        String s = "select distrito from Distritos "
                + "where provincias.idprovincia = :idpro and "
                + "provincias.departamentos.iddepartamento = :iddep";
        Query query = session.createQuery(s);
        query.setInteger("idpro", 135); //
        query.setInteger("iddep", 14); //
        Iterator it = query.iterate();
        while (it.hasNext()) {
            Object fil = (Object) it.next();
            System.out.println(fil);
        }

        //Obligatorio        
        session.getTransaction().commit();
    }
}
