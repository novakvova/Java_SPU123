package org.example.utils;

import org.example.models.Category;
import org.example.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the Hibernate configuration from hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // If you have entity classes, add them here using the addAnnotatedClass() method
            // For example: configuration.addAnnotatedClass(com.example.User.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Category.class);

            // Build the SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            // Handle any exceptions here (e.g., log the error)
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}