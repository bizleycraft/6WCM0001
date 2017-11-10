/**
 * Represents a customer
 * 
 * (Task 4/Implementing an inheritance tree)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class Customer extends Person
{
    /* The customer's address */
    private String address;
    
    /* The customer's email */
    private String email;
    
    /* The customer's phone number */
    private String phone;
    
    /**Initialises the customer
     * 
     * (Task 4/Implementing an inheritance tree)
     * 
     * @param name The customer's name
     * @param address The customer's physical address
     * @param email The customer's email address
     * @param phone The customer's phone number
     */
    public Customer(String name, String address, String email, String phone)
    {
        /* Assigns the local variables to the instance variables */
        super(name);
        this.address = address;
        this.email = email;
        this.phone = phone;
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
        /* Concatenates the details of the object */
        String s = "CUSTOMER " + super.toString();
        s = s + "\nCUSTOMER ADDRESS: " + address;
        s = s + "\nCUSTOMER EMAIL: " + email;
        s = s + "\nCUSTOMER PHONE NO: " + phone;
        
        /* Returns the details of this object */
        return s;
    }
}
