package com.ideas2it.hirepro.service;

import java.util.List;

import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.model.Applicant;
import com.ideas2it.hirepro.model.ApplicantDTO;

/**
 * Service class for Applicant 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public interface ApplicantService {
    
    /**
     * Create a Applicant.
     *
     * @param applicant of type Applicant.
     * @return applicant.
     */
    public void createApplicant(ApplicantDTO applicant) throws RecruitmentException;

    public ApplicantDTO viewApplicant(int applicantId) throws RecruitmentException;

    public List<ApplicantDTO> viewApplicants() throws RecruitmentException;

    public void deleteApplicant(int applicantId) throws RecruitmentException;

	public List<Applicant> getApplicantsByIds(List<String> applicantIds);

}