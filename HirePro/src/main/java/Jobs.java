import com.ideas2it.headHunt.view.UserView;

/**
 * <h1>Recruiment Process</h1>
 * The Recruitment Process program implements an application that
 * registers current company employees as recruiters based on certain conditions
 * and also registers applicants and checks their eligibility for the recruitment.
 *
 * @author  Aabid Farooq
 * @version 18.0.2
 * @since   2022-08-01
 * 
 *
 */
public class Jobs { 
    
    /**
     * Main method. Program execution starts at this method.
     *
     * @param args Unused (used if arguments are passed at runtime).     
     */
    public static void main(String[] args) { 
        UserView userView = new UserView();
        userView.menu();        
    }
}