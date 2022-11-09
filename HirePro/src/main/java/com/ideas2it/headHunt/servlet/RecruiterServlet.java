package com.ideas2it.headHunt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.ideas2it.headHunt.constants.Gender;
import com.ideas2it.headHunt.controller.ApplicantController;
import com.ideas2it.headHunt.controller.RecruiterController;
import com.ideas2it.headHunt.customException.RecruitmentException;
import com.ideas2it.headHunt.dto.ApplicantDto;
import com.ideas2it.headHunt.model.Applicant;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.RecruiterDTO;

//import net.javaguides.usermanagement.dao.UserDao;
//import net.javaguides.usermanagement.model.User;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet(urlPatterns= {"/createRecruiter", "/readRecruiter", "/updateRecruiter", "/deleteRecruiter","/assignApplicants","/unassignApplicants","/viewAssignedApplicants"})
public class RecruiterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RecruiterController recruiterController;

    public void init() {
        recruiterController = new RecruiterController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/createRecruiter":
            	createRecruiter(request, response);
                break;
            case "/readRecruiter":
            	readRecruiter(request, response);
                break;
            case "/updateRecruiter":
            	updateRecruiter(request, response);
                break;
            case "/deleteRecruiter":
            	deleteRecruiter(request, response);
                break;
            case "/assignApplicants":
            	assignApplicants(request, response);
                break;
            case "/unassignApplicants":
            	unassignApplicant(request, response);
                break;
            case "/viewAssignedApplicants":
                getAssignedApplicants(request, response);
                break;
            default:
                //listUser(request, response);
                break;
        }
    }


    private void createRecruiter(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {    	
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String contactNumber = request.getParameter("number");
    	Date date = null;
    	
    	try {
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			date = simpleDateFormat.parse(request.getParameter("dob"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Gender gender = Gender.valueOf(request.getParameter("gender"));
    	int experience = Integer.parseInt(request.getParameter("experience"));

    	//PrintWriter pw = response.getWriter();
    	//pw.println(degree);
    	
    	RecruiterDTO newRecruiter = new RecruiterDTO(name, email, contactNumber, date, experience, gender);
        RecruiterDTO recruiter = recruiterController.createRecruiter(newRecruiter);
    	HttpSession session = request.getSession();
    	session.setAttribute("recruiter", recruiter);
    	response.sendRedirect("createRecruiter.jsp");
        //PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    	//pw.println("<h1> Your email address is  " + email);*/
    }

    private void updateRecruiter(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
    	RecruiterDTO recruiter = recruiterController.getById(id);

    	recruiter.setName(request.getParameter("name"));
    	recruiter.setEmail(request.getParameter("email"));
    	recruiter.setContactNumber(request.getParameter("number"));
    	try {
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    		recruiter.setDateOfBirth(simpleDateFormat.parse(request.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	recruiter.setGender(Gender.valueOf(request.getParameter("gender")));
    	recruiter.setExperience(Integer.parseInt(request.getParameter("experience")));
    	
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("applicant", recruiter);
    	response.sendRedirect("updateRecruiter.jsp");
    	recruiterController.isUpdated(recruiter, id);
        //response.sendRedirect("list");
        //PrintWriter pw = response.getWriter();
    	//pw.println("I am inside update applicant servlet");
    }

    private void deleteRecruiter(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = recruiterController.isDeleted(id);
    	PrintWriter pw = response.getWriter();
    	if (status) {
    		pw.println("Applicant deleted successfully");
    	} else {
    		pw.println("Invalid Id");
    	}
    		
    }
    private void readRecruiter(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    	
    	int id = Integer.parseInt(request.getParameter("id"));
    	RecruiterDTO recruiter = recruiterController.getById(id);
    	HttpSession session = request.getSession();
    	session.setAttribute("recruiter", recruiter);

    	if (request.getParameter("source").equals("readRecruiter")) {
        	response.sendRedirect("readRecruiter.jsp");
    	} else if (request.getParameter("source").equals("forAssign")) {
        	response.sendRedirect("assignApplicant.jsp");
    	}   
    	
    	else {
    		response.sendRedirect("updateRecruiter.jsp");
    	}
    	//PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    }
    
    private void assignApplicants(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    	int recruiter_Id = Integer.parseInt(request.getParameter("recruiter_Id"));
    	RecruiterDTO recruiter = recruiterController.getById(recruiter_Id);
    	List<Applicant> applicants = recruiter.getApplicants();
    	List<String> applicantIds = (List<String>) Arrays.asList(request.getParameterValues("applicant_Id"));
    	//boolean status = recruiterController.assignApplicant(recruiter_Id, applicant_Id);
    	
    	if(null!=recruiter) {
    		
    		if(!applicantIds.isEmpty()) {

				ApplicantController applicantController = new ApplicantController();
    			for(String applicantId: applicantIds) {
    				Applicant applicant= null;
					try {
						applicant = ApplicantDto.getApplicantDao(applicantController.getById(Integer.parseInt(applicantId)));
					} catch (NumberFormatException | RecruitmentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				applicants.add(applicant);
    			}
    		}
    		recruiter.setApplicants(applicants);
    	}
    	boolean status = recruiterController.isUpdated(recruiter, recruiter_Id);
    	HttpSession session = request.getSession();
    	session.setAttribute("status", status);

    	if (request.getParameter("source").equals("AssignApplicants")) {
        	response.sendRedirect("assignApplicant.jsp");
    	}
    	//PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    }
    
    private void unassignApplicant(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    	
    	int recruiter_Id = Integer.parseInt(request.getParameter("recruiter_Id"));
    	RecruiterDTO recruiter = recruiterController.getById(recruiter_Id);
    	List<Applicant> applicants = new ArrayList<>();
    	List<String> applicantIds = (List<String>) Arrays.asList(request.getParameterValues("applicant_Id"));
    	//int applicant_Id = Integer.parseInt(request.getParameter("applicant_Id"));
    	//boolean status = recruiterController.unassignApplicant(recruiter_Id, applicant_Id);
    	if(null!=recruiter) {
    		
    		if(!applicantIds.isEmpty()) {

				ApplicantController applicantController = new ApplicantController();
    			for(String applicantId: applicantIds) {
    				Applicant applicant= null;
					try {
						applicant = ApplicantDto.getApplicantDao(applicantController.getById(Integer.parseInt(applicantId)));
					} catch (NumberFormatException | RecruitmentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				applicants.add(applicant);
    			}
    		}
			System.out.println(applicants);
    		recruiter.setApplicants(applicants);
    	}		
    	boolean status = recruiterController.isUpdated(recruiter, recruiter_Id);
    	HttpSession session = request.getSession();
    	session.setAttribute("status", status);

    	if (request.getParameter("source").equals("unassignApplicants")) {
        	response.sendRedirect("unassignApplicant.jsp");
    	}
    	//PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    }
    
    private void getAssignedApplicants(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	List<ApplicantDTO> applicants = recruiterController.getAssignedApplicants(id);    			;
    	HttpSession session = request.getSession();
    	session.setAttribute("applicantList", applicants);    	
    	
    		response.sendRedirect("unassignApplicant.jsp");
    	
    	//PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    }
}