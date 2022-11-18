package com.ideas2it.hirepro.service.serviceImpl;
import com.ideas2it.hirepro.customException.RecruitmentException;

import com.ideas2it.hirepro.dao.ApplicantDao;
import com.ideas2it.hirepro.dto.ApplicantDto;
import com.ideas2it.hirepro.model.Applicant;
import com.ideas2it.hirepro.model.ApplicantDTO;
import com.ideas2it.hirepro.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Applicant
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
@Service
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    private ApplicantDao applicantDao;
    
    /**
     * Create a Applicant.
     *
     * @param data of type ApplicantDTO.
     * @return id.
     */
    @Override
    public void createApplicant(ApplicantDTO data) throws RecruitmentException {
        //Applicant applicant = ApplicantDto.getApplicantDao(data);
        applicantDao.createApplicant(ApplicantDto.getApplicantDao(data));
    }

    @Override
    public ApplicantDTO viewApplicant(int applicantId) throws RecruitmentException {
        return ApplicantDto.getApplicantDTO(applicantDao.getApplicant(applicantId));
    }
    @Override
    public List<ApplicantDTO> viewApplicants() throws RecruitmentException {
        return ApplicantDto.getApplicantList(applicantDao.getApplicants());
    }
    @Override
    public void deleteApplicant(int applicantId) throws RecruitmentException {
        applicantDao.deleteApplicant(applicantId);
    }
}