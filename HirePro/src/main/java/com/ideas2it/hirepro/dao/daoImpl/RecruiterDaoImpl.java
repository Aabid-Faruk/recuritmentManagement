package com.ideas2it.hirepro.dao.daoImpl;

import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.dao.RecruiterDao;
import com.ideas2it.hirepro.model.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Service class for Recruiter
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
@Component
@Transactional
public class RecruiterDaoImpl implements RecruiterDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public void createRecruiter(Recruiter recruiter) throws RecruitmentException {
        try {
            this.hibernateTemplate.saveOrUpdate(recruiter);
        } catch (Exception exception) {
            throw new RecruitmentException(exception.getMessage());
        }
    }

    @Override
    public List<Recruiter> getRecruiters() throws RecruitmentException{
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Recruiter> criteriaQuery = criteriaBuilder.createQuery(Recruiter.class);
            Root<Recruiter> recruiter = criteriaQuery.from(Recruiter.class);

            Predicate notDeleted = criteriaBuilder.equal(recruiter.get("isDeleted"),0);
            criteriaQuery.where(notDeleted);
            TypedQuery<Recruiter> query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();

        } catch (Exception exception) {
            throw new RecruitmentException(exception.getMessage());
        }
    }

    @Override
    public void deleteRecruiter(int recruiterId) throws RecruitmentException {
        try{
            Recruiter recruiter = this.hibernateTemplate.load(Recruiter.class, recruiterId);
            this.hibernateTemplate.delete(recruiter);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RecruitmentException(exception.getMessage());
        }

    }
    
    @Override
    public Recruiter getRecruiter(int recruiterId) throws RecruitmentException {
        Recruiter recruiter;
        try {
            recruiter =  this.hibernateTemplate.get(Recruiter.class, recruiterId);
        } catch (Exception exception) {
            throw new RecruitmentException(exception.getMessage());
        }
        return recruiter;
    }
}