import java.util.*;

public class CCSImplementation implements CCS
{
    /* The customer id system */
    private IDSystem customerIDSystem;
    /* The staff id system */
    private IDSystem staffIDSystem;
    /* The submission id system */
    private IDSystem submissionIDSystem;
    /* The list of customers */
    private List<Customer> customers;
    /* The list of staff */
    private List<Staff> staff;
    /* The list of submissions */
    private List<Submission> submissions;
    
    public CCSImplementation()
    {
        submissions = new ArrayList<Submission>();
        staff = new ArrayList<Staff>();
        customers = new ArrayList<Customer>();
        customerIDSystem = new IDSystem();
        staffIDSystem = new IDSystem();
        submissionIDSystem = new IDSystem();
    }
    public void addComment(int submissionID, int customerID, String comment, Date date)
    {
        submissions.add(new Submission(submissionID, getCustomer(customerID), date, comment));
    }
    public void addCustomer(int customerID, String name, String address, String email, String phone)
    {
        customers.add(new Customer(customerID, name, address, email, phone));
    }
    public void addGeneralComplaint(int submissionID, int customerID, String description, Date date)
    {
        submissions.add(new Complaint(submissionID, getCustomer(customerID), date, description));
    }
    public void addLiftComplaint(int submissionID, int customerID, String description, String lift, int floor, Date date)
    {
        submissions.add(new LiftComplaint(submissionID, getCustomer(customerID), date, description, lift, floor));
    }
    public void addStaff(int staffID, String name, String role, String department)
    {
        staff.add(new Staff(staffID, name, department, role));
    }
    public void addStaffComplaint(int submissionID, int customerID, String description, int staffID, Date date)
    {
        submissions.add(new StaffComplaint(submissionID, getCustomer(customerID), date, description, getStaff(staffID)));
    }
    public void archiveSubmissions()
    {
        for(int i = 0; i < submissions.size(); i++)
        {
            Submission s = submissions.get(i);
            if (s.isArchivable())
            {
                submissions.remove(i--);
                System.out.println(s.toString());
            }
        }
    }
    public void assignResolver(int complaintID, int staffID, Date deadLine)
    {
        Complaint c = (Complaint) getSubmission(complaintID);
        c.assignResolver(staffID,deadLine);
    }
    public List<Action> getActionsForComplaint(int complaintID)
    {
        Complaint c = (Complaint) getSubmission(complaintID);
        return c.getActions();
    }
    public Customer getCustomer(int customerID)
    {
        return IDSystem.findWithID(customers, customerID);
    }
    public List<Customer> getCustomerList(){return customers;}
    public int getNewCustomerId(){return customerIDSystem.newID();}
    public int getNewStaffId(){return staffIDSystem.newID();}
    public int getNewSubmissionId(){return submissionIDSystem.newID();}
    public Staff getStaff(int staffID)
    {
        return IDSystem.findWithID(staff, staffID);
    }
    public List<Staff> getStaffList(){return staff;}
    public Submission getSubmission(int submissionID)
    {
        return IDSystem.findWithID(submissions, submissionID);
    }
    
    public List<Submission> getSubmissionList(){return submissions;}
    public void recordAction(int complaintID, String actionTaken, Date date)
    {
        Complaint c = (Complaint) getSubmission(complaintID);
        c.recordAction(complaintID, actionTaken, date);
    }
    public void recordComplaintResolved(int complaintID)
    {
        Complaint c = (Complaint) getSubmission(complaintID);
        c.resolve();
    }
    public void removeCustomer(int customerID)
    {
        IDSystem.removeWithID(customers, customerID);
    }
    public void listNewComplaints()
    {
        TreeSet<Submission> t = new TreeSet<Submission>();
        for(Submission s : submissions)
        {
            if(!s.isArchivable())
            {
                t.add(s);
            }
        }
        for(Submission c : t){System.out.println(c.toString());}
    }
}
