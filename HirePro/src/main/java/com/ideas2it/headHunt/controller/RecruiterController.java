package com.ideas2it.headHunt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.customLogger.CustomLogger;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.RecruiterDTO;
import com.ideas2it.headHunt.service.RecruiterService;
import com.ideas2it.headHunt.service.serviceImpl.RecruiterServiceImpl;
import com.ideas2it.headHunt.util.Validator;
/**
 * Controller class for headHunt Application
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */

public class RecruiterController {
    private RecruiterService recruiterService = new RecruiterServiceImpl();
    private CustomLogger customLogger = new CustomLogger(RecruiterController.class);

   /**
    * Method to create a Recruiter Entry.
    *
    * @param recruiter of type Recruiter.
    * @return recruiter.
    */    
    public RecruiterDTO createRecruiter(RecruiterDTO data) {
    	RecruiterDTO recruiterDTO = null;
        try {
            recruiterDTO = recruiterService.createRecruiter(data);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return recruiterDTO;        
    }

    /**
     * Method to View all Recruiter Entries.
     *
     * @return ArrayList.
     */
    public List<RecruiterDTO> viewRecruiters() {
        List<RecruiterDTO> recruiters = new ArrayList<>();
        
        try {
            recruiters = recruiterService.viewRecruiters();
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return recruiters;
    }

    /**
     * View Recruiter by ID.
     *
     * @param id (ID of Recruiter)
     * @return recruiter.
     */
    public RecruiterDTO getById(int id) {
    	RecruiterDTO recruiterDTO = null;      

        try {
            recruiterDTO = recruiterService.getById(id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return recruiterDTO;
    }

    public List<ApplicantDTO> getAssignedApplicants(int id) {
    	List<ApplicantDTO> applicants = null;

        try {
            applicants = recruiterService.getAssignedApplicants(id);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return applicants;
    }

    /**
     * View Recruiter by Email
     *
     * @param email (Email_Id of Recruiter)
     * @return recruiter.
     */
    public RecruiterDTO viewByEmail(String email) {
    	RecruiterDTO recruiterDTO = null;

        try {
            recruiterDTO = recruiterService.viewByEmail(email);
        } catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return recruiterDTO;
    }

    /**
     * Method to View a Recruiter Entry.
     *
     * @param number (Contact Number of Recruiter)
     * @return recruiter.
     */
    public RecruiterDTO viewByNumber(String number) {
    	RecruiterDTO recruiterDTO = null;

        try {
            recruiterDTO = recruiterService.viewByNumber(number);
        }catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return recruiterDTO;
    }

    /**
     * Method to Validate a Recruiter Entry.
     *
     * @param id of type String.
     * @return boolean.
     */
    public boolean isValidId(int id) {
        boolean status = false;   

        try {
            status = recruiterService.isValidId(id);
        }catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return status;
    }

    /**
     * Method to Update a Recruiter Entry.
     *
     * @param updateId of type String.
     * @param updateField of type String.
     * @param newValue of type String.
     * @return boolean.
     */
    public boolean isUpdated(RecruiterDTO recruiterDTO, int id) {
        boolean status = false;   

        try {
        	//System.out.println(recruiterDTO.getApplicants());
            status = recruiterService.isUpdated(recruiterDTO, id);
        }catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return status;
    }

    /**
     * Method to delete a Recruiter Entry.
     *
     * @param deleteId of type String.
     * @return boolean.
     */
    public boolean isDeleted(int id) {
        boolean status = false;   

        try {
            status = recruiterService.isDeleted(id);
        }catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return status;
         
    }

    public boolean assignApplicant(int id, int applicant_id) {
        boolean status = false;   

        try {
            status = recruiterService.assignApplicant(id, applicant_id);
        }catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
        } return status;
    }

    public boolean unassignApplicant(int id, int applicant_id) {
        boolean status = false;   

        try {
            status = recruiterService.unassignApplicant(id, applicant_id);
        }catch(RecruitmentException ex) {
            customLogger.error(ex.getMessage());
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
}