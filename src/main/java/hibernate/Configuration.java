package hibernate;

import hibernate.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.logging.Level;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class Configuration {

    public static SessionFactory SESSION_FACTORY = null;

    static {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        SESSION_FACTORY = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
    }

    public static Session getSession() {
        if (SESSION_FACTORY != null) {
            return SESSION_FACTORY.getCurrentSession();
        }
        return null;
    }
}
