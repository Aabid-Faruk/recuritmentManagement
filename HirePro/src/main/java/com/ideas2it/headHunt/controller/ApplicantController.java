package com.ideas2it.headHunt.controller;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.customLogger.CustomLogger;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.RecruiterDTO;
import com.ideas2it.headHunt.service.ApplicantService;
import com.ideas2it.headHunt.service.serviceImpl.ApplicantServiceImpl;
import com.ideas2it.headHunt.util.Validator;

/**
 * Controller class for Applicant 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */

public class ApplicantController {
    private ApplicantService applicantService = new ApplicantServiceImpl();
    private CustomLogger customLogger = new CustomLogger(ApplicantController.class);
    
    /**
     * Method to create an Applicant Entry.
     *
     * @param applicant of type Applicant.
     * @return applicant.
     */
    public ApplicantDTO createApplicant(ApplicantDTO data) {
    	ApplicantDTO applicantDto = null;
        try {
            applicantDto = applicantService.createApplicant(data);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return applicantDto;
    }

    /**
     * Method to View all Applicant Entries.
     *
     * @return ArrayList.
     */
    public List<ApplicantDTO> viewApplicants() {
        List<ApplicantDTO> applicants = new ArrayList<>();

        try {
            applicants = applicantService.viewApplicants();
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return applicants;
    }

    /**
     * View Applicant using Applicant ID.
     *
     * @param id (ID of Applicant)
     * @return applicant.
     */
    public ApplicantDTO getById(int id) {
    	ApplicantDTO applicantDTO = null;
        
        try {
        	applicantDTO = applicantService.viewApplicant(id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return applicantDTO;
    }

    /**
     * View Recruiters assigned to an Applicant using Applicant ID.
     *
     * @param id (ID of Applicant)
     * @return applicant.
     */
    public List<RecruiterDTO> getAssignedRecruiters(int id) {
    	List<RecruiterDTO> list = null;
 
        try {
            list = applicantService.getAssignedRecruiters(id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return list;  
    }

    /**
     * View Applicant by Email.
     *
     * @param email (Email ID of Applicant)
     * @return applicant.
     */
    public ApplicantDTO viewByEmail(String email) {
    	ApplicantDTO applicantDTO = null; 
        
        try {
        	applicantDTO = applicantService.viewByEmail(email);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        }  return applicantDTO;
    }

    /**
     * View Applicant by Contact Number.
     *
     * @param number (Contact Number of Applicant)
     * @return applicant.
     */
    public ApplicantDTO viewByNumber(String number) {
    	ApplicantDTO applicantDTO = null; 

        try {
        	applicantDTO = applicantService.viewByNumber(number);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        }  return applicantDTO;
    }

    /**
     * Method to Validate a Applicant Entry.
     *
     * @param UpdateId of type String.
     * @return boolean.
     */
    public boolean isValidId(int id) {
        boolean status = false;

        try {
            status = applicantService.isValidId(id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return status;
    }


    /**
     * Method to Update an Applicant Entry.
     *
     * @return List<ApplicantDTO>.
     */
    public boolean isUpdated(ApplicantDTO applicantDTO, int id) {
        boolean status = false;

        try {
            status= applicantService.isUpdated(applicantDTO, id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return status;
    }

    /**
     * Method to Delete an Applicant Entry.
     *
     * @param deleteApplicantId of type String.
     * @return boolean.
     */
    public boolean isDeleted(int id) {
        boolean status = false;

        try {
            status = applicantService.isDeleted(id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return status;
    }

    /**
     * Assign Recruiters to an Applicant.
     *
     * @param id (ID of Applicant)
     * @param recruiter_id (ID of recruiter to be assigned to an applicant)
     * @return boolean.
     */
  /*  public boolean assignRecruiter(int id, int recruiter_id) {
        boolean status = false;

        try {
            status = applicantService.assignRecruiter(id, recruiter_id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } catch(SQLException ex) {
            customLogger.error("Error while closing the database connection");
        } return status;
    }

    /**
     * Unassign Recruiters from an Applicant.
     *
     * @param id (ID of Applicant)
     * @param recruiter_id (ID of recruiter to be unassigned from an applicant)
     * @return boolean.
     */
  /*  public boolean unassignRecruiter(int id, int recruiter_id) {
        boolean status = false;

        try {
            status = applicantService.unassignRecruiter(id, recruiter_id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } catch(SQLException ex) {
            customLogger.error("Error while closing the database connection");
        } return status;
    }

    /**
     * Validate String type user details
     *
     * @return boolean.  
     */
    public boolean isValid(String data, String field) {
        String newValue = String.valueOf(data);
        String expression = " ";

        switch(field) {
            case "validateName":
                expression = "^[A-Z]{1}[a-zA-Z[ ]]{3,30}$";
                return Validator.isValid(newValue, expression);

            case "validateEmail":
                expression = "^([a-zA-Z]{1}[a-zA-Z0-9?(._)]{3,30})([@]{1})"
                            +"([a-zA-Z]{5,30})(((([.]{1})"
                            +"([c]{1}[o]{1}[m]{1})))|(([.]{1}[c]{1}[o]{1})"
                            +"([.]{1}[i]{1}[n]{1})))$";
                return Validator.isValid(newValue, expression);

            case "validateNumber":
                expression = "^([+]{1}[9]{1}[1]{1}[-]{1}[6-9]{1}[0-9]{9,9})"
                            +"|([0]{1}[6-9]{1}[0-9]{9})|([6-9]{1}[0-9]{9})$";
                return Validator.isValid(newValue, expression);                
        }
        return false;
    }

    /**
     * Method to validate Date of Birth
     *
     * @return boolean.  
     */
    public boolean isValidDateOfBirth(String date) {
        return Validator.isValidDate(date);
    } 

    /**
     * Method to validate Experience
     *
     * @return boolean.  
     */
    public boolean isValidExperience(int data) {
        return Validator.isValidExperience(data);
    }

    /**
     * Validate Gender
     *
     * @return boolean.  
     */
    public boolean isValidGender(String data) {
        return Validator.isValidGender(data);
    }

    /**
     * Validate Degree 
     *
     * @return boolean.  
     */
    public boolean isValidDegree(String data) {
        return Validator.isValidDegree(data);
    }
}