package com.ideas2it.hirepro.model;
/**
 *
 * This is model class for the Applicant 
 * wishing to register for recruitment process
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 * @since   2022-08-01
 *
 */

import java.util.Date;
import java.util.List;

import com.ideas2it.hirepro.constants.Degree;
import com.ideas2it.hirepro.constants.Gender;


public class ApplicantDTO {
	
	private int applicantId;
    private String name; 
    private String email;
    private String contactNumber;
    private Date dateOfBirth;
    private Gender gender; 
    private int experience;  
    private Degree degree; 
    private List<Recruiter> recruiters;

    /**
     * This is non-parameterized constructor for Applicant.
     */
    public ApplicantDTO() {
	
    } 
    
    /**
     * This is the parameterized constructor for Applicant.
     */
    public ApplicantDTO(String name, 
    		         String email, 
    		         String contactNumber, 
    		         Date dateOfBirth, 
    		         int experience,
    		         Degree degree, 
    		         Gender gender)  {

    	this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.experience = experience;
        this.degree = degree;
    }

    /**
     * This is the parameterized constructor for Applicant.
     */
    public ApplicantDTO(String name, 
    				 String email, 
    				 String contactNumber, 
    				 Date dateOfBirth, 
    				 int experience,
    				 Degree degree, 
    				 Gender gender, 
    				 int applicantId)  {

    	this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.experience = experience;
        this.applicantId = applicantId;
        this.degree = degree;
    }
 
    /**
     * This is the getter method for Applicant Name
     * @return name of the applicant.
     */
    public String getName() {  
        return name;  
    }  

    /**
     * This is the setter method for Applicant Name
     */
    public void setName(String name) {  
    	this.name = name;  
    }

    /**
     * This is the getter method for Applicant Email
     * @return email of the applicant.
     */
    public String getEmail() {  
    	return email;  
    }

    /**
     * This is the setter method for Applicant email
     */  
    public void setEmail(String email) {  
    	this.email = email;  
    } 

    /**
     * This is the getter method for Applicant Mobile Number
     * @return contact number of the Applicant.
     */
    public String getContactNumber() {  
	return contactNumber;  
    }

    /**
     * This is the setter method for Applicant Mobile Number
     */  
    public void setContactNumber(String contactNumber) {  
	this.contactNumber = contactNumber;  
    } 

    /**
     * This is the getter method for Applicant Date of Birth.
     * @return date of birth of the applicant.
     */ 
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * This is the setter method for Applicant date of Birth.
     */
     public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * This is the getter method for Applicant Experience
     * @return experience of the Applicant.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * This is the setter method for Applicant Experience
     */
     public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * This is the setter method for Applicant Degree
     */
     public void setDegree(Degree degree) {
        this.degree = degree;
    }

    /**
     * This is the getter method for Applicant Degree
     * @return Degree of the Applicant.
     */
    public Degree getDegree() {  
        return degree;  
    }

    /**
     * This is the setter method for Applicant Gender
     */
     public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * This is the getter method for Applicant Gender
     * @return Gender of the Applicant.
     */
    public Gender getGender() {  
        return gender;  
    }

    /**
     * This is the setter method for Applicant Id
     */
     public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    /**
     * This is the getter method for Applicant ID
     * @return ID of the Applicant.
     */
    public int getApplicantId() {  
        return applicantId;  
    }

    public List<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(List<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }

    /**
     * This is the method to convert fields of an object to String.
     * @return to String of all variables.
     */
    public String toString() {
        return "\nDetails of Applicant with ID " +applicantId+": "+
               "\nName             : "+name+
               "\nEmail ID         : "+email+
               "\nContact Number   : "+contactNumber+
               "\nDate Of Birth    : "+dateOfBirth+
               "\nGender           : "+gender+
               "\nDegree           : "+degree+
               "\nExperience       : "+experience +
               "\nRecruiter ID     : "+applicantId+"\n";
    }
}  