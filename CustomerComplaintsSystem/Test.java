public class Test
{
    private static String customerName = "Joshua Bizley";
    private static String staffName = "Kiamara Marpael";
    private static String address = "St Aldridge, London";
    private static String email = "joshua@gmail.com";
    private static String phone = "07979797979";
    private static String generalComplaint = "Room smells.";
    private static String liftComplaint = "Lift is stuck.";
    private static Date date = new Date(3,3,2017);
    private static String lift = "West Lifts";
    private static int floor = 7;
    private static String comment = "Staff are friendly.";
    private static String department = "Catering";
    private static String role = "Waiter";
    private static String staffComplaint = "She knocks too loudly.";
    
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
        System.out.println("\nCreating general complaint.");
        int generalComplaintID = ccs.getNewSubmissionId();
        ccs.addGeneralComplaint(generalComplaintID,customerID,generalComplaint,date);
        System.out.println("Printing toString() of that submission:\n");
        System.out.println(ccs.getSubmission(generalComplaintID).toString());
        System.out.println("\nCreating Lift Complaint.");
        int liftComplaintID = ccs.getNewSubmissionId();
        ccs.addLiftComplaint(liftComplaintID,customerID,liftComplaint,lift,floor,date);
        System.out.println("Printing toString() of that submission:\n");
        System.out.println(ccs.getSubmission(liftComplaintID).toString());
        System.out.println("\nCreating Comment.");
        int commentID = ccs.getNewSubmissionId();
        ccs.addComment(commentID,customerID,comment,date);
        System.out.println("Printing toString() of that submission:\n");
        System.out.println(ccs.getSubmission(commentID).toString());
        System.out.println("\nCreating staff.");
        int staffID = ccs.getNewStaffId();
        ccs.addStaff(staffID,staffName,role,department);
        System.out.println("Printing toString() of that member of staff:\n");
        System.out.println(ccs.getStaff(staffID).toString());
        System.out.println("\nCreating Staff Complaint.");
        int staffComplaintID = ccs.getNewSubmissionId();
        ccs.addStaffComplaint(staffComplaintID,customerID,staffComplaint,staffID,date);
        System.out.println("Printing toString() of that submission:\n");
        System.out.println(ccs.getSubmission(staffComplaintID).toString());
        System.out.println("\nPrinting toString() of submission list...");
        System.out.println("Make sure this contains all of the above details:\n");
        System.out.println(ccs.getSubmissionList().toString());
        System.out.println("\nTEST COMPLETE (will be updated)");
    }
}