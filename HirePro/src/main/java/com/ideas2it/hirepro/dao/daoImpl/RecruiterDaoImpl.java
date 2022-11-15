package com.ideas2it.hirepro.dao.daoImpl;

import javax.transaction.Transactional;
import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.dao.RecruiterDao;
import com.ideas2it.hirepro.model.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service class for Recruiter 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
@Component
public class RecruiterDaoImpl implements RecruiterDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Transactional
    @Override
    public Integer createRecruiter(Recruiter recruiter) throws RecruitmentException {
        Integer id = (Integer) this.hibernateTemplate.save(recruiter);
    return id;
    }

    public List<Recruiter> getRecruiters() throws RecruitmentException{
        return this.hibernateTemplate.loadAll(Recruiter.class);
    }
}