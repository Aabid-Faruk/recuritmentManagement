package com.ideas2it.headHunt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.ideas2it.headHunt.constants.Degree;
import com.ideas2it.headHunt.constants.Gender;
import com.ideas2it.headHunt.controller.ApplicantController;
import com.ideas2it.headHunt.model.ApplicantDTO;
import com.ideas2it.headHunt.model.RecruiterDTO;

//import net.javaguides.usermanagement.dao.UserDao;
//import net.javaguides.usermanagement.model.User;

/**
 * ControllerServlet.java test by mad
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet(urlPatterns= {"/createApplicant", "/readApplicant", "/updateApplicant", "/deleteApplicant","/viewAssignedRecruiters","/viewAllApplicants"})
public class ApplicantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ApplicantController applicantController;

    public void init() {
        applicantController = new ApplicantController();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/createApplicant":
            	createApplicant(request, response);
                break;
            case "/readApplicant":
                displayApplicant(request, response);
                break;
            case "/updateApplicant":
                updateApplicant(request, response);
                break;
            case "/deleteApplicant":
                deleteApplicant(request, response);
                break;
            case "/viewAssignedRecruiters":
                getAssignedRecruiters(request, response);
                break;
            case "/viewAllApplicants":
                getAllApplicants(request, response);
                break;
            default:
                //listUser(request, response);
                break;
        }
    }


    private void createApplicant(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {    	
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
    	Degree degree = Degree.valueOf(request.getParameter("degree"));

    	//PrintWriter pw = response.getWriter();
    	//pw.println(degree);
    	
    	ApplicantDTO newApplicant = new ApplicantDTO(name, email, contactNumber, date, experience, degree, gender);
        ApplicantDTO applicant = applicantController.createApplicant(newApplicant);
    	//HttpSession session = request.getSession();
    	//session.setAttribute("applicant", applicant);
    	//response.sendRedirect("createApplicant.jsp");
        request.setAttribute("applicant", applicant);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/createApplicant.jsp");
        rd.forward(request, response);
        //PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    	//pw.println("<h1> Your email address is  " + email);*/
    }

    private void updateApplicant(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{
        int id = Integer.parseInt(request.getParameter("id"));
    	ApplicantDTO applicant = applicantController.getById(id);

    	applicant.setName(request.getParameter("name"));
    	applicant.setEmail(request.getParameter("email"));
    	applicant.setContactNumber(request.getParameter("number"));
    	try {
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    		applicant.setDateOfBirth(simpleDateFormat.parse(request.getParameter("dob")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	applicant.setGender(Gender.valueOf(request.getParameter("gender")));
    	applicant.setExperience(Integer.parseInt(request.getParameter("experience")));
    	applicant.setDegree(Degree.valueOf(request.getParameter("degree")));
    	
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("applicant", applicant);
    	response.sendRedirect("updateApplicant.jsp");
    	applicantController.isUpdated(applicant, id);
    	//PrintWriter pw = response.getWriter();
    	//pw.println(degree);
    	
    	//ApplicantDTO updateApplicant = new ApplicantDTO(name, email, contactNumber, date, experience, degree, gender);
        
        //applicantController.isUpdated(updatedApplicant, id);
       // response.sendRedirect("list");
        //PrintWriter pw = response.getWriter();
    	//pw.println("I am inside update applicant servlet");
    }

    private void deleteApplicant(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = applicantController.isDeleted(id);
    	PrintWriter pw = response.getWriter();
    	if (status) {
    		pw.println("Applicant deleted successfully");
    	} else {
    		pw.println("Invalid Id");
    	}
    		
    }
    private void displayApplicant(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	ApplicantDTO applicant = applicantController.getById(id);
    	HttpSession session = request.getSession();
    	session.setAttribute("applicant", applicant);

    	if (request.getParameter("source").equals("readApplicant")) {
        	response.sendRedirect("readApplicant.jsp");
    	}   
    	else if(request.getParameter("source").equals("viewAssignedRecruiters")) {
    		response.sendRedirect("viewAssignedRecruiters.jsp");
    	}
    	else {
    		response.sendRedirect("updateApplicant.jsp");
    	}
    	//PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    }
    
    private void getAssignedRecruiters(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	List<RecruiterDTO> recruiters = applicantController.getAssignedRecruiters(id);
    	HttpSession session = request.getSession();
    	session.setAttribute("recruiterList", recruiters);

    	if (request.getParameter("source").equals("viewAssignedRecruiters")) {
    		response.sendRedirect("viewAssignedRecruiters.jsp");
    	}
    	//PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    }
    
    private void getAllApplicants(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    	List<ApplicantDTO> applicants = applicantController.viewApplicants();
    	HttpSession session = request.getSession();
    	session.setAttribute("viewAllApplicants", applicants);

    	//if (request.getParameter("source").equals("viewAllApplicants")) {
    		response.sendRedirect("assignApplicant.jsp");
    	//}
    	//PrintWriter pw = response.getWriter();
    	//pw.println(applicant);
    }
}