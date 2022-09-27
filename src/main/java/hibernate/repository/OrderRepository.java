package hibernate.repository;

import hibernate.Configuration;
import hibernate.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Muzhzukhin
 * ¯\_(ツ)_/¯
 */
public class OrderRepository {

    private final Session session = Configuration.getSession();

    public boolean create(Order order) {
        boolean result = false;
        if (session != null) {
            session.beginTransaction();
            session.persist(order);
            session.getTransaction().commit();
            result = true;
        } else {
            System.err.println("Сессия не найдена");
        }
        return result;
    }

    public boolean update(Order order) {
        boolean result = false;
        if (session != null) {
            session.beginTransaction();
            session.update(order);
            session.getTransaction().commit();
            result = true;
        } else {
            System.err.println("Сессия не найдена");
        }
        return result;
    }

    public boolean delete(int id) {
        boolean result = false;
        if (session != null) {
            session.beginTransaction();
            Order order = session.get(Order.class, id);
            if (order != null) {
                session.delete(order);
                result = true;
            }
            session.getTransaction().commit();
        } else {
            System.err.println("Сессия не найдена");
        }
        return result;
    }

    public Order getById(int id) {
        Order order = null;
        if (session != null) {
            session.beginTransaction();
            order = session.get(Order.class, id);
            session.getTransaction().commit();
        } else {
            System.err.println("Сессия не найдена");
        }
        return order;
    }

    public List<Order> getAll() {
        List<Order> order = new ArrayList<>();
        if (session != null) {
            session.beginTransaction();
            order = session.createQuery("from Order", Order.class).getResultList();
            session.getTransaction().commit();
        } else {
            System.err.println("Сессия не найдена");
        }
        return order;
    }
}
