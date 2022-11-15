package com.ideas2it.hirepro.service.serviceImpl;
import com.ideas2it.hirepro.customException.RecruitmentException;

import com.ideas2it.hirepro.dao.RecruiterDao;
import com.ideas2it.hirepro.dto.RecruiterDto;
import com.ideas2it.hirepro.model.Recruiter;
import com.ideas2it.hirepro.model.RecruiterDTO;
import com.ideas2it.hirepro.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Recruiter 
 * 
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
@Service
public class RecruiterServiceImpl implements RecruiterService {
    @Autowired
    private RecruiterDao recruiterDao;
    
    /**
     * Create a Recruiter.
     *
     * @param data of type RecruiterDTO.
     * @return id.
     */
    @Override
    public Integer createRecruiter(RecruiterDTO data) throws RecruitmentException {
        //Recruiter recruiter = RecruiterDto.getRecruiterDao(data);
        Integer id = recruiterDao.createRecruiter(RecruiterDto.getRecruiterDao(data));
        return id;
    }

    public List<RecruiterDTO> getRecruiters() throws RecruitmentException {
        List<RecruiterDTO> recruiters = RecruiterDto.getRecruiterList(recruiterDao.getRecruiters());
        return recruiters;
    }
}