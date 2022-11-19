package com.ideas2it.hirepro.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.ideas2it.hirepro.constants.Degree;
import com.ideas2it.hirepro.constants.Gender;
import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.customLogger.CustomLogger;
import com.ideas2it.hirepro.model.ApplicantDTO;
import com.ideas2it.hirepro.model.RecruiterDTO;
import com.ideas2it.hirepro.service.ApplicantService;
import com.ideas2it.hirepro.service.RecruiterService;

/**
 * Controller class for headHunt Application
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *
 */
@Controller
public class RecruiterController {
    @Autowired
    private RecruiterService recruiterService;    

    @Autowired
    private ApplicantService applicantService;

    @GetMapping("/")
    public String homePage(Model model) {
    	model.addAttribute("title", "Home");
        return "index";
    }
    
    @GetMapping("/index")
    public String indexPage(Model model) {
    	model.addAttribute("title", "Home");
        return "index";
    }
    
    @GetMapping("/recruiter")
    public String recruiterPage(Model model) {
        try {
            List<RecruiterDTO> recruiters = recruiterService.viewRecruiters();
            model.addAttribute("recruiters", recruiters);
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_101");
        }
        return "recruiter";
    }
    
    @GetMapping("/applicant")
    public String applicantPage(Model model) {
        try {
            List<ApplicantDTO> applicants = applicantService.viewApplicants();
            model.addAttribute("applicants", applicants);
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_101");
        }
        return "applicant";
    }
    

    @GetMapping("/showAddRecruiterPage")
    public String addRecruiter(Model model) {
        model.addAttribute("title", "Add Recruiter");
        return "addRecruiter";
    }    

    @GetMapping("/showAddApplicantPage")
    public String addApplicant(Model model) {
        model.addAttribute("title", "Add Applicant");
        return "addApplicant";
    }


    /**
     * Method to create a Recruiter Entry.
     *
     * @param recruiter of type Recruiter.
     * @return recruiter.
     */
    @PostMapping("/handleRecruiter")
    public RedirectView createRecruiter(@ModelAttribute RecruiterDTO recruiter, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            recruiter.setDateOfBirth(simpleDateFormat.parse(request.getParameter("tempDob")));
            recruiter.setGender(Gender.valueOf(request.getParameter("tempGender")));
            recruiterService.createRecruiter(recruiter);
            redirectView.setUrl(request.getContextPath() + "/recruiter");
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_102");
        } catch (ParseException exception) {
            CustomLogger.error("ERROR_103");
        }
        return redirectView;
    }
    
    @PostMapping("/handleApplicant")
    public RedirectView createApplicant(@ModelAttribute ApplicantDTO applicant, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            applicant.setDateOfBirth(simpleDateFormat.parse(request.getParameter("tempDob")));
            applicant.setGender(Gender.valueOf(request.getParameter("tempGender")));
            applicant.setDegree(Degree.valueOf(request.getParameter("tempDegree")));
            applicantService.createApplicant(applicant);
            redirectView.setUrl(request.getContextPath() + "/applicant");
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_102");
        } catch (ParseException exception) {
            CustomLogger.error("ERROR_103");
        }
        return redirectView;
    }

    //delete handler
    
    @GetMapping("/deleteRecruiter/{recruiterId}")
    public RedirectView deleteRecruiter(@PathVariable("recruiterId") int recruiterId, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        try{
            recruiterService.deleteRecruiter(recruiterId);
            redirectView.setUrl(request.getContextPath() + "/recruiter");
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_104");
        }
        return redirectView;
    }
    
    @GetMapping("/deleteApplicant/{applicantId}")
    public RedirectView deleteApplicant(@PathVariable("applicantId") int applicantId, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        try{
            applicantService.deleteApplicant(applicantId);
            redirectView.setUrl(request.getContextPath() + "/applicant");
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_104");
        }
        return redirectView;
    }

    //update handler

    @GetMapping("showUpdatePage/{recruiterId}")
    public String updateRecruiter(@PathVariable("recruiterId") int recruiterId, Model model) {
        try {
            RecruiterDTO recruiter = recruiterService.viewRecruiter(recruiterId);
            model.addAttribute("recruiter", recruiter);
            model.addAttribute("title", "Update Recruiter");
        } catch (RecruitmentException exception) {
            CustomLogger.info(exception.getMessage());
        }
        return "updateRecruiter";
    }
    
    @GetMapping("updateApplicant/{applicantId}")
    public String updatePage(@PathVariable("applicantId") int applicantId, Model model) {
        try {
            ApplicantDTO applicant = applicantService.viewApplicant(applicantId);
            model.addAttribute("applicant", applicant);
            model.addAttribute("title", "Update Applicant");
        } catch (RecruitmentException exception) {
            CustomLogger.info(exception.getMessage());
        }
        return "updateApplicant";
    }
    
    @GetMapping("showAssignPage/{recruiterId}")
    public String assignPage(@PathVariable("recruiterId") int recruiterId, Model model) {
    	
    	try {
    		model.addAttribute("recruiter", recruiterService.viewRecruiter(recruiterId));
    		model.addAttribute("applicants", applicantService.viewApplicants());   
    		model.addAttribute("title", "Assign Applicants");
    	} catch(RecruitmentException exception) {
    		CustomLogger.error(exception.getMessage());
    	}
    	return "assignApplicants";
    }
    
    @PostMapping("/assignApplicants")
    public RedirectView assignApplicants(Model model, HttpServletRequest request) {
    	RedirectView redirectView = new RedirectView();
    	try {
    		int recruiterId = Integer.parseInt(request.getParameter("recruiterId"));
    		List<String> recruiterIds = Arrays.asList(request.getParameterValues("applicant_Id"));
    		recruiterService.assignApplicants(recruiterId, recruiterIds);
    		redirectView.setUrl(request.getContextPath() +"/recruiter");
    		
    	} catch(RecruitmentException exception) {
    		CustomLogger.error(exception.getMessage());
    	}
    	return redirectView;
    }
}