package com.ideas2it.hirepro.service;

import java.util.List;

import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.model.Recruiter;
import com.ideas2it.hirepro.model.RecruiterDTO;

/**
 * Service class for Recruiter 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public interface RecruiterService {
    
    /**
     * Create a Recruiter.
     *
     * @param recruiter of type Recruiter.
     * @return recruiter.
     */
    public Integer createRecruiter(RecruiterDTO recruiter) throws RecruitmentException;

    public List<RecruiterDTO> getRecruiters() throws RecruitmentException;

}