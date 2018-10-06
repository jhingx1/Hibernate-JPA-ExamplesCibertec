package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    
     static {
        try {
            Configuration configuration = new Configuration();
            
            configuration.configure("hibernate.cfg.xml");
            configuration.addResource("hibernate/Alumnos.hbm.xml");
            configuration.addResource("hibernate/Notas.hbm.xml");
            configuration.addResource("hibernate/Departamentos.hbm.xml");
            configuration.addResource("hibernate/Provincias.hbm.xml");
            configuration.addResource("hibernate/Distritos.hbm.xml");
            
            ServiceRegistry serviceRegistry = 
                    new StandardServiceRegistryBuilder().applySettings(
                            configuration.getProperties()).build();
             
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
             
        } catch (HibernateException ex) {
            throw new ExceptionInInitializerError(ex);
        }
     }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

