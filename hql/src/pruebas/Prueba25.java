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
public class Prueba25 {
    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------

        // consulta almacenada: Distritos.hbm.xml
        Query query = session.getNamedQuery(
                "hibernate.Distritos.peru");

        Iterator it = query.iterate();
        while (it.hasNext()) {
            Object[] fila = (Object[]) it.next();
            for (int col = 0; col < fila.length; ++col) {
                System.out.print(String.format("%-25s",
                        fila[col].toString()));
            }
            System.out.println();
        }

        //Obligatorio        
        session.getTransaction().commit();
    }
}
