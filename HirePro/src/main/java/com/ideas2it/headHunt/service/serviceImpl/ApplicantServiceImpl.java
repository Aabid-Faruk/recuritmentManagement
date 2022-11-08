package com.ideas2it.headHunt.service.serviceImpl;

import java.util.List;

import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.dao.ApplicantDao;
import com.ideas2it.headHunt.dao.daoImpl.ApplicantDaoImpl;
import com.ideas2it.headHunt.dto.ApplicantDto;
import com.ideas2it.headHunt.dto.RecruiterDto;
import com.ideas2it.headHunt.model.Applicant;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.RecruiterDTO;
import com.ideas2it.headHunt.service.ApplicantService;

/*
 * Service class for headHunt Application 
 * 
 *
 * @author  Aabid Farooq
 * @version JDK 18.0.2
 *  
 */
    
public class ApplicantServiceImpl implements ApplicantService {
    Applicant applicant = new Applicant();
    ApplicantDao applicantDao = new ApplicantDaoImpl();
     
    /**
     * Create an Applicant.
     *
     * @param applicant of type Applicant.
     * @return id (ID assigned to Applicant).
     */   
    public ApplicantDTO createApplicant(ApplicantDTO data) throws RecruitmentException {
    	Applicant applicant = (Applicant) ApplicantDto.getApplicantDao(data);
        ApplicantDTO applicantDto = ApplicantDto.getApplicantDTO(applicantDao.createApplicant(applicant));
        return applicantDto;
    }

    /**
     * View all Applicants.
     *
     * @return List<Applicant> list of applicants.
     */
    public List<ApplicantDTO> viewApplicants() throws RecruitmentException {
        List<ApplicantDTO> applicantList = ApplicantDto.getApplicantList(applicantDao.viewApplicants());
    	return applicantList;
    }

    /**
     * View an Applicant.
     *
     * @param id (ID of Applicant)
     * @return applicant.
     */
    public ApplicantDTO viewApplicant(int id) throws RecruitmentException {
        ApplicantDTO applicantDTO = ApplicantDto.getApplicantDTO(applicantDao.viewApplicant(id)); 
    	return applicantDTO;
    }

    /**
     * View Assigned Recruiters to an Applicant.
     *
     * @param id (ID of Applicant)
     * @return List<Recruiter> (list of assigned recruiters).
     */
    public List<RecruiterDTO> getAssignedRecruiters(int id) throws RecruitmentException {
        List<RecruiterDTO> recruiters = RecruiterDto.getRecruiterList(applicantDao.getAssignedRecruiters(id));
    	return recruiters;
    }

    /**
     * View Applicant using Email.
     *
     * @param email (Email ID of Applicant)
     * @return applicant.
     */
    public ApplicantDTO viewByEmail(String email) throws RecruitmentException {
        ApplicantDTO applicantDTO = ApplicantDto.getApplicantDTO(applicantDao.viewByEmail(email));
        return applicantDTO;
    }

    /**
     * View an Applicant.
     *
     * @param number (Contact Number of Applicant)
     * @return applicant.
     */
    public ApplicantDTO viewByNumber(String number) throws RecruitmentException {
    	ApplicantDTO applicantDTO = ApplicantDto.getApplicantDTO(applicantDao.viewByNumber(number));
    	return applicantDTO;
    }

    /**
     * Search an Applicant.
     *
     * @param updateId of type String 
     * @return boolean.
     */
    public boolean isValidId(int id) throws RecruitmentException {
        return applicantDao.isValidId(id);
    }

    /**
     * Update an Applicant.
     *
     * @return boolean.
     */
    public boolean isUpdated(ApplicantDTO applicantDto, int id) throws RecruitmentException {
        Applicant applicant = ApplicantDto.getApplicantDao(applicantDto);
    	return applicantDao.isUpdated(applicant, id);
    }

    /**
     * Delete an Applicant.
     *
     * @param deleteApplicantId of type String.
     * @return boolean.
     */
    public boolean isDeleted(int id) throws RecruitmentException {
        return applicantDao.isDeleted(id);
    }

    /**
     * Assign Recruiters to an Applicant.
     *
     * @param id (ID of Applicant)
     * @param recruiter_id (ID of recruiter to be assigned to an applicant)
     * @return boolean.
     */
    /*public boolean assignRecruiter(int id, int recruiter_id) throws RecruitmentException, SQLException {
        return applicantDao.assignRecruiter(id, recruiter_id);
    }

    /**
     * Unassign Recruiters from an Applicant.
     *
     * @param id (ID of Applicant)
     * @param recruiter_id (ID of recruiter to be unassigned from an applicant)
     * @return boolean.
     */
    /*public boolean unassignRecruiter(int id, int recruiter_id) throws RecruitmentException, SQLException {
        return applicantDao.unassignRecruiter(id, recruiter_id);
    }*/
}