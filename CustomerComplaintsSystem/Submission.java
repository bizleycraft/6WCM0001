public class Submission implements Comparable<Submission>, Identifiable
{
    /* The submission's id */
    private int submissionID;
    /* The customer */
    private Customer customer;
    /* The date of submission */
    private Date date;
    /* The main content of the comment or complaint */
    private String content;

    /*
     * s: The submission's ID
     * c: The customer
     * d: The date of the submission
     * m: The main content
     */
    public Submission(int s, Customer c, Date d, String m)
    {
        submissionID = s;
        customer = c;
        date = d;
        content = m;
    }
    public int getID(){return submissionID;}
    public Date getDate(){return date;}
    public int compareTo(Submission s){return date.compareTo(s.getDate());}
    public Customer getCustomer(){return customer;}
    public String getContent(){return content;}
    @Override
    public String toString()
    {
        String s = "COMMENT";
        s = s + "\n" + customer.toString();
        s = s + "\nCONTENT: " + content;
        s = s + "\nDATE OF COMMENT: " + date.toString();
        return s;
    }
}