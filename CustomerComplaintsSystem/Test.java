/**
 * Testing CCSImplementation for Tasks 1-4
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class Test
{
    /* The customer */
    private static String customerName = "Joshua Bizley";
    private static String address = "St Aldridge, London";
    private static String email = "joshua@gmail.com";
    private static String phone = "07979797979";
    
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
        System.out.println("\nBooting up CCS...");
        System.out.println("This program should end with TEST COMPLETE.");
        System.out.println("Otherwise, something is broken.");
        System.out.println("\nCompare the results to the static variables in the test class.");
        System.out.println("You may want to edit them to make them more intuitive.");
        CCSImplementation ccs = new CCSImplementation();
        
        System.out.println("\nCreating new customer.");
        int customerID = ccs.getNewCustomerId();
        ccs.addCustomer(customerID,customerName,address,email,phone);
        System.out.println("Printing toString() of that customer:\n");
        System.out.println(ccs.getCustomer(customerID).toString());
        
        System.out.println("\nCreating Comment.");
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
        
        System.out.println("Number of submissions (should be 4)");
        System.out.println(ccs.getSubmissionList().size());
        System.out.println("\nNumber of new complaints (should be 3)");
        System.out.println(ccs.getNewComplaintsList().size());
        System.out.println("\nPrinting toString() of all submissions...\n");
        
        for(Submission s: ccs.getSubmissionList()){ System.out.println(s.toString() + "\n");}
       
        System.out.println("Make sure you see all 4 submissions.\n");
        
        System.out.println("Assigning staff member 2 to resolve the 3 complaints.");
        
        ccs.assignResolver(generalComplaintID,staffID2,date5);
        ccs.assignResolver(liftComplaintID,staffID2,date5);
        ccs.assignResolver(staffComplaintID,staffID2,date5);
        
        System.out.println("\nNumber of new complaints (should be 0)");
        System.out.println(ccs.getNewComplaintsList().size());
        
        
        
        
        
        
        
        
        System.out.println("\nTEST COMPLETE (will be updated)");
    }
}