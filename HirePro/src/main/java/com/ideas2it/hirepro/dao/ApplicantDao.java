package com.ideas2it.hirepro.dao;

import java.util.List;

import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.model.Applicant;
/*
 * Applicant Dao interface for headHunt Application 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public interface ApplicantDao {

    /**
     * Create Applicant.
     *
     * @param applicant of type Applicant.
     * @return applicant.
     */
    void createApplicant(Applicant applicant) throws RecruitmentException;

    Applicant getApplicant(int applicantId) throws RecruitmentException;

    List<Applicant> getApplicants() throws RecruitmentException;

    void deleteApplicant(int applicantId) throws RecruitmentException;
}