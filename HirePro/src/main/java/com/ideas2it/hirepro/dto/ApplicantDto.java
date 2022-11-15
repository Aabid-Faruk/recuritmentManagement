package com.ideas2it.hirepro.dto;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.model.Applicant;
import com.ideas2it.hirepro.model.ApplicantDTO;

public class ApplicantDto {
	
	public static Applicant getApplicantDao(ApplicantDTO applicantDto) throws RecruitmentException {
		Applicant applicant = new Applicant();
		applicant.setApplicantId(applicantDto.getApplicantId());
		applicant.setName(applicantDto.getName());
		applicant.setEmail(applicantDto.getEmail());
		applicant.setContactNumber(applicantDto.getContactNumber());
		applicant.setDateOfBirth(applicantDto.getDateOfBirth());
		applicant.setExperience(applicantDto.getExperience());
		applicant.setGender(applicantDto.getGender());
		applicant.setDegree(applicantDto.getDegree());
		applicant.setRecruiters(applicantDto.getRecruiters());
		return applicant;
	}
	
	public static ApplicantDTO getApplicantDTO(Applicant applicant) throws RecruitmentException {
		ApplicantDTO applicantDto = null;
		
		if (null != applicant) {
			applicantDto = new ApplicantDTO();
			applicantDto.setApplicantId(applicant.getApplicantId());
			applicantDto.setName(applicant.getName());
			applicantDto.setEmail(applicant.getEmail());
			applicantDto.setContactNumber(applicant.getContactNumber());
			applicantDto.setDateOfBirth(applicant.getDateOfBirth());
			applicantDto.setExperience(applicant.getExperience());
			applicantDto.setGender(applicant.getGender());
			applicantDto.setDegree(applicant.getDegree());
			applicantDto.setRecruiters(applicant.getRecruiters());
		}		
		return applicantDto;
	}
	
	public static List<ApplicantDTO> getApplicantList(List<Applicant> applicants) throws RecruitmentException {
		List<ApplicantDTO> applicantDtoList = new ArrayList<ApplicantDTO>();
		for(Applicant applicant: applicants) {
			ApplicantDTO applicantDto = new ApplicantDTO();
			applicantDto.setApplicantId(applicant.getApplicantId());
			applicantDto.setName(applicant.getName());
			applicantDto.setEmail(applicant.getEmail());
			applicantDto.setContactNumber(applicant.getContactNumber());
			applicantDto.setDateOfBirth(applicant.getDateOfBirth());
			applicantDto.setExperience(applicant.getExperience());
			applicantDto.setGender(applicant.getGender());
			applicantDto.setDegree(applicant.getDegree());
			applicantDtoList.add(applicantDto);
		}
		return applicantDtoList;
	}

}
