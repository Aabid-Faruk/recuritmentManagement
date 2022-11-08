package com.ideas2it.headHunt.dbsession;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ideas2it.headHunt.model.Applicant;
import com.ideas2it.headHunt.model.Recruiter;

public class HibernateUtils {
    private static SessionFactory sessionFactory = null;

    private HibernateUtils() {
	try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Applicant.class)
            			 .addAnnotatedClass(Recruiter.class);
            
            sessionFactory = configuration.buildSessionFactory();

	} catch(HibernateException ex) {
            System.err.println(ex);			
	}		
    }

    public static SessionFactory getSessionFactory() {
        try {
            if ((sessionFactory == null) || (sessionFactory.isClosed())) {
                HibernateUtils hibernateUtils = new HibernateUtils();
            }
        } catch(HibernateException ex) {
            ex.printStackTrace();
            System.err.println("Session Factory not created due to some issue");
        } 
        return sessionFactory;
    }
}
