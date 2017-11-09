public class Staff extends Person
{
    /* The employee's department */
    private String department;
    /* The employee's role */
    private String role;
    
    /*
     * i: The employee's id
     * n: The employee's name
     * d: The employee's department
     * r: The employee's role
     */
    public Staff(int i, String n, String d, String r)
    {
        super(i,n);
        department = d;
        role = r;
    }
    @Override
    public String toString()
    {
        String s = "STAFF NAME: " + getName();
        s = s + "\nDEPARTMENT: " + department;
        s = s + "\nROLE: " + role;
        return s;
    }
}
