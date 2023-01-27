package crm;
import java.util.Scanner;
import java.util.InputMismatchException;

import java.util.ArrayList;

public class AssignLeads {
    final int   EXIT = 0,
                ADD_LEAD = 1,
                ADD_USER = 2,
                ASSIGN = 3,
                DISPLAY = 4,
                NO_STATE = -1;

    Scanner key_scan = new Scanner(System.in);
    private ArrayList<Lead> leads;
    private ArrayList<User> users;
    int command = -1;
    /**
     * Function: Constructor for the AssignLeads Object
     * Serves as the main entry point for the program
     * Calls MainLoop
     */
    AssignLeads()
    {
        leads = new ArrayList<Lead>();
        users = new ArrayList<User>();
        command = NO_STATE;
        MainLoop();
    }
    /**
     * Function:
     * MainLoop serves as the main driver for the logic of the program
     * class and references the entire package
     * Asks for input, checks for vaild input and repeats
     */
    void MainLoop()
    {
        while (command != 0)
        {
            boolean valid = false;
            while (!valid)
            {
                try { 
                    System.out.print(   "0. Quit\n1. Add a lead\n2. Add a user\n3. Assign leads\n4. Display leads\n" + 
                    "Please choose a cmd (0-4): ");
                    command = key_scan.nextInt();
                    valid = true;
                }
                catch (InputMismatchException err) {
                    System.out.println("Invalid cmd.");
                    key_scan.next();
                }
            }
            switch (command) {
                case EXIT:
                    key_scan.close();
                    System.exit(0);
                    break;
                case ADD_LEAD:
                    Lead new_lead = new Lead();
                    leads.add(new_lead);
                    break;
                case ADD_USER:
                    User new_user = new User();
                    users.add(new_user);
                    break;
                case ASSIGN:
                    Assign(leads, users);
                    break;
                case DISPLAY:
                    DisplayLeads(leads, users);
                    break;
                default:
                    System.out.println("Invalid Cmd.");
                    break;
            }
        }
    }
    /**
     * Function:
     * Assign, This function is the way to attach users to leads will loop through leads if 
     * number of users > leads
     * @param leads A list of leads in an ArrayList object
     * @param users A list of users in an ArrayList object
     */
    private void Assign(ArrayList<Lead> leads, ArrayList<User> users)
    {
        int numberOfLeads = leads.size();
        int leadNumber = 0;
        
        for (User user : users)
        {
            if (user.getOnline())
            {
                user.AssignUserTo(leadNumber);
                leadNumber++;
                if (leadNumber > numberOfLeads) { leadNumber = 0; }
            }
        }
    }
    /**
     * Function:
     * DisplayLeads, this function pretty prints the information for all the leads in the lead
     * list and if any user is associated to that lead
     * @param leads
     * @param users
     */
    private static void DisplayLeads(ArrayList<Lead> leads, ArrayList<User> users)
    {
        System.out.format("%-28s%-18s%-28s%-28s", "Name", "Country", "Email", "Assigned User\n" +
                            "---------------------------------------------------------------------------------------------------------------------------\n");
        for (Lead lead : leads)
        {
            int currentLead = leads.indexOf(lead);
            System.out.format("%-28s%-18s%-28s", lead.getName(), lead.getLocation(), lead.getEmail());
            for (User user : users)
            {
                for (int assignedLead : user.m_leadAssignments)
                    if (assignedLead == currentLead) 
                    {
                        System.out.print(user.getName() + "\t");
                    }
            }
            System.out.print("\n");
        }
    }
}
