public class LiftComplaint extends Complaint
{
    /* The lift being complained about */
    private String lift;
    /* The floor that the lift is on */
    private int floor;
    
    /*
     * s: The submission's ID
     * i: The contributor's ID
     * d: The date of submission
     * c: The complaint
     * l: The lift
     * f: The floor
     */
    public LiftComplaint(int s, Customer c, Date d, String m, String l, int f)
    {
        super(s,c,d,m);
        lift = l;
        floor = f;
    }
    @Override
    public String toString()
    {
        String s = "LIFT COMPLAINT";
        s = s + "\n" + getCustomer().toString();
        s = s + "\nNATURE OF COMPLAINT: " + getContent();
        s = s + "\nLIFT: " + lift;
        s = s + "\nFLOOR: " + floor;
        s = s + "\nDATE OF COMPLAINT: " + getDate().toString();
        return s;
    }
}