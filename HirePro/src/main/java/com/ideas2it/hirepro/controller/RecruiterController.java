package com.ideas2it.hirepro.controller;

import com.ideas2it.hirepro.constants.Gender;
import com.ideas2it.hirepro.customException.RecruitmentException;
import com.ideas2it.hirepro.model.RecruiterDTO;
import com.ideas2it.hirepro.service.RecruiterService;
import com.ideas2it.hirepro.customLogger.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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

    @RequestMapping("/")
    public String homePage(Model model) {
        try {
            List<RecruiterDTO> recruiters = recruiterService.viewRecruiters();
            System.out.println(recruiters);
            model.addAttribute("recruiters", recruiters);
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_101");
        }
        return "index";
    }


    @RequestMapping("/addRecruiter")
    public String addRecruiter(Model model) {
        model.addAttribute("title", "Add Recruiter");
        return "addRecruiter";
    }


    /**
     * Method to create a Recruiter Entry.
     *
     * @param recruiter of type Recruiter.
     * @return recruiter.
     */
    @RequestMapping(value = "/handle-Recruiter", method = RequestMethod.POST)
    public RedirectView createRecruiter(@ModelAttribute RecruiterDTO recruiter, HttpServletRequest request) {
        System.out.println(recruiter);
        RedirectView redirectView = new RedirectView();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            recruiter.setDateOfBirth(simpleDateFormat.parse(request.getParameter("tempDob")));
            recruiter.setGender(Gender.valueOf(request.getParameter("tempGender")));
            recruiterService.createRecruiter(recruiter);
            redirectView.setUrl(request.getContextPath() + "/");
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_102");
        } catch (ParseException exception) {
            CustomLogger.error("ERROR_103");
        }
        return redirectView;
    }

    //delete handler

    @RequestMapping("/deleteRecruiter/{recruiterId}")
    public RedirectView deleteRecruiter(@PathVariable("recruiterId") int recruiterId, HttpServletRequest request) {
        RedirectView redirectView = new RedirectView();
        try{
            recruiterService.deleteRecruiter(recruiterId);
            redirectView.setUrl(request.getContextPath() + "/");
        } catch (RecruitmentException exception) {
            CustomLogger.error("ERROR_104");
        }
        return redirectView;
    }

    //update handler

    @RequestMapping("updateRecruiter/{recruiterId}")
    public String updateRecruiter(@PathVariable("recruiterId") int recruiterId, Model model) {
        System.out.println(recruiterId);
        try {
            //Recruiter recruiter = recruiterService.viewRecruiter(recruiterId);
            RecruiterDTO recruiter = recruiterService.viewRecruiter(recruiterId);
            model.addAttribute("recruiter", recruiter);
            model.addAttribute("title", "UpdateRecruiter");
        } catch (RecruitmentException exception) {
            //CustomLogger.info(exception.getMessage() + "abc");
        }
        return "updateRecruiter";
    }
}