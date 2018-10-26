package hibernate.util;

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
            configuration.addResource("hibernate/domain/Autores.hbm.xml");
            configuration.addResource("hibernate/domain/Frases.hbm.xml");
            
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

