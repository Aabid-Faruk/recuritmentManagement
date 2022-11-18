package com.ideas2it.hirepro.model;
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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ideas2it.hirepro.constants.Gender;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;

@Entity
@SQLDelete(sql = "Update recruiter SET is_deleted = '1' where recruiter_id=?", check = ResultCheckStyle.COUNT)
public class Recruiter { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recruiter_id")
    private int recruiterId;   
	
    private String name;  
    
    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String contactNumber;
    
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    
    @Enumerated(EnumType.STRING)
    private Gender gender; 
    
    private int experience;

    @ColumnDefault("0")
    @Column(name = "is_deleted", columnDefinition = "boolean")
    private int isDeleted;
    @ManyToMany(targetEntity = Applicant.class, cascade = CascadeType.ALL)
    @JoinTable(name = "applicant_recruiter",
                 joinColumns = { @JoinColumn(name = "recruiterId") },
                 inverseJoinColumns = { @JoinColumn(name = "applicantId") })
    private List<Applicant> applicants;

    /**
     * non-parameterized constructor for Applicant.
     */  
    public Recruiter() {
	
    } 
    
    /**
     * This is the parameterized constructor for Applicant.
     */
    public Recruiter(String name,
    		         String email,
    		         String contactNumber,
    		         Date dateOfBirth,
                     Gender gender,
    		         int experience)  {

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
    public Recruiter (int recruiterId,
                      String name,
    				  String email, 
    				  String contactNumber,
                      Date dateOfBirth,
                      Gender gender,
                      int experience)  {

        this.recruiterId = recruiterId;
    	this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.gender = gender;
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

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
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