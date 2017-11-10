/**
 * Represents a member of staff
 * 
 * (Task 4/Implementing an inheritance tree)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class Staff extends Person
{
    /* The staff member's department */
    private String department;
    
    /* The staff member's role */
    private String role;
    
    /**Initialises the member of staff
     * 
     * (Task 4/Implementing an inheritance tree)
     * 
     * @param name The staff member's name
     * @param department The staff member's department
     * @param role The staff member's role
     */
    public Staff(String name, String department, String role)
    {
        /* Assigns the local variables to the instance variables */
        super(name);
        this.department = department;
        this.role = role;
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
        String s = "STAFF " + super.toString();
        s = s + "\nDEPARTMENT: " + department;
        s = s + "\nROLE: " + role;
        
        /* Returns the details of this object */
        return s;
    }
}
