package com.ideas2it.hirepro.service.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.dao.RecruiterDao;
import com.ideas2it.hirepro.dto.RecruiterDto;
import com.ideas2it.hirepro.model.Applicant;
import com.ideas2it.hirepro.model.RecruiterDTO;
import com.ideas2it.hirepro.service.ApplicantService;
import com.ideas2it.hirepro.service.RecruiterService;

/**
 * Service class for Recruiter
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
@Service
public class RecruiterServiceImpl implements RecruiterService {
    @Autowired
    private RecruiterDao recruiterDao;
    
    @Autowired
    private ApplicantService applicantService;
    
    /**
     * Create a Recruiter.
     *
     * @param data of type RecruiterDTO.
     * @return id.
     */
    @Override
    public void createRecruiter(RecruiterDTO data) throws RecruitmentException {
        recruiterDao.createRecruiter(RecruiterDto.getRecruiterDao(data));
    }

    @Override
    public RecruiterDTO viewRecruiter(int recruiterId) throws RecruitmentException {
        return RecruiterDto.getRecruiterDTO(recruiterDao.getRecruiter(recruiterId));
    }
    @Override
    public List<RecruiterDTO> viewRecruiters() throws RecruitmentException {
        return RecruiterDto.getRecruiterList(recruiterDao.getRecruiters());
    }
    @Override
    public void deleteRecruiter(int recruiterId) throws RecruitmentException {
        recruiterDao.deleteRecruiter(recruiterId);
    }

	@Override
	public void assignApplicants(int recruiterId, List<String> recruiterIds) throws RecruitmentException {
		RecruiterDTO recruiter = this.viewRecruiter(recruiterId);	
		List<Applicant> applicants = applicantService.getApplicantsByIds(recruiterIds);
		if(!applicants.isEmpty()) {
			recruiter.setApplicants(applicants);
			this.createRecruiter(recruiter);
		}
	}
}