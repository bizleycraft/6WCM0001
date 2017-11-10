import java.util.*;

/**
 * Handles IDs
 * 
 * (Task 2/Implementing the interface/Providing unique ids)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class IDSystem
{
    /* The total number of IDs created by this id system so far */
    private int numOfIDs = 0;
    
    /**Initialises the Customer Complaints System
     * 
     * (Task 2/Implementing the interface/Providing unique ids)
     * 
     * @return A unique id
     */
    public int newID()
    {
        /* Adds 1 to the total number of IDs and return it */
        return ++numOfIDs;
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
        return "NUMBER OF IDS: " + numOfIDs;
    }
}