package com.topshelf.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory() {
        try {
            // create the session factory with the hibernate.cfg.xml
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml"); // not required if you have default xml name
            return config.buildSessionFactory();
        }catch(Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
    }
    
    // Singleton instance for SessionFactory 
    public static SessionFactory getSessionFactory() {
        return (sessionFactory == null)? sessionFactory = buildSessionFactory():sessionFactory;
    }
}
	
	

