package com.ideas2it.hirepro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.hirepro.constants.Degree;
import com.ideas2it.hirepro.constants.Gender;

/*
 * Utility class for headHunt Application 
 * This class is used to validate details of 
 * candidates registering at headHunt application
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 *  
 */
public class Validator {

    /**
     * Method to validate user registration details.
     *
     * @param data of type String.
     * @param exp of type String(regex).
     * @return boolean.
     */  
    public static boolean isValid(String data, String exp) {
        // Compile regular expression
        Pattern pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
        // Match regex against input
        final Matcher matcher = pattern.matcher(data);
        // Use results...
        return matcher.matches();
    }

    public static boolean isValidExperience(int data) {
        if (0 <= data && data <= 34) {
           return true;
        } else {
           return false;
        }
    }

    /**
     * Method to validate user's Gender.
     *
     * @param gender of type Gender.
     * @return boolean.
     */
    public static boolean isValidGender(String data) {
    	
        try {           
            Gender gender = Gender.valueOf(data);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * Method to validate user's Degree.
     *
     * @param degree of type Degree.
     * @return boolean.
     */
    public static boolean isValidDegree(String data) {

        try {
            Degree degree = Degree.valueOf(data);
        } catch (IllegalArgumentException ex) {
            return false;
        }
        return true;
    }

    /**
     * Method to validate user's date of birth details.
     *
     * @param data of type String.
     * @return boolean.
     */
    public static boolean isValidDate(String date) {
    	Date dateOfBirth = null;
    	boolean status = false; 
    	try {
    		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    		dateOfBirth = simpleDateFormat.parse(date);
    		int age = calculateAge(dateOfBirth);
       
    	    if (17 <= age && age <= 28) {
    	    	status = true;
    	    } 
    	} catch(ParseException ex) {
    		System.out.println(status);
    		return status;
        }return status;
    }

    public static int calculateAge(Date dateOfBirth) { 
        Date currentDate = new Date(); 
        long ageInMiliSecond = currentDate.getTime() - dateOfBirth.getTime();
        int age = (int)(ageInMiliSecond / (1000l * 60 * 60 * 24 * 365));
        return age;
    }
    
/*    public static java.sql.Date convertUtilDateToSql(Date dateOfBirth) {
        return new java.sql.Date(dateOfBirth.getTime());
    }

    public static Date convertSqlDateToUtil(Date dateOfBirth) { 
        return new java.util.Date(dateOfBirth.getTime());
    }*/
}