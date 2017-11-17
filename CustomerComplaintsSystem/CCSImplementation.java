import java.util.*;

/**
 * Implementation of Customer Complaints System
 * 
 * (Task 2/Implementing the interface)
 * 
 * @author Joshua Bizley
 * @version November 10th, 2017
 */
public class CCSImplementation implements CCS
{
    /* The customer id system */
    private IDSystem customerIDSystem;
    
    /* The staff id system */
    private IDSystem staffIDSystem;
    
    /* The submission id system */
    private IDSystem submissionIDSystem;
    
    /* The map of customers */
    private Map<Integer,Customer> customers;
    
    /* The map of staff */
    private Map<Integer,Staff> staff;
    
    /* The map of submissions */
    private Map<Integer,Submission> submissions;
    
    /**Initialises the Customer Complaints System
     * 
     * (Task 2/Implementing the interface)
     */
    public CCSImplementation()
    {
        /* Initialises the customer id system */
        customerIDSystem = new IDSystem();
        
        /* Initialises the staff id system */
        staffIDSystem = new IDSystem();
        
        /* Initialises the submission id system */
        submissionIDSystem = new IDSystem();
        
        /* Initialises the map of submissions */
        submissions = new HashMap<Integer,Submission>();
        
        /* Initialises the map of staff */
        staff = new HashMap<Integer,Staff>();
        
        /* Initialises the map of customers */
        customers = new HashMap<Integer,Customer>();
    }
    
    /**Adds a Submission to the system
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param submissionID The id of the submission 
     * @param customerID The id of the customer
     * @param description The comment
     * @param date The date of the comment
     */
    public void addComment(int submissionID, int customerID, 
        String comment, Date date)
    {
        /* Inserts the comment if the id is absent or replaces
         * another comment if the id is already in use
         */
        insertOrReplace(submissions,submissionID,
            new Submission(getCustomer(customerID), date, 
            comment));
    }
    
    /**Adds a Customer to the system
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param customerID The id of the customer
     * @param name The name of the customer
     * @param address The physical address of the customer
     * @param email The email address of the customer
     * @param phone The phone number of the customer
     */
    public void addCustomer(int customerID, String name, 
        String address, String email, String phone)
    {
        /* Inserts the customer if the id is absent or replaces
         * another customer if the id is already in use
         */
        insertOrReplace(customers,customerID,
            new Customer(name, address, email, phone));
    }
    
    /**Adds a Complaint to the system
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param submissionID The id of the submission 
     * @param customerID The id of the customer
     * @param description A description of the complaint
     * @param date The date of the complaint
     */
    public void addGeneralComplaint(int submissionID, 
        int customerID, String description, Date date)
    {
        /* Inserts the complaint if the id is absent or replaces
         * another complaint if the id is already in use
         */
        insertOrReplace(submissions,submissionID,
            new Complaint(getCustomer(customerID), date, 
            description));
    }
    
    /**Adds a LiftComplaint to the system
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param submissionID The id of the submission 
     * @param customerID The id of the customer
     * @param description A description of the complaint
     * @param lift The lift being complained about
     * @param floor The floor that the lift is presently on
     * @param date The date of the complaint
     */
    public void addLiftComplaint(int submissionID, int customerID, 
        String description, String lift, int floor, Date date)
    {
        /* Inserts the complaint if the id is absent or replaces
         * another complaint if the id is already in use
         */
        insertOrReplace(submissions,submissionID,
            new LiftComplaint(getCustomer(customerID), date, 
            description, lift, floor));
    }
    
    /**Adds a Staff member to the system
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param staffID The id of the staff member
     * @param name The name of the staff member
     * @param role The role of the staff member
     * @param department The department of the staff member
     */
    public void addStaff(int staffID, String name, String role, 
        String department)
    {
        insertOrReplace(staff,staffID,
            new Staff(name, department, role));
    }
    
    /**Adds a StaffComplaint to the system
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param submissionID The id of the submission 
     * @param customerID The id of the customer
     * @param description A description of the complaint
     * @param staffID The id of the staff member complained about
     * @param date The date of the complaint
     */
    public void addStaffComplaint(int submissionID, int customerID, 
        String description, int staffID, Date date)
    {
        /* Inserts the complaint if the id is absent or replaces
         * another complaint if the id is already in use
         */
        insertOrReplace(submissions,submissionID,
            new StaffComplaint(getCustomer(customerID), date, 
            description, getStaff(staffID)));
    }
    
    /**Prints out and removes all submissions except unresolved 
     * complaints
     * 
     * (Task 2/Implementing the interface)
     */
    public void archiveSubmissions()
    {
        /* Creates a iterator to use instead of forEach
         * 
         * This was necessary because removing the submissions inside
         * of a forEach loop resulted in a ConcurrentModificationException
         * 
         * The alternative would have been to create a list of ids
         * of removable submissions but this seems to be cleaner
         */
        Iterator it = submissions.values().iterator();
        
        /* Iterates through every submission */
        while(it.hasNext())
        {
            /* Casts the object to a submission */
            Submission sub = (Submission) it.next();
            
            /* If the submission is archivable
             * False only in the case of an unresolved complaint 
             */
            if (sub.isArchivable())
            {
                /* Prints out the submission */
                System.out.println(sub.toString());
                
                /* Removes the submission from the system */
                it.remove();
            }
        }
    }
    
    /**Assigns a resolver to a Complaint
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param complaintID The id of the complaint
     * @param staffID The id of the resolver
     * @param deadline The deadline for resolution
     */
    public void assignResolver(int complaintID, int staffID, 
        Date deadline)
    {
        /* Downcasts the Submission to a Complaint */
        Complaint c = (Complaint) getSubmission(complaintID);
        
        /* Assigns a resolver to the Complaint and sets deadline */
        c.assignResolver(getStaff(staffID),deadline);
    }
    
    /**Returns the list of actions stored in a Complaint
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param complaintID The id of the complaint
     * @return The list of actions stored in a Complaint
     */
    public List<Action> getActionsForComplaint(int complaintID)
    {
        /* Downcasts the Submission to a Complaint */
        Complaint c = (Complaint) getSubmission(complaintID);
        
        /* Returns the list of Actions stored in the Complaint */
        return c.getActions();
    }
    
    /**Returns the Customer paired with the passed id
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param customerID The id of the customer
     * @return The Customer paired with the passed id
     */
    public Customer getCustomer(int customerID)
    {
        /* Returns the customer paired with customerID */
        return customers.get(customerID);
    }
    
    /**Returns the list of Customers
     * 
     * (Task 2/Implementing the interface)
     * 
     * @return The list of customers
     */
    public List<Customer> getCustomerList()
    {
        /* Converts the map to a list and returns it */
        return toList(customers);
    }
    
    /**Returns a unique customer id
     * 
     * (Task 2/Implementing the interface)
     * 
     * @return A unique customer id
     */
    public int getNewCustomerId()
    {
        /* Returns a unique id for customers */
        return customerIDSystem.newID();
    }
        
    /**Returns a unique staff id
     * 
     * (Task 2/Implementing the interface)
     * 
     * @return A unique staff id
     */
    public int getNewStaffId()
    {
        /* Returns a unique id for staff */
        return staffIDSystem.newID();
    }
        
    /**Returns a unique submission id
     * 
     * (Task 2/Implementing the interface)
     * 
     * @return A unique submission id
     */
    public int getNewSubmissionId()
    {
        /* Returns a unique id for submissions */
        return submissionIDSystem.newID();
    }
        
    /**Returns the Staff paired with the passed id
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param staffID The id of the staff member
     * @return The Staff paired with the passed id
     */
    public Staff getStaff(int staffID)
    {
        /* Returns the staff paired with staffID */
        return staff.get(staffID);
    }
        
    /**Returns the list of Staff
     * 
     * (Task 2/Implementing the interface)
     * 
     * @return The list of staff
     */
    public List<Staff> getStaffList()
    {
        /* Converts the map to a list and returns it */
        return toList(staff);
    }
    
    /**Returns the Submission paired with the passed id
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param submissionID The id of the submission
     * @return The Submission paired with the passed id
     */
    public Submission getSubmission(int submissionID)
    {
        /* Returns the submission paired with submissionID */
        return submissions.get(submissionID);
    }
        
    /**Returns the list of Submissions
     * 
     * (Task 2/Implementing the interface)
     * 
     * @return The list of submissions
     */
    public List<Submission> getSubmissionList()
    {
        /* Converts the map to a list and returns it */
        return toList(submissions);
    }
    
    /**Adds an Action to a Complaint's list of Actions
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param complaintID The id of the complaint
     * @param actionTaken A description of the action
     * @param date The date that the action was taken
     */
    public void recordAction(int complaintID, String actionTaken,
        Date date)
    {
        /* Downcasts the Submission to a Complaint */
        Complaint c = (Complaint) getSubmission(complaintID);
        
        /* Add the action to the complaint's list of actions */
        c.recordAction(actionTaken, date);
    }
    
    /**Marks a Complaint as resolved
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param complaintID The id of the complaint to resolve
     */
    public void recordComplaintResolved(int complaintID)
    {
        /* Downcasts the Submission to a Complaint */
        Complaint c = (Complaint) getSubmission(complaintID);
        
        /* Mark the complaint as resolved */
        c.resolve();
    }
    
    /**Removes a Customer from the system
     * 
     * (Task 2/Implementing the interface)
     * 
     * @param customerID The id of the customer to remove
     */
    public void removeCustomer(int customerID)
    {
        /* Remove the customer with the passed id */
        customers.remove(customerID);
    }
    
    /**Returns a list of Complaints that do not yet have a 
     * resolver, ordered by Date
     * 
     * (Task 2/Implementing the missing method to 
     * list new complaints)
     */
    public List<Complaint> getNewComplaintsList()
    {
        /* Creates a new ArrayList to hold the new complaints */
        List<Complaint> l = new ArrayList<Complaint>();
        
        /* For each submission */
        submissions.forEach((k,v)->
        {
            /* If the submission is not archivable
             * (True only for unresolved complaints)
             */
            if (!v.isArchivable())
            {
                /* Downcasts the value (which is an Object) 
                 * to a Complaint 
                 */
                Complaint c = (Complaint) v;
                
                /* If the complaint does not have a resolver yet */
                if(c.getResolver() == null)
                {
                    /* Add the complaint to the ArrayList */
                    l.add(c);
                }
            }
        });
        
        /* Sorts the ArrayList (in this case, by date) */
        Collections.sort(l);
        
        /* Returns the list of complaints, ordered by date */
        return l;
    }
    
    /**Converts the values in a map to a list
     * 
     * (Task 5/Avoiding code duplication)
     * 
     * @param map The map to convert to a list
     * @param K The type of the keys in the map
     * @param V The type of the values in the map
     * @return The converted list
     */
    private <K,V> List<V> toList(Map<K,V> map)
    {
        /* Creates an ArrayList of type V */
        List<V> l = new ArrayList<V>();
        
        /* Add the values in the map to the ArrayList */
        for(V v : map.values()){l.add(v);}
        
        /* Return the converted list */
        return l;
    }
    
    /**Inserts the value if the key is absent
     * or replaces another value if the key is present
     * 
     * (Task 5/Avoiding code duplication)
     * 
     * @param map The map to insert a value into
     * @param key The key for the value
     * @param value The value you are inserting
     * @param K The type of the keys in the map
     * @param V The type of the values in the map
     */
    private <K,V> void insertOrReplace(Map<K,V> map, K key, V value)
    {
        /* If the key is present in the map, replace its value */
        if(map.containsValue(value)){map.replace(key,value);}
        
        /* If the key is absent, place the key/value */
        else{map.put(key,value);}
    }
}