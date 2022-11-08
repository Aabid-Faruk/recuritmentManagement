package com.ideas2it.headHunt.dao;

import java.util.List;

import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.model.Applicant;
import com.ideas2it.headHunt.model.Recruiter;
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
    public Recruiter createRecruiter(Recruiter recruiter) throws RecruitmentException;

    /**
     * View all Recruiters.
     *
     * @return List<> list of all recruiters.
     */
    public List<Recruiter> viewRecruiters() throws RecruitmentException;

    /**
     * View Recruiter by ID.
     *
     * @param id (ID of Recruiter)
     * @return recruiter.
     */
    public Recruiter getById(int recruiterId) throws RecruitmentException;

    /**
     * View Recruiter by Email.
     *
     * @param email (Email_Id of Recruiter)
     * @return recruiter.
     */
    public Recruiter viewByEmail(String email) throws RecruitmentException;

    /**
     * View Recruiter by Number.
     *
     * @param  number (Contact Number of Recruiter)
     * @return recruiter.
     */
    public Recruiter viewByNumber(String number) throws RecruitmentException;

    /**
     * View Assigned Recruiters to an Applicant.
     *
     * @param id (ID of Applicant)
     * @return List<Recruiter> (list of assigned recruiters).
     */
    public List<Applicant> getAssignedApplicants(int id) throws RecruitmentException;

    /**
     * Update a Recruiter.
     * 
     * @return recruiter recruiter with updated details.
     */
    public boolean isUpdated(Recruiter recruiter, int id) throws RecruitmentException;
   
    /**
     * Assign Applicants to a Recruiter
     *
     * @param id (ID of recruiter)
     * @param applicant_id (ID of applicant to be assigned to a recruiter)
     * @return boolean.
     */
    public boolean assignApplicant(int id, int applicant_id) throws RecruitmentException;
   
    /**
     * Unassign Applicants from a Recruiter.
     *
     * @param id (ID of Recruiter)
     * @param applicant_id (ID of applicant to be unassigned from a recruiter)
     * @return boolean.
     */
    public boolean unassignApplicant(int id, int applicant_id) throws RecruitmentException;

    /**
     * Delete Recruiter.
     *
     * @param id (ID of Recruiter) 
     * @return boolean.
     */
    public boolean isDeleted(int id) throws RecruitmentException;

    /**
     * Search a Recruiter.
     *
     * @param id (ID of Recruiter) 
     * @return boolean.
     */
    public boolean isValidId(int id) throws RecruitmentException; 
}