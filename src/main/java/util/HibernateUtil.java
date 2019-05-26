package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("Initial session factory creation failed" + e);
            throw new ExceptionInInitializerError("Błąd połączenia z bazą danych");
        }
    }

    public static Session openSession() throws Exception{
        Session session;
        try {
            session = sessionFactory.openSession();
        } catch (Exception e) {
            throw new Exception ("Błąd połączenia z bazą danych");
        }
        return session;
    }
}
