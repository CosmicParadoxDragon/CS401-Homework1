package crm;

import java.util.Scanner;


public class Lead {
    private String m_name, m_email, m_location;
    Scanner key_scan = new Scanner(System.in);
    
    /**
     * Function:
     * Lead, constructor for the Lead object,
     * prompts and accepts user input for the member fields
     */
    Lead()
    {
        System.out.print("Please enter a name for the lead: ");
        m_name = key_scan.nextLine();
        System.out.print("Please enter an email contact for the lead: ");
        m_email = key_scan.nextLine();
        System.out.print("Please enter the country where the lead is located: ");
        m_location = key_scan.nextLine();
        //key_scan.close();
    }
    /**
     * Basic (non-defualt) constructor -- not in use anywhere in program
     */
    Lead(String name, String email, String location)
    {
        m_name = name;
        m_email = email;
        m_location = location;
    }

    /**
     * Getters for the Lead Objects
     */
    String getName() { return m_name; }
    String getEmail() { return m_email; }
    String getLocation() { return m_location; }
    
}
