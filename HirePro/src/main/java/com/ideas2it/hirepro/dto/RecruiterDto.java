package com.ideas2it.hirepro.dto;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.hirepro.model.Recruiter;
import com.ideas2it.hirepro.model.RecruiterDTO;

public class RecruiterDto {
	
	public static Recruiter getRecruiterDao(RecruiterDTO recruiterDto) {
		Recruiter recruiter = new Recruiter();
		recruiter.setName(recruiterDto.getName());
		recruiter.setEmail(recruiterDto.getEmail());
		recruiter.setContactNumber(recruiterDto.getContactNumber());
		recruiter.setDateOfBirth(recruiterDto.getDateOfBirth());
		recruiter.setExperience(recruiterDto.getExperience());
		recruiter.setGender(recruiterDto.getGender());
		recruiter.setApplicants(recruiterDto.getApplicants());
		return recruiter;
	}
	
	public static RecruiterDTO getRecruiterDTO(Recruiter recruiter) {
		RecruiterDTO recruiterDto = null;
		
		if (null != recruiter) {
			recruiterDto = new RecruiterDTO();
			recruiterDto.setRecruiterId(recruiter.getRecruiterId());
			recruiterDto.setName(recruiter.getName());
			recruiterDto.setEmail(recruiter.getEmail());
			recruiterDto.setContactNumber(recruiter.getContactNumber());
			recruiterDto.setDateOfBirth(recruiter.getDateOfBirth());
			recruiterDto.setExperience(recruiter.getExperience());
			recruiterDto.setGender(recruiter.getGender());
			recruiterDto.setApplicants(recruiter.getApplicants());
		}
		return recruiterDto;		
	}

	public static List<RecruiterDTO> getRecruiterList(List<Recruiter> recruiters) {
		List<RecruiterDTO> recruiterDtoList = new ArrayList<RecruiterDTO>();
		
		if(null!=recruiters) {
			for (Recruiter recruiter : recruiters) {
				RecruiterDTO recruiterDto = new RecruiterDTO();
				recruiterDto.setRecruiterId(recruiter.getRecruiterId());
				recruiterDto.setName(recruiter.getName());
				recruiterDto.setEmail(recruiter.getEmail());
				recruiterDto.setContactNumber(recruiter.getContactNumber());
				recruiterDto.setDateOfBirth(recruiter.getDateOfBirth());
				recruiterDto.setExperience(recruiter.getExperience());
				recruiterDto.setGender(recruiter.getGender());
				recruiterDtoList.add(recruiterDto);
			}
		}
		return recruiterDtoList;
	}
}
