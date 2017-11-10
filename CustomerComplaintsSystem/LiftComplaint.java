/**
 * Represents a lift complaint
 * 
 * (Task 4/Implementing an inheritance tree)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class LiftComplaint extends Complaint
{
    /* The lift being complained about */
    private String lift;
    
    /* The floor that the lift is on */
    private int floor;
    
    /**Initialises the complaint
     * 
     * (Task 4/Implementing an inheritance tree)
     * 
     * @param customer The customer making the submission
     * @param date The date of the submission
     * @param content The main content of the submission
     * @param lift The lift being complained about
     * @param floor The floor that the lift is presently on
     */
    public LiftComplaint(Customer customer, Date date, String content, String lift, int floor)
    {
        super(customer,date,content);
        this.lift = lift;
        this.floor = floor;
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
        String s = "LIFT COMPLAINT";
        s = s + "\n" + getCustomer().toString();
        s = s + "\nNATURE OF COMPLAINT: " + getContent();
        s = s + "\nLIFT: " + lift;
        s = s + "\nFLOOR: " + floor;
        s = s + "\nDATE OF COMPLAINT: " + getDate().toString();
        
        /* Returns the details of this object */
        return s;
    }
}