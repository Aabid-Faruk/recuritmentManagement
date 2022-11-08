package com.ideas2it.headHunt.service;

import java.util.List;

import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.RecruiterDTO;

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
    public RecruiterDTO createRecruiter(RecruiterDTO recruiterDTO) throws RecruitmentException;

    /**
     * View all Recruiters.
     *
     * @return ArrayList.
     */
    public List<RecruiterDTO> viewRecruiters() throws RecruitmentException;

    /**
     * View a Recruiter by ID.
     *
     * @param recruiter of type Recruiter.
     * @return recruiter.
     */
    public RecruiterDTO getById(int id) throws RecruitmentException;

    /**
     * View a Recruiter by Email.
     *
     * @param email (Email_Id of Recruiter)
     * @return recruiter.
     */
    public RecruiterDTO viewByEmail(String email) throws RecruitmentException;

    /**
     * View a Recruiter by Number.
     *
     * @param Number (Contact Number of Recruiter)
     * @return recruiter.
     */
    public RecruiterDTO viewByNumber(String number) throws RecruitmentException;

    /**
     * Update a Recruiter.
     *
     * @param updateId of type String
     * @param updateField of type String
     * @param newValue of type String 
     * @return boolean.
     */
    public boolean isUpdated(RecruiterDTO recruiterDTO, int id) throws RecruitmentException;
    
    /**
     * Delete an Recruiter.
     *
     * @param deleteId of type String 
     * @return boolean.
     */
    public boolean isDeleted(int id) throws RecruitmentException;
    
    /**
     * Search a Recruiter.
     *
     * @param updateId of type String 
     * @return boolean.
     */
    public boolean isValidId(int id) throws RecruitmentException;

    public boolean assignApplicant(int id, int applicant_id) throws RecruitmentException;

    public boolean unassignApplicant(int id, int applicant_id) throws RecruitmentException;

    public List<ApplicantDTO> getAssignedApplicants(int id) throws RecruitmentException;
}