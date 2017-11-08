/**
 * The Member class stores information about a member 
 * @author 
 * @version 
 */
public class Member                                
{
    // fields
    private int idNumber;                           
    private String name;  
    private char type;
 
    /**
    * Creates a Member with a unique id number and a name initialised from parameters
    * @param id it is the responsibility of the client to ensure that id is a unique number
    * @param n is the String representation of the member's name
    * @param ty is the memer type (A for adult, C for child)
    */ 
    public Member (int id, String n, char ty)    
    {
        idNumber = id;                              
        name = n;  
        if (ty == 'A' || ty == 'C' || ty == 'a' || ty == 'c')
        {
            type = ty;
            type = Character.toUpperCase(type);
        }
        else
        {
            type = 'A';
        }
        
    }
    
    /**
    * @return member id as an int
    */                                                       
    public int getId ()                           
    {
        return idNumber;                           
    }   

    /**
    * @return member's name
    */ 
    public String getName ()
    {
        return name;                                
    }
    
    /**
    * returns member's membership type as a char
    * @return 'A' for adult, 'C' for child */ 
    public char getType ()
    {
        return type;                                
    }
    
    /**
    * @return a String representation of the student, including the id number, name and points
    */
    public String toString()
    {
        return (idNumber + "  " + name + "\nMembership Type: " + type);
    }    
}
   