import java.util.*;

/**
 * Class Session describes sessions organized by a swimming centre.
 * 
 * @author 
 * @version 
 */
public class Session
{
    private String SessionCode;
    private String description;
    private double fee;
    public  Date startDate;
    private double totalFees;
    private ArrayList<Member> members;
     
    public Session (String SessionCode, String description, 
                    double fee, Date date)
    {
        startDate = date;
        this.SessionCode = SessionCode;
        this.description = description;
        this.fee = fee;
        totalFees = 0;
        members = new ArrayList<Member>();
    }
    
    /* 
     * Signs a member up to the session
     * m: member to sign up
     */
    public void signUp(Member m)
    {
        /* Add the Member to the members ArrayList */
        members.add(m);
        /* Update the total fees paid by members */
        totalFees += fee;
    }
    
    /* 
     * Prints the list of signed up members
     */
    public void showMembersOnSession()
    {
        /* 
         * For each member in the members ArrayList,
         * Print their details
         */
        for(Member m : members){System.out.println(m.toString());}
    }
    
    public String getSessionCode () {return SessionCode;}

    public double getFee () {return fee;}

    public Date getStartDate () {return startDate;}
       
    public String toString()
    {              
        String separator = ", ";
        return SessionCode + separator + description + separator + 
                            "\nDate: " + startDate.toString() + 
                            "\nFee: " + fee + " Total fees: " + totalFees;
    }            
}
