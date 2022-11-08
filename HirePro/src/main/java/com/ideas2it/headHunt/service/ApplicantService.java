
package com.ideas2it.headHunt.service;

import java.util.List;

import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.model.Applicant;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.RecruiterDTO;
/*
 * Service class for headHunt Application 
 * 
 *
 * @author  Aabid Farooq
 * @version JDK 18.0.2
 *  
 */
    
public interface ApplicantService {
    Applicant applicant = null;
     
    /**
     * Create an Applicant.
     *
     * @param applicant of type Applicant.
     * @return id (ID assigned to Applicant).
     */   
    public ApplicantDTO createApplicant(ApplicantDTO applicantDto) throws RecruitmentException;

    /**
     * View all Applicants.
     *
     * @return List<Applicant> list of applicants.
     */
    public List<ApplicantDTO> viewApplicants() throws RecruitmentException;

    /**
     * View an Applicant.
     *
     * @param id (ID of Applicant)
     * @return applicant.
     */
    public ApplicantDTO viewApplicant(int id) throws RecruitmentException;

    /**
     * View Assigned Recruiters to an Applicant.
     *
     * @param id (ID of Applicant)
     * @return List<Recruiter> (list of assigned recruiters).
     */
    public List<RecruiterDTO> getAssignedRecruiters(int id) throws RecruitmentException;

    /**
     * View Applicant using Email.
     *
     * @param email (Email ID of Applicant)
     * @return applicant.
     */
    public ApplicantDTO viewByEmail(String email) throws RecruitmentException;

    /**
     * View an Applicant.
     *
     * @param number (Contact Number of Applicant)
     * @return applicant.
     */
    public ApplicantDTO viewByNumber(String number) throws RecruitmentException;

    /**
     * Search an Applicant.
     *
     * @param updateId of type String 
     * @return boolean.
     */
    public boolean isValidId(int id) throws RecruitmentException;

    /**
     * Update an Applicant.
     *
     * @return boolean.
     */
    public boolean isUpdated(ApplicantDTO applicant, int id) throws RecruitmentException;

    /**
     * Delete an Applicant.
     *
     * @param deleteApplicantId of type String.
     * @return boolean.
     */
    public boolean isDeleted(int id) throws RecruitmentException;

    /**
     * Assign Recruiters to an Applicant.
     *
     * @param id (ID of Applicant)
     * @param recruiter_id (ID of recruiter to be assigned to an applicant)
     * @return boolean.
     */
    //public boolean assignRecruiter(int id, int recruiter_id) throws RecruitmentException, SQLException;

    /**
     * Unassign Recruiters from an Applicant.
     *
     * @param id (ID of Applicant)
     * @param recruiter_id (ID of recruiter to be unassigned from an applicant)
     * @return boolean.
     */
    //public boolean unassignRecruiter(int id, int recruiter_id) throws RecruitmentException, SQLException;
}