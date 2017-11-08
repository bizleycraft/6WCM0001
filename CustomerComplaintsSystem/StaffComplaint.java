public class StaffComplaint extends Complaint
{
    /* The relevant employee */
    private Staff staff;
    
    /*
     * s: The submission's ID
     * c: The customer
     * d: The date of submission
     * m: The main content
     * e: The relevant employee
     */
    public StaffComplaint(int s, Customer c, Date d, String m, Staff e)
    {
        super(s,c,d,m);
        staff = e;
    }
    @Override
    public String toString()
    {
        String s = "STAFF COMPLAINT";
        s = s + "\n" + getCustomer().toString();
        s = s + "\nNATURE OF COMPLAINT: " + getContent();
        s = s + "\n" + staff.toString();
        s = s + "\nDATE OF COMPLAINT: " + getDate().toString();
        return s;
    }
}