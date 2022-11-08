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
import com.ideas2it.headHunt.dao.ApplicantDao;
import com.ideas2it.headHunt.dbsession.HibernateUtils;
import com.ideas2it.headHunt.model.Applicant;
import com.ideas2it.headHunt.model.Recruiter;
/*
 * Applicant Dao implementation class for headHunt Application 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public class ApplicantDaoImpl implements ApplicantDao {
    private CustomLogger customLogger = new CustomLogger(ApplicantDaoImpl.class);

    @Override
    public Applicant createApplicant(Applicant applicant) throws RecruitmentException {  
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;         
        
        try{
        	
            tx = session.beginTransaction();
            session.save(applicant);
            tx.commit();
            //applicant = (Applicant) session.get(Applicant.class, applicant.getApplicantId()); 	
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_101);
        } finally { 
            session.close();
        }
        return applicant;    
    }

    @Override
    public List<Applicant> viewApplicants() throws RecruitmentException {
        List<Applicant> applicants = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Applicant> cq = cb.createQuery(Applicant.class);
            Root<Applicant> applicant = cq.from(Applicant.class);
            cq.select(applicant);
            TypedQuery<Applicant> query = session.createQuery(cq); 
            applicants = query.getResultList();
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_104);
        } finally { 
            session.close();
        } 
        return applicants;       
    }

    @Override
    public Applicant viewApplicant(int id) throws RecruitmentException {
        Applicant applicant = null; 
        //List<Recruiter> list = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
      
        try{
            applicant = (Applicant) session.get(Applicant.class, id);
            //new ArrayList<Recruiter>(applicant.getRecruiters());
            //applicant.setRecruiters(list);
        } catch (Exception ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_103);
        } finally {
            session.close();
        } 
        return applicant;    
    }

    @Override
    public Applicant viewByEmail(String email) throws RecruitmentException {
        Applicant applicant = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            applicant = session.get(Applicant.class, email);
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_104);
        } finally { 
            session.close(); 
        } 
        return applicant;      
    }

    @Override
    public Applicant viewByNumber(String number) throws RecruitmentException {
        Applicant applicant = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{
            applicant = session.get(Applicant.class, number);
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_105);
        } finally { 
            session.close(); 
        } 
        return applicant;    
    }

    @Override
    public boolean isUpdated(Applicant updateApplicant, int id) throws RecruitmentException {
        boolean status = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;       

        try{
            Applicant applicant = session.get(Applicant.class, id);
            tx = session.beginTransaction();
            applicant.setName(updateApplicant.getName());
            applicant.setEmail(updateApplicant.getEmail());
            applicant.setContactNumber(updateApplicant.getContactNumber());
            applicant.setDateOfBirth(updateApplicant.getDateOfBirth());
            applicant.setGender(updateApplicant.getGender());
            applicant.setDegree(updateApplicant.getDegree());
            applicant.setExperience(updateApplicant.getExperience());
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
            Applicant applicant = session.get(Applicant.class, id);
            tx = session.beginTransaction();
            session.delete(applicant);
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
        }
        return status;
    } 

 /*   @Override
    public boolean assignRecruiter(int id, int recruiter_id) throws RecruitmentException {
        Applicant applicant = null;   
        Recruiter recruiter = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        boolean status = false;
        Transaction tx = null;

        try{
            applicant = session.get(Applicant.class, id); 
            recruiter = session.get(Recruiter.class, recruiter_id);
            status = applicant.getRecruiters().add(recruiter);
            System.out.println(recruiter);
            //List<Recruiter> list = new ArrayList<Recruiter>();
            //list.add(recruiter);
            //applicant.setRecruiters(list);
            tx = session.beginTransaction();
            session.save(applicant);
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
    public boolean unassignRecruiter(int id, int recruiter_id) throws RecruitmentException, SQLException {
        Applicant applicant = null;   
        Recruiter recruiter = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        boolean status = false;
        Transaction tx = null;

        try{
            applicant = session.get(Applicant.class, id); 
            recruiter = session.get(Recruiter.class, recruiter_id);
            List<Recruiter> list = applicant.getRecruiters();
            if (list.isEmpty()) {
            	return status;
            }
            status = list.remove(recruiter);
            applicant.setRecruiters(list);
            tx = session.beginTransaction();
            session.save(applicant);
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
    */

    @Override
    public List<Recruiter> getAssignedRecruiters(int id) throws RecruitmentException {
        List<Recruiter> list = null;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        try{            
            Applicant applicant = session.get(Applicant.class, id);
            
            if (null != applicant) {
            list = new ArrayList<Recruiter>(applicant.getRecruiters());
            }
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_112);
        } finally {
        	session.close();
        }
        return list;  
    }

    @Override
    public boolean isValidId(int id) throws RecruitmentException {
        boolean status = false;
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
      
        try{
            session.get(Applicant.class, id);
            status = true;
        } catch (HibernateException ex) {
            customLogger.error(ex.getMessage(), ex);
            throw new RecruitmentException(Constants.ERROR_103);
        } finally {
            session.close();           
        } 
        return status;    
    }
}