package com.ideas2it.headHunt.model;
/**
 * Pojo class for Recruiter wishing to 
 * register as recruiter for recruitment
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */

import java.util.Date;
import java.util.List;

import com.ideas2it.headHunt.constants.Gender;

public class RecruiterDTO { 
	
    private int recruiterId;    
    private String name;  
    private String email;
    private String contactNumber;
    private Date dateOfBirth;
    private Gender gender;  
    private int experience;  
    private List<Applicant> applicants;

    /**
     * non-parameterized constructor for Applicant.
     */  
    public RecruiterDTO() {
	
    } 
    
    /**
     * This is the parameterized constructor for Applicant.
     */
    public RecruiterDTO(String name, 
    		         String email, 
    		         String contactNumber, 
    		         Date dateOfBirth, 
    		         int experience,
    		         Gender gender)  {

    	this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.experience = experience;
        }

    /**
     * parameterized constructor for Applicant.
     */
    public RecruiterDTO (String name, 
    				  String email, 
    				  String contactNumber,
                      Date dateOfBirth, 
                      int experience, 
                      Gender gender, 
                      int recruiterId)  {
    	this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.experience = experience;
        this.recruiterId = recruiterId;
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
     * This is the getter method for Applicant Gender
     * @return Gender of the Applicant.
     */
    public Gender getGender() {  
        return gender;  
    }  

    /**
     * This is the setter method for Applicant Gender
     */
    public void setGender(Gender gender) {  
    	this.gender = gender;  
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
     * This is the getter method for Applicant ID
     * @return ID of the Applicant.
     */
    public int getRecruiterId() {  
        return recruiterId;  
    }

    /**
     * This is the setter method for Applicant ID
     */
    public void setRecruiterId(int recruiterId) {  
        this.recruiterId = recruiterId;  
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    public String toString() {
        return "\nDetails of Recruiter with ID " +recruiterId+":"+
               "\nName             : "+name+
               "\nEmail ID         : "+email+
               "\nContact Number   : "+contactNumber+
               "\nDate Of Birth    : "+dateOfBirth+
               "\nGender           : "+gender+
               "\nExperience       : "+experience +
               "\nRecruiter ID     : "+recruiterId+"\n";
    }
}  