/**
 * Testing CCSImplementation for Tasks 1-4
 * 
 * @author Joshua Bizley
 * @version November 29th, 2017
 */
public class Test
{
    /* The first customer */
    private static String customerName = "Joshua Bizley";
    private static String address = "St Aldridge, London";
    private static String email = "joshua@gmail.com";
    private static String phone = "07979797979";
    
    /* The second customer */
    private static String customerName2 = "Jane Austen";
    private static String address2 = "Rosewood Cottage, Kent";
    private static String email2 = "janey@gmail.com";
    private static String phone2 = "02323232323";
    
    /* The comment */
    private static String comment = "Staff are friendly.";
    private static Date date = new Date(1,1,2017);
    
    /* The general complaint */
    private static String generalComplaint = "Room smells.";
    private static Date date2 = new Date(2,2,2017);
    
    /* The lift complaint */
    private static String liftComplaint = "Lift is stuck.";
    private static String lift = "West Lifts";
    private static int floor = 7;
    private static Date date3 = new Date(3,3,2017);
    
    /* The staff complaint */
    private static String staffComplaint = "She knocks too loudly.";
    private static Date date4 = new Date(4,4,2017);
    
    /* The staff member being complained about */
    private static String staffName = "Kiamara Marpael";
    private static String department = "Catering";
    private static String role = "Waiter";
    
    /* The resolver */
    private static String staffName2 = "Oberyn Martell";
    private static String department2 = "Retail";
    private static String role2 = "Clerk";
    private static Date date5 = new Date(8,8,2017);
    
    public static void main(String[] args)
    {
        System.out.println("Booting up CCS...");
        System.out.println("This program should end with TEST COMPLETE.");
        System.out.println("Otherwise, something is broken.");
        System.out.println("\nCompare the results to the test plan.");
        System.out.println("You may want to edit the static variables" +
            "in the test class to make them more intuitive.");
        CCSImplementation ccs = new CCSImplementation();
        
        System.out.println("\nTesting ID System\n");
        
        for(int i = 0; i < 5; i++)
        {
            System.out.print("Creating new customer ID: ");
            System.out.println(ccs.getNewCustomerId());
        }
        
        for(int i = 0; i < 5; i++)
        {
            System.out.print("Creating new staff ID: ");
            System.out.println(ccs.getNewStaffId());
        }
        
        for(int i = 0; i < 5; i++)
        {
            System.out.print("Creating new submission ID: ");
            System.out.println(ccs.getNewSubmissionId());
        }
        
        System.out.println("\nTesting System Additions");
        
        System.out.println("\nCreating new customer.");
        int customerID = ccs.getNewCustomerId();
        ccs.addCustomer(customerID,customerName,address,email,phone);
        System.out.println("Printing toString() of that customer:\n");
        System.out.println(ccs.getCustomer(customerID).toString());
        
        System.out.println("\nCreating another new customer.");
        int customerID2 = ccs.getNewCustomerId();
        ccs.addCustomer(customerID2,customerName2,address2,email2,phone2);
        System.out.println("Printing toString() of that customer:\n");
        System.out.println(ccs.getCustomer(customerID2).toString());
        
        System.out.println("\nPrinting toString() of all customers...\n");
        for(Customer c: ccs.getCustomerList()){ System.out.println(c.toString() + "\n");}
        
        System.out.println("Removing the second customer.");
        ccs.removeCustomer(customerID2);
        System.out.println("\nPrinting toString() of all customers...\n");
        for(Customer c: ccs.getCustomerList()){ System.out.println(c.toString() + "\n");}

        System.out.println("Creating Comment.");
        int commentID = ccs.getNewSubmissionId();
        ccs.addComment(commentID,customerID,comment,date);
        System.out.println("Printing toString() of that submission:\n");
        System.out.println(ccs.getSubmission(commentID).toString());
        
        System.out.println("\nCreating general complaint.");
        int generalComplaintID = ccs.getNewSubmissionId();
        ccs.addGeneralComplaint(generalComplaintID,customerID,generalComplaint,date2);
        System.out.println("Printing toString() of that submission:\n");
        System.out.println(ccs.getSubmission(generalComplaintID).toString());
        
        System.out.println("\nCreating Lift Complaint.");
        int liftComplaintID = ccs.getNewSubmissionId();
        ccs.addLiftComplaint(liftComplaintID,customerID,liftComplaint,lift,floor,date3);
        System.out.println("Printing toString() of that submission:\n");
        System.out.println(ccs.getSubmission(liftComplaintID).toString());
        
        System.out.println("\nCreating staff.");
        int staffID = ccs.getNewStaffId();
        ccs.addStaff(staffID,staffName,role,department);
        System.out.println("Printing toString() of that member of staff:\n");
        System.out.println(ccs.getStaff(staffID).toString());
        
        System.out.println("\nCreating Staff Complaint.");
        int staffComplaintID = ccs.getNewSubmissionId();
        ccs.addStaffComplaint(staffComplaintID,customerID,staffComplaint,staffID,date4);
        System.out.println("Printing toString() of that submission:\n");
        System.out.println(ccs.getSubmission(staffComplaintID).toString());
        
        System.out.println("\nCreating another staff.");
        int staffID2 = ccs.getNewStaffId();
        ccs.addStaff(staffID2,staffName2,role2,department2);
        System.out.println("Printing toString() of that member of staff:\n");
        System.out.println(ccs.getStaff(staffID2).toString());
        
        System.out.println("\nPrinting toString() of all staff...\n");
        for(Staff s: ccs.getStaffList()){ System.out.println(s.toString() + "\n");}
        
        System.out.print("Number of submissions (should be 4): ");
        System.out.println(ccs.getSubmissionList().size());
        System.out.print("\nNumber of new complaints (should be 3): ");
        System.out.println(ccs.getNewComplaintsList().size());
        System.out.println("\nPrinting toString() of all submissions...\n");
        
        for(Submission s: ccs.getSubmissionList()){ System.out.println(s.toString() + "\n");}
       
        System.out.println("Make sure you see all 4 submissions.");
        
        System.out.println("\nTesting Complaint Resolution and Archiving\n");
        
        System.out.println("Assigning staff member 2 to resolve the 3 complaints.");
        
        ccs.assignResolver(generalComplaintID,staffID2,date5);
        
        System.out.print("\nNumber of new complaints (should be 2): ");
        System.out.println(ccs.getNewComplaintsList().size());
        
        ccs.assignResolver(liftComplaintID,staffID2,date5);
        
        System.out.print("\nNumber of new complaints (should be 1): ");
        System.out.println(ccs.getNewComplaintsList().size());
        
        ccs.assignResolver(staffComplaintID,staffID2,date5);
        
        System.out.print("\nNumber of new complaints (should be 0): ");
        System.out.println(ccs.getNewComplaintsList().size());
        
        System.out.print("\nNumber of submissions (should be 4): ");
        System.out.println(ccs.getSubmissionList().size());
        
        System.out.println("\nArchiving submissions:\n");
        ccs.archiveSubmissions();
        
        System.out.print("\nNumber of submissions (should be 3): ");
        System.out.println(ccs.getSubmissionList().size() + "\n");
        
        System.out.println("Recording an action for the lift complaint.");
        ccs.recordAction(liftComplaintID, "Fixed the elevator", new Date(6,4,2017));
        
        System.out.println("\nRecording an action for the staff complaint.");
        ccs.recordAction(staffComplaintID, "Asked Kiamara to knock more quietly", new Date(6,4,2017));
        
        System.out.println("\nRecording another action for the staff complaint.");
        ccs.recordAction(staffComplaintID, "Informed the customer that Kiamara would be knocking more quietly", new Date(6,4,2017));
        
        System.out.println("\nPrinting out list of actions for the general complaint: \n");
        for(Action a: ccs.getActionsForComplaint(generalComplaintID)){ System.out.println(a.toString() + "\n");}
        
        System.out.println("Printing out list of actions for the lift complaint: \n");
        for(Action a: ccs.getActionsForComplaint(liftComplaintID)){ System.out.println(a.toString() + "\n");}
        
        System.out.println("Printing list of actions for the staff complaint: \n");
        for(Action a: ccs.getActionsForComplaint(staffComplaintID)){ System.out.println(a.toString() + "\n");}
        
        System.out.println("Removing the first staff member.");
        ccs.removeStaff(staffID);
        
        System.out.println("\nValidating that member of staff in a complaint about them:\n");
        ccs.validateStaff(staffComplaintID);
        
        System.out.println("\nRecording the lift complaint as resolved.");
        ccs.recordComplaintResolved(liftComplaintID);
        
        System.out.println("\nArchiving submissions.\n");
        ccs.archiveSubmissions();
        
        System.out.print("\nCounting number of submissions (should be 2): ");
        System.out.println(ccs.getSubmissionList().size());
        
        System.out.println("\nRecording the staff complaint as resolved.");
        ccs.recordComplaintResolved(staffComplaintID);
        
        System.out.println("\nArchiving submissions.\n");
        ccs.archiveSubmissions();
        
        System.out.print("\nCounting number of submissions (should be 1): ");
        System.out.println(ccs.getSubmissionList().size());
        
        System.out.println("\nRemoving the first customer.");
        ccs.removeCustomer(customerID);
        
        System.out.println("\nValidating that customer in one of their complaints:\n");
        ccs.validateCustomer(generalComplaintID);
        
        System.out.println("\nTEST COMPLETE");
    }
}