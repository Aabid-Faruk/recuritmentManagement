package com.ideas2it.headHunt.dao.daoImpl;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.headHunt.constants.Constants;
import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.customLogger.CustomLogger;
import com.ideas2it.headHunt.dao.RecruiterDao;
import com.ideas2it.headHunt.dbsession.HibernateUtils;
import com.ideas2it.headHunt.model.Recruiter;
import com.ideas2it.headHunt.model.Applicant;
/**
 * Service class for Recruiter 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public class RecruiterDaoImpl implements RecruiterDao {
    private CustomLogger customLogger = new CustomLogger(RecruiterDaoImpl.class);

    @Override
    public Recruiter createRecruiter(Recruiter recruiter) throws RecruitmentException {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;         
        
        try{        	
            tx = session.beginTransaction();
            session.save(recruiter);
            tx.commit();
            recruiter = (Recruiter) session.get(Recruiter.class, recruiter.getRecruiterId()); 	
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_101);
        } finally {         	
            session.close();  
            sessionFactory.close();
        }
        return recruiter; 
    }

    @Override
    public List<Recruiter> viewRecruiters() throws RecruitmentException { 
        List<Recruiter> recruiters = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();   

        try{
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Recruiter> cq = cb.createQuery(Recruiter.class);
            Root<Recruiter> recruiter = cq.from(Recruiter.class);
            cq.select(recruiter);
            TypedQuery<Recruiter> query = session.createQuery(cq); 
            recruiters = query.getResultList();
            //Criteria criteria = session.createCriteria(Recruiter.class);
            //recruiters = (List<Recruiter>) criteria.list();
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_104);
        } finally { 
            session.close(); 
            sessionFactory.close();
        } 
        return recruiters;
    }


    @Override
    public Recruiter getById(int id) throws RecruitmentException {
        Recruiter recruiter = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
      
        try{
            recruiter = (Recruiter) session.get(Recruiter.class, id);
            List<Applicant> list = new ArrayList<>(recruiter.getApplicants());
            
            //recruiter.setApplicants(list);
            //System.out.println(recruiter.getApplicants());
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_103);
        } finally {
            session.close();
        } 
        return recruiter;  
    }

    @Override
    public Recruiter viewByEmail(String email) throws RecruitmentException {
        Recruiter recruiter = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{
        	recruiter = session.get(Recruiter.class, email);
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_104);
        } finally { 
            session.close(); 
            sessionFactory.close();
        } 
        return recruiter;    
    }

    @Override
    public Recruiter viewByNumber(String number) throws RecruitmentException {
        Recruiter recruiter = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            recruiter = session.get(Recruiter.class, number);
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_105);
        } finally { 
            session.close();
            sessionFactory.close();
        } 
        return recruiter;     
    }

    @Override
    public List<Applicant> getAssignedApplicants(int id) throws RecruitmentException {
        List<Applicant> list = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{            
            Recruiter recruiter = session.get(Recruiter.class, id);
            list = new ArrayList<Applicant>(recruiter.getApplicants());
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_112);
        } finally {
        	session.close();
        	sessionFactory.close();
        }
        return list;   
    }

    @Override
    public boolean isUpdated(Recruiter updateRecruiter, int id) throws RecruitmentException {
        boolean status = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;       

        try{
            Recruiter recruiter = (Recruiter) session.get(Recruiter.class, id);
            tx = session.beginTransaction();
            recruiter.setName(updateRecruiter.getName());
            recruiter.setEmail(updateRecruiter.getEmail());
            recruiter.setContactNumber(updateRecruiter.getContactNumber());
            recruiter.setDateOfBirth(updateRecruiter.getDateOfBirth());
            recruiter.setGender(updateRecruiter.getGender());
            recruiter.setExperience(updateRecruiter.getExperience());
            if(null!=updateRecruiter.getApplicants()) {
            	recruiter.setApplicants(updateRecruiter.getApplicants());
            }
            tx.commit();
            status = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_110);
        } finally {
            session.close();
            sessionFactory.close();
        }
        return status; 
    }

    @Override
    public boolean assignApplicant(int id, int applicant_id) throws RecruitmentException {
        Applicant applicant = null;   
        //Recruiter recruiter = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        boolean status = false;
        Transaction tx = null;

        try{
            
            applicant = session.get(Applicant.class, applicant_id);
            tx = session.beginTransaction();
            status = session.get(Recruiter.class, id).getApplicants().add(applicant);
            //status = recruiter.getApplicants().add(applicant);
            //System.out.println(applicant);
            //List<Applicant> list = new ArrayList<Applicant>();
            //list.add(applicant);
            //recruiter.setApplicants(list);
            //session.save(recruiter);
            tx.commit();
            //status = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_112);
        } finally {
        	session.close();
        	sessionFactory.close();
        }
        return status;
    }

    @Override
    public boolean unassignApplicant(int id, int applicant_id) throws RecruitmentException {
        Applicant applicant = null;   
        Recruiter recruiter = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        boolean status = false;
        Transaction tx = null;

        try{
            recruiter = session.get(Recruiter.class, id); 
            applicant = session.get(Applicant.class, applicant_id);
            List<Applicant> list = recruiter.getApplicants();
            if (list.isEmpty()) {
            	return status;
            }
            status = list.remove(applicant);
            recruiter.setApplicants(list);
            tx = session.beginTransaction();
            session.save(recruiter);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_112);
        } finally {
        	session.close();
        	sessionFactory.close();
        }
        return status;
    }

    @Override
    public boolean isDeleted(int id) throws RecruitmentException {        
        boolean status = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;      

        try{
            Recruiter recruiter = (Recruiter) session.get(Recruiter.class, id);
            tx = session.beginTransaction();
            session.delete(recruiter);
            tx.commit();
            status = true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_101);
        } finally { 
            session.close(); 
            sessionFactory.close();            
        }
        return status;
    }

    @Override
    public boolean isValidId(int id) throws RecruitmentException {
        boolean status = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
      
        try{
            session.get(Recruiter.class, id);
            status = true;
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_103);
        } finally {
            session.close();
            sessionFactory.close();
        } 
        return status;        
    }
}