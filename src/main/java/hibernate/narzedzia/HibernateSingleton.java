
package hibernate.narzedzia;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSingleton {
 
    private static final SessionFactory sessionFactory;
 
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Próba stworzenia obiektu klasy SessionFactory nie powiodła się." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory pobierzSessionFactory() {
        return sessionFactory;
    }
 
}
