package com.ideas2it.headHunt.dao;

import java.util.List;
import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.model.Applicant;
import com.ideas2it.headHunt.model.Recruiter;
/*
 * Applicant Dao interface for headHunt Application 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public interface ApplicantDao {

    /**
     * Create Applicant.
     *
     * @param applicant of type Applicant.
     * @return int (id generated for Applicant)
     */ 
    public Applicant createApplicant(Applicant applicant) throws RecruitmentException;

    /**
     * View all Applicants.
     *
     * @return List<applicant> List of all applicants.
     */
    public List<Applicant> viewApplicants() throws RecruitmentException;

    /**
     * View Applicant by ID.
     *
     * @param id (ID of applicant)
     * @return applicant
     */
    public Applicant viewApplicant(int id) throws RecruitmentException;

    /**
     * View Applicant by Email.
     *
     * @param email (Email ID of Applicant)
     * @return applicant.
     */
    public Applicant viewByEmail(String email) throws RecruitmentException;

    /**
     * View Applicant by Contact Number.
     *
     * @param number (Contact Number of Applicant)
     * @return applicant.
     */
    public Applicant viewByNumber(String number) throws RecruitmentException;

 /**
     * View Assigned Recruiters to an Applicant.
     *
     * @param id (ID of Applicant)
     * @return List<Recruiter> (list of assigned recruiters).
     */
    public List<Recruiter> getAssignedRecruiters(int id) throws RecruitmentException;

    /**
     * Update Applicant.
     *
     * @param applicant (applicant to type Applicant)
     * @param id (ID of applicant)
     * @return boolean
     */
    public boolean isUpdated(Applicant applicant, int id) throws RecruitmentException;
 
    /**
     * Assign Recruiters to an Applicant.
     *
     * @param id (ID of Applicant)
     * @param recruiter_id (ID of recruiter to be assigned to an applicant)
     * @return boolean.
     */
/*    public boolean assignRecruiter(int id, int recruiter_id) throws RecruitmentException, SQLException;
   
    /**
     * Unassign Recruiters from an Applicant.
     *
     * @param id (ID of Applicant)
     * @param recruiter_id (ID of recruiter to be unassigned from an applicant)
     * @return boolean.
     */
/*    public boolean unassignRecruiter(int id, int recruiter_id) throws RecruitmentException, SQLException;
    
    /**
     * Delete Applicant.
     *
     * @param id (ID of Applicant)
     * @return boolean.
     */
    public boolean isDeleted(int id) throws RecruitmentException; 

    /**
     * Validate Applicant ID.
     *
     * @param id (ID of applicant) 
     * @return boolean.
     */
    public boolean isValidId(int id) throws RecruitmentException;
}