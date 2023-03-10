package crm;
import java.util.Scanner;
import java.util.ArrayList;


public class User {
    private String m_name;
    private boolean m_online;
    private Scanner key_scan = new Scanner(System.in);
    protected ArrayList<Integer> m_leadAssignments = new ArrayList<Integer>();
    /**
     * Function:
     * User class contrustor during intialization,
     * prompts and accepts user input for member fields
     */
    User()
    {
        System.out.print("Please enter a name for the user: ");
        m_name = key_scan.nextLine();
        System.out.print("Is user online (true/false): ");
        m_online = key_scan.nextBoolean();
    }
    /**
     * Function:
     * AssignUserTo, Assigns the user to a lead by adding the leads number to
     * a list.
     * @param lead_number The position in the lead array of the lead to be 
     * assigned to this user
     */
    void AssignUserTo(int lead_number)
    {
        m_leadAssignments.add(lead_number);
    }
    /**
     * Function:
     * getName, name getter for the User object
     * @return m_name
     */
    String getName() { return m_name; }
    /**
     * Function:
     * getOnline, the online status getter for the user class
     * @return true: User is online
     * @return false: User is offline
     */
    boolean getOnline() { return m_online; }
}
