import java.util.*;

/**
 * Represents a staff complaint
 * 
 * (Task 4/Implementing an inheritance tree)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class StaffComplaint extends Complaint
{
    /* The relevant employee */
    private Staff staff;
    
    /**Initialises the complaint
     * 
     * (Task 4/Implementing an inheritance tree)
     * 
     * @param customer The customer making the submission
     * @param date The date of the submission
     * @param content The main content of the submission
     * @param staff The staff member being complained about
     */
    public StaffComplaint(Customer customer, Date date, String content, Staff staff)
    {
        /* Assigns the local variables to the instance variables */
        super(customer,date,content);
        this.staff = staff;
    }
    
    /**Checks that the staff still exists on the system
     * 
     * (Task 7/Exceptions)
     */
    public void validateStaff(Map<Integer,Staff> staffs) throws AbsentFromSystemException
    {
        //If the system contains the customer
        if(!staffs.containsValue(staff))
        {
            // Throws an exception and prints out the customer's details
            throw new AbsentFromSystemException(staff.toString());
        }
    }
    
    /**Returns String description of this object
     * 
     * (Introduction/Implementing toString in all classes)
     * 
     * @return The details of this object
     */
    @Override
    public String toString()
    {
        /* Concatenates the details of the object */
        String s = "STAFF COMPLAINT";
        s = s + "\n" + getCustomer().toString();
        s = s + "\nNATURE OF COMPLAINT: " + getContent();
        s = s + "\n" + staff.toString();
        s = s + "\nDATE OF COMPLAINT: " + getDate().toString();
        
        /* Returns the details of this object */
        return s;
    }
}