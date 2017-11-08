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
    public void addComment(int submissionId, int customerId, String comment, Date date)
    {
        submissions.add(new Submission(submissionId, getCustomer(customerId), date, comment));
    }
    public void addCustomer(int customerId, String name, String address, String email, String phone)
    {
        customers.add(new Customer(customerId, name, address, email, phone));
    }
    public void addGeneralComplaint(int submissionId, int customerId, String description, Date date)
    {
        submissions.add(new Complaint(submissionId, getCustomer(customerId), date, description));
    }
    public void addLiftComplaint(int submissionId, int customerId, String description, String lift, int floor, Date date)
    {
        submissions.add(new LiftComplaint(submissionId, getCustomer(customerId), date, description, lift, floor));
    }
    public void addStaff(int staffId, String name, String role, String department)
    {
        staff.add(new Staff(staffId, name, department, role));
    }
    public void addStaffComplaint(int submissionId, int customerId, String description, int staffId, Date date)
    {
        submissions.add(new StaffComplaint(submissionId, getCustomer(customerId), date, description, getStaff(staffId)));
    }
    public void archiveSubmissions()
    {
        for(int i = 0; i < submissions.size(); i++)
        {
            Submission s = submissions.get(i);
            if(s.getClass().toString() == "Complaint")
            {
                Complaint c = (Complaint) s;
                if(c.getResolved())
                {
                    submissions.remove(i--);
                    System.out.println(s.toString());
                }
            }
            else
            {
                submissions.remove(i--);
                System.out.println(s.toString());
            }
        }
    }
    public void assignResolver(int complaintId, int staffId, Date deadLine)
    {
        Complaint c = (Complaint) getSubmission(complaintId);
        c.assignResolver(staffId,deadLine);
    }
    public List<Action> getActionsForComplaint(int complaintId)
    {
        Complaint c = (Complaint) getSubmission(complaintId);
        return c.getActions();
    }
    public Customer getCustomer(int customerId)
    {
        for(Customer c : customers)
        {
            if(c.getID() == customerId){return c;}
        }
        return null;
    }
    public List<Customer> getCustomerList(){return customers;}
    public int getNewCustomerId(){return customerIDSystem.newID();}
    public int getNewStaffId(){return staffIDSystem.newID();}
    public int getNewSubmissionId(){return submissionIDSystem.newID();}
    public Staff getStaff(int staffId)
    {
        for(Staff s : staff)
        {
            if(s.getID() == staffId){return s;}
        }
        return null;
    }
    public List<Staff> getStaffList(){return staff;}
    public Submission getSubmission(int submissionId)
    {
        for(Submission s : submissions)
        {
            if(s.getID() == submissionId){return s;}
        }
        return null;
    }
    public List<Submission> getSubmissionList(){return submissions;}
    public void recordAction(int complaintId, String actionTaken, Date date)
    {
        Complaint c = (Complaint) getSubmission(complaintId);
        c.recordAction(complaintId, actionTaken, date);
    }
    public void recordComplaintResolved(int complaintId)
    {
        Complaint c = (Complaint) getSubmission(complaintId);
        c.resolve();
    }
    public void removeCustomer(int customerId)
    {
        for(int i = 0; i < customers.size(); i++)
        {
            if(customers.get(i).getID() == customerId)
            {
                customers.remove(i); 
                break;
            }
        }
    }
    public void listNewComplaints()
    {
        TreeSet<Complaint> t = new TreeSet<Complaint>();
        for(Submission s : submissions)
        {
            if(s.getClass().toString() == "Complaint")
            {
                Complaint c = (Complaint) s;
                if(!c.getResolved())
                {
                    t.add(c);
                }
            }
        }
        for(Complaint c : t){System.out.println(c.toString());}
    }
}
