package com.ideas2it.headHunt.service.serviceImpl;

import java.util.List;

import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.dao.RecruiterDao;
import com.ideas2it.headHunt.dao.daoImpl.RecruiterDaoImpl;
import com.ideas2it.headHunt.dto.ApplicantDto;
import com.ideas2it.headHunt.dto.RecruiterDto;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.Recruiter;
import com.ideas2it.headHunt.model.RecruiterDTO;
import com.ideas2it.headHunt.service.RecruiterService;

/**
 * Service class for Recruiter 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public class RecruiterServiceImpl implements RecruiterService {
    private RecruiterDao recruiterDao = new RecruiterDaoImpl();
    
    /**
     * Create a Recruiter.
     *
     * @param recruiter of type Recruiter.
     * @return recruiter.
     */
    public RecruiterDTO createRecruiter(RecruiterDTO data) throws RecruitmentException {
        Recruiter recruiter = RecruiterDto.getRecruiterDao(data);
        RecruiterDTO recruiterDTO = RecruiterDto.getRecruiterDTO(recruiterDao.createRecruiter(recruiter));
        return recruiterDTO;
    }

    /**
     * View all Recruiters.
     *
     * @return ArrayList.
     */
    public List<RecruiterDTO> viewRecruiters() throws RecruitmentException {
    	List<RecruiterDTO> recruiterList = RecruiterDto.getRecruiterList(recruiterDao.viewRecruiters());
    	return recruiterList;
    }

    /**
     * View a Recruiter by ID.
     *
     * @param recruiter of type Recruiter.
     * @return recruiter.
     */
    public RecruiterDTO getById(int id) throws RecruitmentException {
    	RecruiterDTO recruiterDTO = RecruiterDto.getRecruiterDTO(recruiterDao.getById(id));
    	return recruiterDTO;     
    }

    public List<ApplicantDTO> getAssignedApplicants(int id) throws RecruitmentException {
    	List<ApplicantDTO> applicantList = ApplicantDto.getApplicantList(recruiterDao.getAssignedApplicants(id));
        return applicantList;
    }

    /**
     * View a Recruiter by Email.
     *
     * @param email (Email_Id of Recruiter)
     * @return recruiter.
     */
    public RecruiterDTO viewByEmail(String email) throws RecruitmentException {
    	RecruiterDTO recruiterDTO = RecruiterDto.getRecruiterDTO(recruiterDao.viewByEmail(email));
        return recruiterDTO;     
    }

    /**
     * View a Recruiter by Number.
     *
     * @param Number (Contact Number of Recruiter)
     * @return recruiter.
     */
    public RecruiterDTO viewByNumber(String number) throws RecruitmentException {
    	RecruiterDTO recruiterDTO = RecruiterDto.getRecruiterDTO(recruiterDao.viewByNumber(number));
    	return recruiterDTO;     
    }

    /**
     * Update a Recruiter.
     *
     * @param updateId of type String
     * @param updateField of type String
     * @param newValue of type String 
     * @return boolean.
     */
    public boolean isUpdated(RecruiterDTO recruiterDTO, int id) throws RecruitmentException {
        Recruiter recruiter = RecruiterDto.getRecruiterDao(recruiterDTO);
    	return recruiterDao.isUpdated(recruiter, id);
    }

    /**
     * Search a Recruiter.
     *
     * @param updateId of type String 
     * @return boolean.
     */
    public boolean isValidId(int id) throws RecruitmentException {
        return recruiterDao.isValidId(id);
    }
     public boolean isDeleted(int id) throws RecruitmentException {
        return recruiterDao.isDeleted(id);
    }

    public boolean assignApplicant(int id, int applicant_id) throws RecruitmentException {
        return recruiterDao.assignApplicant(id, applicant_id);
    }

    public boolean unassignApplicant(int id, int applicant_id) throws RecruitmentException {
        return recruiterDao.unassignApplicant(id, applicant_id);
    }
}