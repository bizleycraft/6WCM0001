/**
 * Checks that the customer still exists on the system
 * 
 * (Task 7/Exceptions)
 * 
 * @author Joshua Bizley
 * @version November 29th, 2017
 */
public class AbsentFromSystemException extends RuntimeException 
{
    public AbsentFromSystemException(String message) 
    {
        super(message);
    }
}