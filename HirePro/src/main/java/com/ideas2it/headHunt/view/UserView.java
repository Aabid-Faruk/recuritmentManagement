package com.ideas2it.headHunt.view;

import java.lang.StringBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.ideas2it.headHunt.controller.ApplicantController;
import com.ideas2it.headHunt.controller.RecruiterController;
import com.ideas2it.headHunt.customLogger.CustomLogger;
import com.ideas2it.headHunt.constants.Constants;
import com.ideas2it.headHunt.constants.Degree;
import com.ideas2it.headHunt.constants.Gender;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.RecruiterDTO;
import com.ideas2it.headHunt.util.Validator;

/**
 * 
 * This class links to the main program. Here a view for the application
 * is provided. All user inputs are captured here and all information 
 * is displayed here.
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 * @since   2022-08-01
 *
 */
public class UserView { 
    private static int choice = 0;
    private static ApplicantController applicantController = new ApplicantController();
    private static CustomLogger customLogger = new CustomLogger(UserView.class);
    private static StringBuilder sb = new StringBuilder();
    private static RecruiterController recruiterController = new RecruiterController();

    /**
     *
     * Here options are provided to the user for selecting the either 
     * Reecruiter crud operations or Applicant crud operations or 
     * exit the program.
     * 
     */
    public void menu() {

        do {	    
            System.out.println(Constants.MAIN_MENU);
            choice = getInt();

            switch(choice) {
                case Constants.RECRUITER:
                    crudRecruiter();
                    break;    
                case Constants.APPLICANT:        		
                    crudApplicant();                              
                    break;
                case Constants.EXIT_APPLICATION:
                    System.out.print("Thank You!\n");
                    break;
                default: 
                System.err.println(sb.append(choice)
                           .append(" is not a valid input. Please retry"));
                sb.setLength(0);
                break;   
            }	    
        } while (choice != Constants.EXIT_APPLICATION);
    }

    /**
     *
     * This method is used to select create, read, update or 
     * delete operations for Recruiter. It takes a user input and 
     * based on that selects the desired operation.
     *
     */
    private void crudRecruiter() {        
        
        do {  
            System.out.println(Constants.RECRUITER_MENU);       
            choice = getInt();
            
            switch(choice){
                case Constants.REGISTER:
                    register("Recruiter");
                    break; 
                case Constants.VIEW:
                    viewRecruiter();
                    break; 
                case Constants.UPDATE:
                    updateRecruiter("Recruiter");
                    break;    
                case Constants.DELETE: 
                    deleteRecruiter();
                    break;                       
                case Constants.PREVIOUS_MENU: 
                    break;         
                default: 
                    System.err.println(sb.append(choice)
                               .append(" is not a valid input. Please retry"));
                    sb.setLength(0);
                    break;       
            }
        } while (choice != Constants.PREVIOUS_MENU);
    }

    /**
     *
     * This method is used to select create, read, update or 
     * delete operations for Applicant. It takes a user input and  
     * based on that selects the desired operation.
     *
     */
    private void crudApplicant() {
   
        do {     
            System.out.println(Constants.APPLICANT_MENU);       
            choice = getInt();

            switch(choice) {
                case Constants.REGISTER:
                    register("Applicant");
                    break;                          
                case Constants.VIEW: 
                    viewApplicant();
                    break;    
                case Constants.UPDATE: 
                    updateApplicant("Applicant");
                    break;         
                case Constants.DELETE: 
                    deleteApplicant();
                    break;                    
                case Constants.PREVIOUS_MENU: 
                    break;
                default: 
                    System.err.println(sb.append(choice)
                               .append(" is not a valid input."));
                    sb.setLength(0);
                    break;
            }
        } while (choice != Constants.PREVIOUS_MENU);
    }

    /**
     *
     * This method is used to perform User registration either as a
     * Recruiter or as an Applicant. 
     * @param user (String argrument)
     * If user = Recruiter, registration for Recruiter is initiated.
     * If user = Applicant, registration for Applicant is initiated.
     *
     */
    private void register(String user) {
        String name = getValidName(user);
        String email = getValidEmail(user);
        String contactNumber = getValidContactNumber(user);
        Date dateOfBirth = getValidDateOfBirth(user);
        int experience = getValidExperience(user);
        Gender gender = getValidGender(user);   

        if (user.equalsIgnoreCase("Applicant")) {
            Degree degree = getValidDegree();
            ApplicantDTO data = new ApplicantDTO(name,
                    							 email, 
                    							 contactNumber,
                    							 dateOfBirth,
                    							 experience, 
                    							 degree,
                    							 gender);
            createApplicant(data);
        }

        if (user.equalsIgnoreCase("Recruiter")){ 
        	RecruiterDTO data = new RecruiterDTO(name, 
                    							 email,
                    							 contactNumber, 
                    							 dateOfBirth, 
                    							 experience, 
                    							 gender);
        	createRecruiter(data);        	
        }   
    }

    /**
     *
     * This method provides recruiter related viewing options to a user.
     * Based on the input a user can choose to view all recruiters or a 
     * specific recruiter using either his ID, Name or Mobile Number.
     *
     */
    private void viewRecruiter() {

        do {
            System.out.println(Constants.VIEW_RECRUITER_MENU);
            choice = getInt();
 
            switch(choice) {
                case Constants.VIEW_ALL: 
                    viewAll("Recruiters");
                    break;
                case Constants.VIEW_BY_ID:
                    viewById("Recruiter");
                    break;
                case Constants.VIEW_BY_EMAIL:
                    viewByEmail("Recruiter");
                    break;
                case Constants.VIEW_BY_NUMBER:
                    viewByNumber("Recruiter");
                    break;
                case Constants.VIEW_ASSIGNED_APPLICANTS:
                    viewAssignedApplicants();
                    break;
                case Constants.PREVIOUS_USER_MENU: 
                    break;
                default:
                    System.err.println(sb.append(choice)
                               			 .append(" is not a valid input."));
                    sb.setLength(0);
                    break;
            }
        }while (choice != Constants.PREVIOUS_USER_MENU);
    }        

    /**
     *
     * This method provides applicant related viewing options to a user.
     * Based on the input a user can choose to view all applicants or a 
     * specific applicant using either his ID, Name or Mobile Number.
     *
     */
    private void viewApplicant() { 

        do {
            System.out.println(Constants.VIEW_APPLICANT_MENU);
            choice = getInt();

            switch(choice){
                case Constants.VIEW_ALL: 
                    viewAll("Applicants");
                    break;

                case Constants.VIEW_BY_ID:
                    viewById("Applicant");
                    break;

                case Constants.VIEW_BY_EMAIL:
                    viewByEmail("Applicant");
                    break;

                case Constants.VIEW_BY_NUMBER:
                    viewByNumber("Applicant");
                    break;

                case Constants.VIEW_ASSIGNED_RECRUITERS:
                    viewAssignedRecruiters();
                    break;

                case Constants.PREVIOUS_USER_MENU: 
                    break;

                default:
                    System.err.println(sb.append(choice)
                    					 .append(" is not a valid input."));
                    sb.setLength(0);
                    break;
            }
        }while (choice != Constants.PREVIOUS_USER_MENU);
    }

    /**
     *
     * This method is used to update a Recruiter.This method internally provides 
     * options to the recruiter for selecting a particular field that needs updation.
     * Additionally it provides options to aasign or unassign applicants to a recruiter.
     *
     * @param user. This argument is internally used to validate user input. 
     *
     */
    private void updateRecruiter(String user) {
        RecruiterDTO recruiterDTO = null;
        System.out.println("Please enter the Recruiter ID: ");
        int id = getInt();

        if (!recruiterController.isValidId(id)) { 
            customLogger.info((sb.append("Invalid Recruiter Id")
            					 .append(id)).toString()); 
            sb.setLength(0);          
            return;
        } else {                   
            System.out.println(Constants.RECRUITER_UPDATE_MENU);
            choice = getInt(); 
        }

        switch(choice) {
            case Constants.UPDATE_NAME: 
                updateRecruiterName(recruiterDTO, id);
                break;
            case Constants.UPDATE_EMAIL:
                updateRecruiterEmail(recruiterDTO, id);
                break;  
            case Constants.UPDATE_NUMBER:
                updateRecruiterNumber(recruiterDTO, id);
                break;
            case Constants.UPDATE_DOB:
                updateRecruiterDob(recruiterDTO, id);
                break;
            case Constants.UPDATE_EXPERIENCE:
                updateRecruiterExperience(recruiterDTO, id);
                break;
            case Constants.UPDATE_GENDER:
                updateRecruiterGender(recruiterDTO, id);
                break;
            case Constants.ASSIGN_APPLICANT:                    
                assignApplicant(id);
                break;            
            case Constants.UNASSIGN_APPLICANT:
                unassignApplicant(id);                    
                break; 
            default:
                System.out.println("Invalid Input. Please Retry");
                break;
        }
    }

    /**
     *
     * This method is used to update an Applicant.This method internally provides 
     * options to the applicnat for selecting a particular field that needs updation.
     * Additionally it provides options to aasign or unassign recruiters to an Applicant.
     *
     * @param user. This argument is internally used to validate user input. 
     *
     */
    private void updateApplicant(String user) {
        System.out.println("Please enter the Applicant ID: ");
        ApplicantDTO applicant = null;
        int id = getInt();

        if (!applicantController.isValidId(id)) {   
            customLogger.info((sb.append("Invalid Recruiter Id")
                        		 .append(id)).toString());
            sb.setLength(0);
            return;
        }
        System.out.println(Constants.APPLICANT_UPDATE_MENU);
        choice = getInt(); 

        switch(choice) {
            case Constants.UPDATE_NAME:     
                updateApplicantName(applicant, id);
                break;
            case Constants.UPDATE_EMAIL:
                updateApplicantEmail(applicant, id);
                break;
            case Constants.UPDATE_DOB:
                updateApplicantDob(applicant, id);
                break;
            case Constants.UPDATE_EXPERIENCE:
                updateApplicantExperience(applicant, id);
                break;
            case Constants.UPDATE_GENDER: 
                updateApplicantGender(applicant, id);
                break;
            case Constants.UPDATE_DEGREE:
                updateApplicantDegree(applicant, id);
                break;
/*            case Constants.ASSIGN_RECRUITER:                    
                //assignRecruiter(id);
                break;            
            case Constants.UNASSIGN_RECRUITER:                    
                //unassignRecruiter(id);
                break; 
*/
            default:
                System.err.println("Invalid Input. Please Retry");
                break;
        }
    }

    /**
     *
     * This method is used to delete a registered Recruiter. 
     *
     */
    private void deleteRecruiter() {
        System.out.println("Please enter the Recruiter ID: ");
        int id = getInt();
        boolean status = recruiterController.isDeleted(id);

        if(status == true) {
            customLogger.info((sb.append("Recruiter ID ").append(id)
            					 .append(" deleted Successfully.")).toString());
            sb.setLength(0);
        } else {
            customLogger.info((sb.append("Recruiter ID ").append(id)
                      			 .append(" is Invalid.")).toString());
            sb.setLength(0);
        } 
    }

    /**
     *
     * This method is used to delete a registered Applicant.
     *
     */
    private void deleteApplicant() {
        System.out.println("Enter enter the Applicant ID: ");
        int id = getInt();

        if (applicantController.isValidId(id)) {
            applicantController.isDeleted(id);
            customLogger.info((sb.append("Applicant ")
                      			 .append(id).append( " deleted.")).toString());
            sb.setLength(0);
        } else {
            customLogger.info((sb.append("Invalid Applicant ID")
            					 .append(id)).toString());
            sb.setLength(0);
        } 
    }

   /* 
    * CRUD operations end here. Beyond this point we have the methods that 
    * are called to implement the Crud operations.
    * They have been separated to increase program readability.
    *
    */
    
    private void createApplicant(ApplicantDTO data) {
    	ApplicantDTO applicantDTO = applicantController.createApplicant(data);
    
    	if (applicantDTO == null) {
    		customLogger.info("User Registration failed.");                
    	} else {
    		customLogger.info((sb.append("Applicant Registered Successfully with ID: ")
    							 .append(applicantDTO.getApplicantId())).toString());
    		sb.setLength(0);
    	}
    }
    
    private void createRecruiter(RecruiterDTO data) {
    	RecruiterDTO recruiterDTO = recruiterController.createRecruiter(data);
    
    	if (recruiterDTO == null) {
    		customLogger.info("User Registration failed.");                
    	} else {
    		customLogger.info((sb.append("Applicant Registered Successfully with ID: ")
    							 .append(recruiterDTO.getRecruiterId())).toString());
    		sb.setLength(0);
    	}
    }

    /**
     *
     * This method views all the registered users to the console.
     * @param user. A string argument decides weather to views all Recruiters 
     * or all applicants.
     * if user = Recruiters, all recruiters will be viewed.
     * if user = Applicants, all applicants will be viewed.
     *
     */
    private void viewAll(String user) {
        
        if (user.equalsIgnoreCase("Recruiters")) {
            List<RecruiterDTO> recruiters = new ArrayList<>();
            recruiters = recruiterController.viewRecruiters();

            if (recruiters.isEmpty()) {
                customLogger.info("No Recruiters registered so far.");
            } else {                                
                System.out.println(recruiters);
            }
        }
        
        if (user.equalsIgnoreCase("Applicants")) {
            List<ApplicantDTO> applicants = new ArrayList<>();
            applicants = applicantController.viewApplicants();

            if (applicants.isEmpty()) {
                customLogger.info("No Applicants registered so far.");
            } else {                                
                System.out.println(applicants);
            }
        }
    }

    /**
     *
     * This method is used to view a particular user based on his ID.
     * @param user. A string argument decides weather to view a Recruiter 
     * or an applicant. 
     * if user = Recruiter, recruiter will be viewed.
     * if user = Applicant, all applicants will be viewed.
     *
     */
    private void viewById(String user) {

        if (user.equalsIgnoreCase("Recruiter")) {
            System.out.println("Please enter the Recruiter ID: ");
            int id = getInt(); 
            RecruiterDTO recruiterDTO = recruiterController.getById(id);
            
            if (recruiterDTO == null) {
                customLogger.info((sb.append("Recruiter with ID: ").append(id)
   					 				 .append(" does not exist")).toString());
                sb.setLength(0);                   
            } else {
                System.out.println(recruiterDTO); 
            }
        }
        
        if (user.equalsIgnoreCase("Applicant")) {
            System.out.println("Enter the Applicant ID: ");
            int id = getInt();
            ApplicantDTO applicantDTO = applicantController.getById(id);
            if (applicantDTO == null) {
                customLogger.info((sb.append("Applicant ").append(id)
                					 .append(" does not exist")).toString());
                sb.setLength(0);
            } else {
                System.out.println(applicantDTO);
            }
        }
    }

    /**
     *
     * This method is used to view a particular user based on his Email ID.
     * @param user. A string argument decides weather to view a Recruiter 
     * or an applicant. 
     * if user = Recruiter, recruiter will be viewed.
     * if user = Applicant, all applicants will be viewed.
     *
     */
    private void viewByEmail(String user) {

        if (user.equalsIgnoreCase("Recruiter")) {
            System.out.println("Please enter the Recruiter Email: ");
            String email = getString();
            RecruiterDTO recruiterDTO = recruiterController.viewByEmail(email);
            
            if (recruiterDTO == null) {
                customLogger.info((sb.append("Recruiter with Email: ")
                        			 .append(email).append(" does not exist")).toString());
                sb.setLength(0);
            } else {
                System.out.println(recruiterDTO);
            }
        }
        
        if (user.equalsIgnoreCase("Applicant")) {
            System.out.println("Enter the Applicant Email: ");
            String email = getString();
            ApplicantDTO applicantDTO = applicantController.viewByEmail(email);

            if (applicantDTO == null) {
                customLogger.info((sb.append("Applicant with Email: ")
                        			 .append(email).append(" does not exist")).toString());
                sb.setLength(0);
            } else {
                System.out.println(applicantDTO);
            }
        }
    }

    /**
     *
     * This method is used to view a particular user based on his Mobile Number.
     * @param user. A string argument decides weather to view a Recruiter 
     * or an applicant. 
     * if user = Recruiter, recruiter will be viewed.
     * if user = Applicant, all applicants will be viewed.
     *
     */
    private void viewByNumber(String user) {

        if (user.equalsIgnoreCase("Recruiter")) {
            System.out.println("Enter Recruiter Contact Number: ");
            String number = getString();
            RecruiterDTO recruiterDTO = recruiterController.viewByNumber(number);

            if (recruiterDTO == null) {
                customLogger.info((sb.append("Recruiter with Contact Number: ")
                					 .append(number).append(" does not exist")).toString());
                sb.setLength(0);
            } else {
                System.out.println(recruiterDTO);
            }            
        }
        
        if (user.equalsIgnoreCase("Applicant")) {
            System.out.println("Enter Applicant Contact Number: ");
            String number = getString();
            ApplicantDTO applicantDTO = applicantController.viewByNumber(number);

            if (applicantDTO == null) {
                customLogger.info((sb.append("Applicant with Contact Number: ")
                					 .append(number).append(" does not exist")).toString());
                sb.setLength(0);
            } else {
                System.out.println(applicantDTO);
            }
        }
    }

    /**
     *
     * This method is used to view all recruiters assigned to an Applicant.
     * It uses applicant ID to fetch the Applicant and all recruiters  
     * that will interview this applicant.
     *
     */
    private void viewAssignedRecruiters() {
        List<RecruiterDTO> recruiters = null;
        System.out.println("Please enter the Applicant ID: ");
        int id = getInt();
        recruiters = applicantController.getAssignedRecruiters(id);

        if (!applicantController.isValidId(id)) {//constants on left side
            customLogger.info((sb.append("Invalid Applicant ID: ")
                      .append(id)).toString());
            sb.setLength(0);
        } else if (recruiters.isEmpty()) {                
            System.err.println("No  Recruiters assigned to this Applicant");
        } else {
            customLogger.info((sb.append("Printing Details of Assigned Recruiters to Applicant: ")
                      .append(id)).toString());
            sb.setLength(0);
            System.out.println(recruiters);
        }
    }

    /**
     *
     * This method is used to view all applicants assigned to a Recruiter.
     * It uses recruiter ID to fetch the Recuiter and all applicants that  
     * will be interviewed by this Recruiter.
     *
     */
    private void viewAssignedApplicants() {  
        List<ApplicantDTO> applicants = new ArrayList<ApplicantDTO>();      
        System.out.println("Enter the Recruiter ID: ");
        int id = getInt();
        applicants = recruiterController.getAssignedApplicants(id);
        
        if (!recruiterController.isValidId(id)) {//constants on left side
            customLogger.info((sb.append("Invalid Recruiter ID: ")
            					 .append(id)).toString());
            sb.setLength(0);
        } else if (applicants.isEmpty()) {                
            System.err.println("No  Applicants assigned to this Recruiter");
        } else {
            customLogger.info((sb.append("Printing Details of Assigned Applicants to this Recruiter: ")
                      .append(id)).toString());
            sb.setLength(0);
            System.out.println(applicants);
        }
    }

    /**
     *
     * This method is called while updating the name of a
     * registered Recruiter.  
     * @param recruiter. A Recruiter type argument that is used to store the
     * particular recruiter details whose name is to be updated. This object reference 
     * is then passed on to the controller with the updated name for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of recruiter whose name
     * is to be updated. This id is used to fetch the record of the recruiter 
     * from the database. 
     *
     */
    private void updateRecruiterName(RecruiterDTO recruiterDTO, int id) {
        String name = getValidName("Recruiter");
        recruiterDTO = recruiterController.getById(id);
        recruiterDTO.setName(name);

        if (recruiterController.isUpdated(recruiterDTO, id)) {
            customLogger.info("Recruiter updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }    
    }

    /**
     *
     * This method is called while updating the email of a
     * registered Recruiter.  
     * @param recruiter. A Recruiter type argument that is used to store the
     * particular recruiter details whose email is to be updated. This object reference
     * is then passed on to the controller with the updated email for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of recruiter whose email
     * is to be updated. This id is used to fetch the record of the recruiter 
     * from the database. 
     *
     */
    private void updateRecruiterEmail(RecruiterDTO recruiterDTO, int id) {
        String email = getValidEmail("Recruiter");
        recruiterDTO = recruiterController.getById(id);
        recruiterDTO.setEmail(email);
   
        if (recruiterController.isUpdated(recruiterDTO, id)) {
            customLogger.info("Recruiter updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while updating the contact number of a
     * registered Recruiter.  
     * @param recruiter. A Recruiter type argument that is used to store the
     * particular recruiter details whose contact number is to be updated. This object reference
     * is then passed on to the controller with the updated contact number for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of recruiter whose contact number 
     * is to be updated. This id is used to fetch the record of the recruiter 
     * from the database. 
     *
     */
    private void updateRecruiterNumber(RecruiterDTO recruiterDTO, int id) {
        String contactNumber = getValidContactNumber("Recruiter");
        recruiterDTO = recruiterController.getById(id);
        recruiterDTO.setContactNumber(contactNumber);
 
        if (recruiterController.isUpdated(recruiterDTO, id)) {
            customLogger.info("Recruiter updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while updating the date of birth of a
     * registered Recruiter.  
     * @param recruiter. A Recruiter type argument that is used to store the
     * particular recruiter details whose date of birth is to be updated. 
     * This object reference is then passed on to the controller with the  
     * updated date of birth for updating the corresponding record in the datebase.
     * @param id. Integer type id used to store the id of recruiter whose date of birth
     * is to be updated. This id is used to fetch the record of the recruiter 
     * from the database. 
     *
     */
    private void updateRecruiterDob(RecruiterDTO recruiterDTO, int id) {
        Date dateOfBirth = getValidDateOfBirth("Recruiter");
        recruiterDTO = recruiterController.getById(id);
        recruiterDTO.setDateOfBirth(dateOfBirth); 
   
        if (recruiterController.isUpdated(recruiterDTO, id)) {
            customLogger.info("Recruiter updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while updating the experience of a
     * registered Recruiter.  
     * @param recruiter. A Recruiter type argument that is used to store the
     * particular recruiter details whose experience is to be updated. This object reference
     * is then passed on to the controller with the updated experience for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of recruiter whose experience 
     * is to be updated. This id is used to fetch the record of the recruiter 
     * from the database. 
     *
     */
    private void updateRecruiterExperience(RecruiterDTO recruiterDTO, int id) {
        int experience = getValidExperience("Recruiter");
        recruiterDTO = recruiterController.getById(id);
        recruiterDTO.setExperience(experience);

        if (recruiterController.isUpdated(recruiterDTO, id)) {
            customLogger.info("Recruiter updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while updating the gender of a
     * registered Recruiter.  
     * @param recruiter. A Recruiter type argument that is used to store the
     * particular recruiter details whose gender is to be updated. This object reference
     * is then passed on to the controller with the updated gender for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of recruiter whose gender 
     * is to be updated. This id is used to fetch the record of the recruiter 
     * from the database. 
     *
     */
    private void updateRecruiterGender(RecruiterDTO recruiterDTO, int id) {
        Gender gender = getValidGender("Recruiter");
        recruiterDTO = recruiterController.getById(id);
        recruiterDTO.setGender(gender);

        if (recruiterController.isUpdated(recruiterDTO, id)) {
            customLogger.info("Recruiter updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while assigning applicants to a Recruiter for 
     * the interview process.  
     * @param id. Integer type id used to store the id of recruiter to whom
     * the applicants are to be assigned. 
     *
     */
    private void assignApplicant(int id) {
        System.out.println("Enter Applicant Id that you want to assign to selected Recruiter");
        int applicant_id = getInt();

        if (!applicantController.isValidId(applicant_id)) {
            customLogger.info((sb.append("Invalid Applicant Id")
                      .append(applicant_id)).toString());
            sb.setLength(0);
        } else if (recruiterController.assignApplicant(id, applicant_id)) {
            customLogger.info("Applicant assigned Successfully");
        } else {                       
            customLogger.info("Applicant Assignment failed");
        }
    }

    /**
     *
     * This method is called while unassigning applicants to a Recruiter for 
     * the interview process.  
     * @param id. Integer type id used to store the id of recruiter to whom
     * the applicants are to be unassigned. 
     *
     */
    private void unassignApplicant(int id) {
        System.out.println("Enter Applicant Id that you want to unaasign from the selected Recruiter");
        int applicant_id = getInt();

        if (!applicantController.isValidId(applicant_id)) {
            customLogger.info((sb.append("Invalid Applicant Id")
                      .append(applicant_id)).toString());
            sb.setLength(0);
        } else if (recruiterController.unassignApplicant(id, applicant_id)) {//
            customLogger.info("Applicant unassigned Successfully");
        } else {                       
            customLogger.info("Applicant unassignment failed");
        }
    }

    /**
     *
     * This method is called while updating the name of a
     * registered Applicant.
     * @param applicant. An Applicant type argument that is used to store the
     * particular applicant details whose name is to be updated. This object reference
     * is then passed on to the controller with the updated name for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of applicant whose name 
     * is to be updated. This id is used to fetch the record of the applicant 
     * from the database. 
     *
     */
    private void updateApplicantName(ApplicantDTO applicantDTO, int id) {
        String name = getValidName("Applicant");
        applicantDTO = applicantController.getById(id);
        applicantDTO.setName(name);	

        if(applicantController.isUpdated(applicantDTO, id)) {
            customLogger.info("Applicant updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }    
    }

    /**
     *
     * This method is called while updating the email of a
     * registered Applicant.
     * @param applicant. An Applicant type argument that is used to store the
     * particular applicant details whose email is to be updated. This object reference
     * is then passed on to the controller with the updated email for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of applicant whose email 
     * is to be updated. This id is used to fetch the record of the applicant 
     * from the database. 
     *
     */
    private void updateApplicantEmail(ApplicantDTO applicantDTO, int id) {
        String email = getValidEmail("Applicant");
        applicantDTO = applicantController.getById(id);
        applicantDTO.setEmail(email);
   
        if (applicantController.isUpdated(applicantDTO, id)) {
            customLogger.info("Applicant updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while updating the date of birth of a
     * registered Applicant.
     * @param applicant. An Applicant type argument that is used to store the
     * particular applicant details whose date of birth is to be updated. This object reference
     * is then passed on to the controller with the updated date of birth for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of applicant whose date of birth 
     * is to be updated. This id is used to fetch the record of the applicant 
     * from the database. 
     *
     */
    private void updateApplicantDob(ApplicantDTO applicantDTO, int id) {
        Date dateOfBirth = getValidDateOfBirth("Applicant");
        applicantDTO = applicantController.getById(id);
        applicantDTO.setDateOfBirth(dateOfBirth); 
   
        if (applicantController.isUpdated(applicantDTO, id)) {
            customLogger.info("Applicant updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while updating the experience of a
     * registered Applicant.
     * @param applicant. An Applicant type argument that is used to store the
     * particular applicant details whose experience is to be updated. This object reference
     * is then passed on to the controller with the updated experience for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of applicant whose experience 
     * is to be updated. This id is used to fetch the record of the applicant 
     * from the database. 
     *
     */
    private void updateApplicantExperience(ApplicantDTO applicantDTO, int id) {
        int experience = getValidExperience("Applicant");
        applicantDTO = applicantController.getById(id);
        applicantDTO.setExperience(experience);

        if (applicantController.isUpdated(applicantDTO, id)) {
            customLogger.info("Applicant updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while updating the gender of a
     * registered Applicant.
     * @param applicant. An Applicant type argument that is used to store the
     * particular applicant details whose gender is to be updated. This object reference
     * is then passed on to the controller with the updated gender for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of applicant whose gender 
     * is to be updated. This id is used to fetch the record of the applicant 
     * from the database. 
     *
     */
    private void updateApplicantGender(ApplicantDTO applicantDTO, int id) {
        Gender gender = getValidGender("Applicant");
        applicantDTO = applicantController.getById(id);
        applicantDTO.setGender(gender);

        if (applicantController.isUpdated(applicantDTO, id)) {
            customLogger.info("Applicant updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while updating the degree of a
     * registered Applicant.
     * @param applicant. An Applicant type argument that is used to store the
     * particular applicant details whose degree is to be updated. This object reference
     * is then passed on to the controller with the updated degree for updating the 
     * corresponding record in the datebase.
     * @param id. Integer type id used to store the id of applicant whose degree 
     * is to be updated. This id is used to fetch the record of the applicant 
     * from the database. 
     *
     */
    private void updateApplicantDegree(ApplicantDTO applicantDTO, int id) {
        Degree degree = getValidDegree();
        applicantDTO = applicantController.getById(id);
        applicantDTO.setDegree(degree);

        if (applicantController.isUpdated(applicantDTO, id)) {
            customLogger.info("Applicant updated Successfully");
        } else {                        
            customLogger.info("Updation failed");
        }
    }

    /**
     *
     * This method is called while assigning recruiters to an applicant for 
     * the interview process.  
     * @param id. Integer type id used to store the id of applicant to whom
     * the recruiters are to be assigned. 
     *
     */
  /*  private void assignRecruiter(int id) {
        System.out.println("Enter Recruiter Id that you want to assign to selected Applicant");
        int recruiter_id = getInt();

        if (!recruiterController.isValidId(recruiter_id)) {
            customLogger.info((sb.append("Invalid Recruiter Id")
                      .append(recruiter_id)).toString());
            sb.setLength(0);
        } else if (applicantController.assignRecruiter(id, recruiter_id)) {
            customLogger.info("Recruiter assigned Successfully");
        } else {                       
            customLogger.info("Recruiter Assignment failed");
        }
    }

    /**
     *
     * This method is called while unassigning recruiters to an applicant for 
     * the interview process.  
     * @param id. Integer type id used to store the id of applicant to whom
     * the recruiters are to be unassigned. 
     *
     */
   /* private void unassignRecruiter(int id) {
        System.out.println("Enter Recruiter Id that you want to unaasign from the selected Applicant");
        int recruiter_id = getInt();

        if (!recruiterController.isValidId(recruiter_id)) {
            customLogger.info((sb.append("Invalid Recruiter Id")
                      .append(recruiter_id)).toString());
            sb.setLength(0);
        } else if (applicantController.unassignRecruiter(id, recruiter_id)) {
            customLogger.info("Recruiter unassigned Successfully");
        } else {                       
            customLogger.info((sb.append("Recruiter with the given ID: ")
            					.append(recruiter_id)
            					.append(" not assigned to the Applicant: ")
            					.append(id)).toString());
            sb.setLength(0);
        }
    }

    /**
     * Validate Name
     *
     * @param user (Recruiter/Applicant). This is internally passed on to 
     * to a function that validates the name.
     * @return String (validated name of user)
     */
    private String getValidName(String user) {
        System.out.println("Enter Name");
        String name = getString();
        String field = "validateName";

        if (user.equals("Recruiter") && (recruiterController.isValid(name, field))) {
            return name;
        } else if(user.equals("Applicant") && (applicantController.isValid(name, field))) {
            return name;
        } else{
            System.err.println("Not a Valid Input. Try again");
            return getValidName(user);
        }
    }

    /**
     * Validate Email
     *
     * @param user. (Recruiter/Applicant). This is internally passed on to 
     * to a function that validates the email.
     * @return String (validated email ID of user)
     */
    private String getValidEmail(String user) {
        System.out.println("Enter Email");
        String email = getString();
        String field = "validateEmail";

        if (user.equals("Recruiter") && (recruiterController.isValid(email, field))) {
            return email;
        } else if(user.equals("Applicant") && (applicantController.isValid(email, field))) {
            return email;
        } else{
            System.err.println("Not a Valid Input. Try again");
            return getValidEmail(user);
        }
    }

    /**
     * Validate Contact Number
     *
     * @param user (Recruiter/Applicant). This is internally passed on to 
     * to a function that validates the contact number.
     * @return String validated contact number of user
     */
    private String getValidContactNumber(String user) {
        System.out.println(sb.append("Enter Mobile Number(+91-xxxxxxxxxx/0xxxxxxxxxx)"));
        sb.setLength(0);
        String contactNumber = getString();
        String field = "validateNumber";

        if (user.equals("Recruiter") && (recruiterController.isValid(contactNumber, field))) {
            return contactNumber;
        } else if(user.equals("Applicant") && (applicantController.isValid(contactNumber, field))) {
            return contactNumber;
        } else{
            System.err.println("Not a Valid Input. Try again");
            return getValidContactNumber(user);
        }
    }

    /**
     * Validate Date of Birth
     *
     * @param user (Recruiter/Applicant). This is internally passed on to 
     * to a function that validates the Date of Birth.
     * @return String validated DOB of user
     */
    private Date getValidDateOfBirth(String user) {  
        System.out.println(sb.append("Enter Date of Birth(DD-MM-YYYY format)\n")
                   .append("Age must be between 17 and 28 years"));   
        sb.setLength(0);                  
        String string = getString();
        Date dateOfBirth = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        if (user.equals("Recruiter")) {
            try {
        		dateOfBirth = simpleDateFormat.parse(string); 
            } catch(ParseException e) {
                System.err.println("Invalid format. Please enter in DD-MM-YYYY format."); 
                return getValidDateOfBirth(user);            	
            } 
        } else if(user.equals("Applicant")) {
        	try {
        		dateOfBirth = simpleDateFormat.parse(string); 
                return dateOfBirth;
        	} catch(ParseException e) {
                System.err.println("Invalid format. Please enter in DD-MM-YYYY format."); 
                return getValidDateOfBirth(user);        		
        	}
        } int age = Validator.calculateAge(dateOfBirth);
		if (17 > age || age >= 28) {
			System.err.println("Please enter a valid age");
			return getValidDateOfBirth(user);
		}  return dateOfBirth;     	
    }

    /**
     * Validate Experience
     *
     * @param user (Recruiter/Applicant). This is internally passed on to 
     * to a function that validates the Experience.
     * @return float validated experience of user
     */
    private int getValidExperience(String user) {
        System.out.println("Enter Experience(0 <= Experience <= 34)");
        int experience = getInt();

        if (user.equals("Recruiter") && (recruiterController.isValidExperience(experience))) {
            return experience;
        } else if(user.equals("Applicant") && (applicantController.isValidExperience(experience))) {
            return experience;
        } else{
            System.err.println("Not a Valid Input. Try again");
            return getValidExperience(user);
        }
    }

    /**
     * Validate Gender
     *
     * @param user (Recruiter/Applicant). This is internally passed on to 
     * to a function that validates the gender.
     * @return Gender validated gender of user
     */
    private Gender getValidGender(String user) {
        System.out.println("Enter Gender (MALE/FEMALE/OTHERS)");
        String string = getString().toUpperCase();
        
           
        if (user.equals("Recruiter") && (recruiterController.isValidGender(string))) {
        	Gender gender = Gender.valueOf(string);
            return gender;
        } else if(user.equals("Applicant") && (applicantController.isValidGender(string))) {
        	Gender gender = Gender.valueOf(string);
            return gender;
        } else{
            System.err.println("Not a Valid Input. Try again");
            return getValidGender(user);
        }
    }

    /**
     * Validate Degree of the applicant.
     * @return String validated degree of Applicant
     *
     */
    private Degree getValidDegree() {
        System.out.println("Enter Degree (MCA/BCA/MSC/BSC/BTECH/MTECH)");
        String string = getString().toUpperCase();       

        if (applicantController.isValidDegree(string)) {
        	 Degree degree = Degree.valueOf(string);
            return degree;
        } else {
            System.err.println("Not a Valid Input. Try again");
            return getValidDegree();
        }
    }

    /**
     * This method is used to get integer type inputs from the console.
     *
     * @throws InputMismatchException if the input is not an integer.
     * @throws NoSuchElementException if the user tries to use a certain function
     * like Ctrl+z or Ctrl+c.
     * @return boolean. True if the input is valid, false otherwise.  
     */
    private int getInt() {

        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();            
        } catch (InputMismatchException ex) {
            System.err.println(sb.append(ex)
                       .append("\nPlease Enter the corresponding Integer"));
            sb.setLength(0);
            return getInt();
        } catch (NoSuchElementException ex) {
            System.err.println(sb.append(ex)
                       .append("\nPlease Enter the corresponding Integer"));
            sb.setLength(0);
            return getInt();
        }
        return choice;   
    }

    /**
     * This method is used to get String type inputs from the console.
     *
     * @throws NoSuchElementException if the user tries to use a certain function
     * like Ctrl+z or Ctrl+c.
     * @return boolean. True if the input is valid, false otherwise.  
     */
    private String getString() {
        String string;

        try {
            Scanner scanner = new Scanner(System.in);
            string = scanner.nextLine();   
        } catch (NoSuchElementException ex) {
            System.err.println(sb.append(ex)
                       .append("\nPlease enter a valid String"));            
            sb.setLength(0);
            return getString();
        }
        return string;  
    }  

    /**
     * This method is used to get String type date from the console.
     *
     * @throws ParseException if the user enters a date that is not
     * in DD-MM-YYYY format.
     * @return date of type Date type which is assigned to a Date type variable.  
     */
}