import java.util.*;

/**
 * Represents a general complaint
 * 
 * (Task 4/Implementing an inheritance tree)
 * 
 * @author Joshua Bizley
 * @version November 29th, 2017
 */
public class Complaint extends Submission
{
    /* The list of actions taken on this complaint */
    private List<Action> actions;
    
    /* The member of staff assigned to this complaint */
    private Staff resolver;
    
    /* The deadline for resolving this complaint */
    private Date deadline;
    
    /* Whether the complaint has been resolved yet */
    private boolean resolved;
    
    /**Initialises the complaint
     * 
     * (Task 4/Implementing an inheritance tree)
     * 
     * @param customer The customer making the submission
     * @param date The date of the submission
     * @param content The main content of the submission
     */
    public Complaint(Customer customer,Date date,String content)
    {
        /* Assigns the local variables to the instance variables */
        super(customer,date,content);
        
        /* Initialises an empty ArrayList to hold a list of actions */
        actions = new ArrayList<Action>();
        
        /* There is no resolver until it is explicitly assigned */
        resolver = null;
        
        /* The deadline is null until a resolver is assigned */
        deadline = null;
        
        /* The complaint is initialised as unresolved */
        resolved = false;
    }
    
    /**Checks that the customer still exists on the system
     * 
     * (Task 7/Exceptions)
     */
    public void validateCustomer(Map<Integer,Customer> customers) throws AbsentFromSystemException
    {
        //If the system contains the customer
        if(!customers.containsValue(getCustomer()))
        {
            // Throws an exception and prints out the customer's details
            throw new AbsentFromSystemException(getCustomer().toString());
        }
    }
    
    /**Assigns a member of staff as resolver and sets a deadline
     * 
     * (Task 2/Implementing the interface/Assigning a resolver)
     * 
     * @param resolver The member of staff to resolve this complaint
     * @param deadline The deadline for resolution of this complaint
     */
    public void assignResolver(Staff resolver, Date deadline)
    {
        /* Assigns the local variables to the instance variables */
        this.resolver = resolver;
        this.deadline = deadline;
    }
    
    /**Returns this complaint's list of actions
     * 
     * (Task 2/Implementing the interface/Listing actions)
     * 
     * @return This complaint's list of actions
     */
    public List<Action> getActions(){return actions;}
    
    /**Returns whether this complaint is archivable,
     * which depends on whether it is resolved
     * 
     * (Task 2/Implementing the interface/Archiving submissions)
     * 
     * @return True (Overridden by Complaints)
     */
    @Override
    public boolean isArchivable()
    {
        /* If the complaint is resolved, it is archivable */
        return resolved;
    }
    
    /**Records an action in this complaint
     * 
     * (Task 2/Implementing the interface/Recording actions)
     * 
     * @param description A description of the action
     * @param date The date of the action
     */
    public void recordAction(String description, Date date)
    {
        /* Adds the action to the list of actions */
        actions.add(new Action(description, date));
    }
    
    /**Marks this complaint as resolved
     * 
     * (Task 2/Implementing the interface/Resolving complaints)
     */
    public void resolve()
    {
        /* The complaint is marked as resolved */
        resolved = true;
        
        /* The deadline no longer exists */
        deadline = null;
    }
    
    /**Returns the resolver of this complaint to check
     * whether this complaint is new
     * 
     * (Task 2/Implementing the missing method to 
     * list new complaints)
     * 
     * @return The resolver of this complaint
     */
    public Staff getResolver(){return resolver;}
    
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
        String s = "GENERAL COMPLAINT";
        s = s + "\n" + getCustomer().toString();
        s = s + "\nNATURE OF COMPLAINT: " + getContent();
        s = s + "\nDATE OF COMPLAINT: " + getDate().toString();
        
        /* Returns the details of this object */
        return s;
    }
}