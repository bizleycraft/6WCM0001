import java.util.*;

/**
 * An amateur swimming club.
 * 
 * @author Mick Wood 
 * @version November 2004
 */

public class Centre
{
    private String name;
    
    private HashMap sessions;
    
    public Centre(String name)
    {
        this.name = name;
        sessions = new HashMap();
    }
    
    /* 
     * Adds a session to the sessions HashMap
     * s: session to add
     */
    public void addSession(Session s)
    {
        /*
         * Adds the Session to the sessions Hashmap,
         * Identified by its sessionCode field
         */
        sessions.put(s.getSessionCode(),s);
    }
    
    /* 
     * Removes a session from the sessions HashMap
     * sess: session to cancel
     * 
     * For the record, I was forced to use that 
     * weird variable by the instructions
     * 
     * I personally prefer single letters for 
     * local variables
     */
    public void cancelSession(Session sess)
    {
        /*
         * Removes the Session from the sessions Hashmap,
         * Identified by its sessionCode field
         */
        sessions.remove(sess.getSessionCode());
    }
    
    /* 
     * Searches for a session by date
     * d: date to search for
     */
    public void searchSessionsByDate(Date d)
    {
        /* For every session in the hashmap */
        for(Object o : sessions.values())
        {
            /* Downcast the Object to Student */
            Session s = (Session) o;
            /* If the date matches the one searched for, print it */
            if(s.getStartDate().equals(d)){System.out.println(s.toString());}
        }
    }
}