package com.ideas2it.hirepro.constants;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final int RECRUITER = 1;
    public static final int APPLICANT = 2;
    public static final int EXIT_APPLICATION = 3;
    public static final int REGISTER = 1;
    public static final int VIEW = 2;
    public static final int UPDATE = 3;
    public static final int DELETE = 4;
    public static final int PREVIOUS_MENU = 5;
    public static final int VIEW_ALL = 1;
    public static final int VIEW_BY_ID = 2;
    public static final int VIEW_BY_EMAIL = 3;
    public static final int VIEW_BY_NUMBER = 4;
    public static final int VIEW_ASSIGNED_APPLICANTS = 5;
    public static final int VIEW_ASSIGNED_RECRUITERS = 5;
    public static final int PREVIOUS_USER_MENU = 6;
    public static final int UPDATE_NAME = 1;
    public static final int UPDATE_EMAIL = 2;
    public static final int UPDATE_NUMBER = 3;
    public static final int UPDATE_DOB = 4;
    public static final int UPDATE_EXPERIENCE = 5;
    public static final int UPDATE_GENDER = 6;
    public static final int UPDATE_DEGREE = 7;
    public static final int ASSIGN_APPLICANT = 7;
    public static final int UNASSIGN_APPLICANT = 8;


    public static final String MAIN_MENU = "\nPress 1 for Recruiter \n" 
                                         + "Press 2 for Applicant \n"
                                         + "Press 3 to exit\n";

    public static final String APPLICANT_MENU = "\nPress 1 to register as Applicant \n"
                                               +"Press 2 to view registered Applicants \n"
                                               +"Press 3 to update a registered Applicant \n"
                                               +"Press 4 to delete a registered Applicant \n"
                                               +"Press 5 to go back to Previous Menu\n";

    public static final String RECRUITER_MENU = "\nPress 1 to register as Recruiter \n"
                                               +"Press 2 to view registered Recruiters \n"
                                               +"Press 3 to update a registered Recruiter \n"
                                               +"Press 4 to delete a registered Recruiter \n"
                                               +"Press 5 to go back to Previous Menu\n";

    public static final String RECRUITER_UPDATE_MENU = "Enter 1 to update Name\n"
                                            +"Enter 2 to update Email\n"
                                            +"Enter 3 to update Mobile Number\n"
                                            +"Enter 4 to update Date of Birth\n"
                                            +"Enter 5 to update Experience\n"
                                            +"Enter 6 to update Gender\n"
                                            +"Enter 7 to Assign a Applicant\n"
                                            +"Enter 8 to Unassign an Applicant\n";

    public static final String APPLICANT_UPDATE_MENU = "Enter 1 to update Name\n"
                                            +"Enter 2 to update Email\n"
                                            +"Enter 3 to update Mobile Number\n"
                                            +"Enter 4 to update Date of Birth\n"
                                            +"Enter 5 to update Experience\n"
                                            +"Enter 6 to update Gender\n"
                                            +"Enter 7 to update Degree\n";

    public static final String VIEW_RECRUITER_MENU = "\nPress 1 to view all Recruiters \n"
                                           +"Press 2 to view Recruiter using ID \n"
                                           +"Press 3 to view Recruiter using EMAIL \n"
                                           +"Press 4 to view Recruiter CONTACT NUMBER \n"
                                           +"Press 5 to view Applicants Assigned to a Recruiter \n"
                                           +"Press 6 to return to Main Menu \n";

    public static final String VIEW_APPLICANT_MENU = "\nPress 1 to view all Applicants \n"
                                           +"Press 2 to view Applicant using ID \n"
                                           +"Press 3 to view Applicant using EMAIL \n"
                                           +"Press 4 to view Applicant using CONTACT NUMBER \n"
                                           +"Press 5 to view Recruiters Assigned to an Applicant \n"
                                           +"Press 6 to return to Main Menu \n";

    public static final String ERROR_101 = "101";
    public static final String ERROR_102 = "102";
    public static final String ERROR_103 = "103";
    public static final String ERROR_104 = "104";
    public static final String ERROR_105 = "105";
    public static final String ERROR_106 = "106";
    public static final String ERROR_107 = "107";
    public static final String ERROR_108 = "108";
    public static final String ERROR_109 = "109";
    public static final String ERROR_110 = "110";
    public static final String ERROR_111 = "111";
    public static final String ERROR_112 = "112";
    public static final String ERROR_113 = "113";
    public static final String ERROR_114 = "114";
    public static final String ERROR_115 = "115";

    public static Map<String, String> map = new HashMap<String, String>();

    public static Map<String, String> getErrorCode() {
        String ERROR_MESSAGE_101 = "Registration Failed. Try later.";
        String ERROR_MESSAGE_102 = "Failed to Fetch Details. Try later.";
        String ERROR_MESSAGE_103 = "Failed to Fetch Details Using ID. Try later.";
        String ERROR_MESSAGE_104 = "Failed to Fetch Details. Try later.";
        String ERROR_MESSAGE_105 = "Failed to Fetch Details using Email. Try later.";
        String ERROR_MESSAGE_106 = "Failed to Fetch Details using Number. Try later.";
        String ERROR_MESSAGE_107 = "ID Validation Error. Please try later.";
        String ERROR_MESSAGE_108 = "Email Validation Error. Please try later.";
        String ERROR_MESSAGE_109 = "Number Validation Error. Please try later.";
        String ERROR_MESSAGE_110 = "Data Updation Error. Please try later.";
        String ERROR_MESSAGE_111 = "Data Deletion Error. Please try later.";
        String ERROR_MESSAGE_112 = "Applicant Assignment Error. Please try later.";
        String ERROR_MESSAGE_113 = "Applicant Unassignment Error. Please try later.";
        String ERROR_MESSAGE_114 = "ID Generation Error. Please try later.";
        String ERROR_MESSAGE_115 = "Database connection closing error. Please try later.";
    
        map.put(ERROR_101, ERROR_MESSAGE_101);
        map.put(ERROR_102, ERROR_MESSAGE_102);
        map.put(ERROR_103, ERROR_MESSAGE_103);
        map.put(ERROR_104, ERROR_MESSAGE_104);
        map.put(ERROR_105, ERROR_MESSAGE_105);
        map.put(ERROR_106, ERROR_MESSAGE_106);
        map.put(ERROR_107, ERROR_MESSAGE_107);
        map.put(ERROR_108, ERROR_MESSAGE_108);
        map.put(ERROR_109, ERROR_MESSAGE_109);
        map.put(ERROR_110, ERROR_MESSAGE_110);
        map.put(ERROR_111, ERROR_MESSAGE_111);
        map.put(ERROR_112, ERROR_MESSAGE_112);
        map.put(ERROR_113, ERROR_MESSAGE_113);
        map.put(ERROR_114, ERROR_MESSAGE_114);
        map.put(ERROR_115, ERROR_MESSAGE_115);
        return map;
    }
}