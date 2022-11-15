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
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *
 */
@Controller
public class RecruiterController {
    @Autowired
    private RecruiterService recruiterService;

    private CustomLogger customLogger;

    @RequestMapping("/")
    public String homePage(Model model) {
        try {
            List<RecruiterDTO> recruiters = (List<RecruiterDTO>) recruiterService.getRecruiters();
            System.out.println(recruiters);
            model.addAttribute("recruiters", recruiters);
        } catch (RecruitmentException exception) {
            customLogger.error(exception.getMessage());
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
            Integer id = recruiterService.createRecruiter(recruiter);
           System.out.println(id);
            redirectView.setUrl(request.getContextPath() + "/index");
        } catch (RecruitmentException exception) {
            customLogger.error(exception.getMessage());
        } catch (ParseException exception) {
            customLogger.error(exception.getMessage());
        }
        return redirectView;
    }
}
