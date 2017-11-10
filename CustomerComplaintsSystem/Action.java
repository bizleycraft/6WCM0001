/**
 * Represents actions taken by resolvers on complaints
 * 
 * (Task 2/Implementing the interface/Recording actions)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class Action
{
    /* A description of the action */
    private String description;
    
    /* The date the action was taken */
    private Date date;
    
    /**Initialises the Action
     * 
     * (Task 2/Implementing the interface/Recording actions)
     * 
     * @param description A description of the action
     * @param date The date
     */
    public Action(String description, Date date)
    {
        /* Assigns the local variables to the instance variables */
        this.description = description;
        this.date = date;
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
        String s = "ACTION";
        s = s + "\nDESCRIPTION OF ACTION: " + description;
        s = s + "\nDATE OF ACTION: " + date;
        
        /* Returns the details of this object */
        return s;
    }
}