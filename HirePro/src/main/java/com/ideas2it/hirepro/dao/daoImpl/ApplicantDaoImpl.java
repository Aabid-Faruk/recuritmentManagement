package com.ideas2it.hirepro.dao.daoImpl;

import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.dao.ApplicantDao;
import com.ideas2it.hirepro.model.Applicant;
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
 * Service class for Applicant
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
@Component
@Transactional
public class ApplicantDaoImpl implements ApplicantDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public void createApplicant(Applicant applicant) throws RecruitmentException {
        try {
            this.hibernateTemplate.saveOrUpdate(applicant);
        } catch (Exception exception) {
            throw new RecruitmentException(exception.getMessage());
        }
    }

    @Override
    public List<Applicant> getApplicants() throws RecruitmentException{
        try {
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<Applicant> criteriaQuery = criteriaBuilder.createQuery(Applicant.class);
            Root<Applicant> applicant = criteriaQuery.from(Applicant.class);

            Predicate notDeleted = criteriaBuilder.equal(applicant.get("isDeleted"),0);
            criteriaQuery.where(notDeleted);
            TypedQuery<Applicant> query = entityManager.createQuery(criteriaQuery);
            return query.getResultList();

        } catch (Exception exception) {
            throw new RecruitmentException(exception.getMessage());
        }
    }

    @Override
    public void deleteApplicant(int applicantId) throws RecruitmentException {
        try{
            Applicant applicant = this.hibernateTemplate.load(Applicant.class, applicantId);
            this.hibernateTemplate.delete(applicant);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new RecruitmentException(exception.getMessage());
        }

    }
    @Override
    public Applicant getApplicant(int applicantId) throws RecruitmentException {
        Applicant applicant;
        try {
            applicant =  this.hibernateTemplate.get(Applicant.class, applicantId);
        } catch (Exception exception) {
            throw new RecruitmentException(exception.getMessage());
        }
        return applicant;
    }

	@Override
	public List<Applicant> getApplicantsByIds(List<String> applicantIds) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Applicant> criteriaQuery = criteriaBuilder.createQuery(Applicant.class);
        Root<Applicant> applicant = criteriaQuery.from(Applicant.class);

        //Predicate notDeleted = criteriaBuilder.equal(applicant.get("isDeleted"),0);
        criteriaQuery.select(applicant).where(applicant.get("applicantId").in(applicantIds));
        TypedQuery<Applicant> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
	}
}