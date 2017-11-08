/**
 * Represents a train
 *
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class Train
{
    /* Destination of the Train */
    private String destination;
 
    /* Train's identifying number */  
    private int TrainNumber;
   
    /* Number of customers that can fit on the Train */  
    private int capacity;
   
    /* Number of customers currently on the train */      
    private int numberInTrain;
   
    /* Ticket price */
    private int ticketPrice;
   
    /* Total money taken for Train tickets */
    private int totalTakings; 
    
    /* The current driver */
    private Driver currentDriver;
    
    /*
     * d: the destination of the Train
     * n: the number of the Train
     * c: the capacity of the Train
     * p: the cost of a ticket
     * dN: the driver's name
     * dI: the driver's ID
     */
    public Train(String d, int n, int c, int p,
        String dN, int dI)
    {
        destination = d;
        capacity = c;
        TrainNumber = n;
        ticketPrice = p;
        numberInTrain = 0;
        totalTakings = 0;
        currentDriver = new Driver(dN, dI);
    }
    
    /* Basic Accessors */
    public int getTotalTakings (){return totalTakings;}
    
    /* Basic Mutators */
    public void setTicketPrice (int p){ticketPrice = p;}
    
    /* 
     * Resets money taken for train tickets 
     */
    public void resetTotalTakings (){totalTakings = 0;}
    
    /* 
     * Records a customer leaving the train 
     */
    public void leaveTrain (){numberInTrain = numberInTrain - 1;}
    
    /* 
     * Records a customer entering the Train 
     */
    public void enterTrain ()
    {
        if (numberInTrain < capacity)
        {
            numberInTrain = numberInTrain + 1;
            totalTakings += ticketPrice;
        }
    }
}