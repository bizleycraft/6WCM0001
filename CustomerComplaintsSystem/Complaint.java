import java.util.*;

public class Complaint extends Submission
{
    /* The list of actions taken on this complaint */
    private List<Action> actions;
    /* The member of staff assigned to this complaint */
    private int resolverID;
    /* The deadline for resolving this complaint */
    private Date deadline;
    /* Whether the complaint has been resolved yet */
    private boolean resolved;
    /*
     * s: The submission's ID
     * c: The customer
     * d: The date of submission
     * m: The main content
     */
    public Complaint(int s, Customer c,Date d,String m)
    {
        super(s,c,d,m);
        actions = new ArrayList<Action>();
        /* 0 is an invalid id number, represents no resolver assigned */
        resolverID = 0;
        /* The deadline is null until a resolver is assigned */
        deadline = null;
        resolved = false;
    }
    /* Assigns a resolver and sets the deadline */
    public void assignResolver(int r, Date d)
    {
        resolverID = r;
        deadline = d;
    }
    public List<Action> getActions(){return actions;}
    public boolean getResolved(){return resolved;}
    public void recordAction(int id, String description, Date date){actions.add(new Action(id, description, date));}
    public void resolve()
    {
        resolved = true;
        deadline = null;
    }
    @Override
    public String toString()
    {
        String s = "GENERAL COMPLAINT";
        s = s + "\n" + getCustomer().toString();
        s = s + "\nNATURE OF COMPLAINT: " + getContent();
        s = s + "\nDATE OF COMPLAINT: " + getDate().toString();
        return s;
    }
}