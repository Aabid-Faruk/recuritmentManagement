package com.ideas2it.hirepro.service;

import java.util.List;

import com.ideas2it.hirepro.customException.RecruitmentException;
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
    public void createRecruiter(RecruiterDTO recruiter) throws RecruitmentException;

    public RecruiterDTO viewRecruiter(int recruiterId) throws RecruitmentException;

    public List<RecruiterDTO> viewRecruiters() throws RecruitmentException;

    public void deleteRecruiter(int recruiterId) throws RecruitmentException;
    
    public void assignApplicants(int recruiterId, List<String> recruiterIds) throws RecruitmentException;

}