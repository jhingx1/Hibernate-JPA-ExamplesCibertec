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

//Consultando Distritos tenga un listado de departamento, provincia y distrito.
public class Prueba08 {

    public static void main(String[] args) {
        //obligatorio
        Session session
                = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //--------
        String s = "from Distritos";//sentencia hql, no es la tabla. Siempre com mayuscula la primera        

        Query query = session.createQuery(s);       
        
        List<Distritos> listDistritos = query.list();
        for(Distritos  d:listDistritos){
            System.out.println(
            "Departamento : " + d.getProvincias().getDepartamentos().getDepartamento()
            +" Provincia : "+d.getProvincias().getProvincia()
            +" Distrito : "+d.getDistrito());             
        }        
        //Obligatorio        
        session.getTransaction().commit();
    }
}
