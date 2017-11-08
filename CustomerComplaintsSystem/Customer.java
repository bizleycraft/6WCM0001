public class Customer extends Person
{
    /* The customer's address */
    private String address;
    /* The customer's email */
    private String email;
    /* The customer's phone number */
    private String phone;
    
    /*
     * i: The customer's id
     * n: The customer's name
     * a: The customer's physical address
     * e: The customer's email address
     * p: The customer's phone number
     */
    public Customer(int i, String n, String a, String e, String p)
    {
        super(i,n);
        address = a;
        email = e;
        phone = p;
    }
    @Override
    public String toString()
    {
        String s = "CUSTOMER NAME: " + getName();
        s = s + "\nCUSTOMER ADDRESS: " + address;
        s = s + "\nCUSTOMER EMAIL: " + email;
        s = s + "\nCUSTOMER PHONE NO: " + phone;
        return s;
    }
}
