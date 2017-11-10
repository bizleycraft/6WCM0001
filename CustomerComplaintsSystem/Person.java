/**
 * Represents a person
 * 
 * (Task 4/Implementing an inheritance tree)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class Person
{
    /* The person's name */
    private String name;
    
    /**Initialises the Person
     * 
     * (Task 4/Implementing an inheritance tree)
     * 
     * @param name The person's name
     */
    public Person(String name)
    {
        /* Assigns the local variable to the instance variable */
        this.name = name;
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
        /* Returns the details of this object */
        return "NAME: " + name;
    }
}