/**
 * Represents a general submission/comment
 * 
 * (Task 4/Implementing an inheritance tree)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class Submission implements Comparable<Submission>
{
    /* The submission's id */
    private int submissionID;
    
    /* The customer */
    private Customer customer;
    
    /* The date of submission */
    private Date date;
    
    /* The main content of the comment or complaint */
    private String content;

    /**Initialises the submission
     * 
     * (Task 4/Implementing an inheritance tree)
     * 
     * @param customer The customer making the submission
     * @param date The date of the submission
     * @param content The main content of the submission
     */
    public Submission(Customer customer, Date date, String content)
    {
        /* Assigns the local variables to the instance variables */
        this.customer = customer;
        this.date = date;
        this.content = content;
    }
    
    /**Returns the date of this submission so that the children
     * of this class can format their toString() uniquely
     * 
     * (Introduction/Implementing toString in all classes)
     * 
     * @return The date of this submission
     */
    public Date getDate(){return date;}
    
    /**Returns the customer of this submission so that the children
     * of this class can format their toString() uniquely
     * 
     * (Introduction/Implementing toString in all classes)
     * 
     * @return The customer of this submission
     */
    public Customer getCustomer(){return customer;}
    
    /**Returns the main content of this submission so that the children
     * of this class can format their toString() uniquely
     * 
     * (Introduction/Implementing toString in all classes)
     * 
     * @return The main content of this submission
     */
    public String getContent(){return content;}
    
    /**Implements Comparable so that this class can be
     * ordered by Date
     * 
     * (Task 2/Implementing the missing method to 
     * list new complaints)
     * 
     * @return The customer of this submission
     */
    public int compareTo(Submission s)
    {
        /* Compares the dates of the two submissions */
        return date.compareTo(s.getDate());
    }
    
    /**Confirms that this submission is archivable, meaning
     * that it is not an unresolved complaint
     * 
     * (Task 2/Implementing the interface/Archiving submissions)
     * 
     * @return True (Overridden by Complaints)
     */
    public boolean isArchivable()
    {
        /* This method always returns true, but is overridden for 
         * Complaints 
         */
        return true;
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
        String s = "COMMENT";
        s = s + "\n" + customer.toString();
        s = s + "\nCONTENT: " + content;
        s = s + "\nDATE OF COMMENT: " + date.toString();
        
        /* Returns the details of this object */
        return s;
    }
}