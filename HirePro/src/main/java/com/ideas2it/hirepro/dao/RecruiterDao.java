package com.ideas2it.hirepro.dao;

import java.util.List;

import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.model.Applicant;
import com.ideas2it.hirepro.model.Recruiter;
/*
 * Recruiter Dao interface for headHunt Application 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public interface RecruiterDao {

    /**
     * Create Recruiter.
     *
     * @param recruiter of type Recruiter.
     * @return recruiter.
     */
    public Integer createRecruiter(Recruiter recruiter) throws RecruitmentException;

    public List<Recruiter> getRecruiters() throws RecruitmentException;
}