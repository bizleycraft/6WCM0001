/**
 * Answer to Unit 4, Session 6
 * 
 * @author Mick Wood 
 * @version 15/11/02
 */
public class StockItem
{

    private String description;
    private int quantity;
    private int price;
    
    //PART d.)
    private boolean onOrder;
    
    /** 
     * @param d - description of the item
     * @param p - price of the item
     */
    public StockItem (String d, int p)
    {
        description = d;
        quantity = 0;
        price = p;
        onOrder = false;
    }
    
    /**
     * @param p the new price
     */
    public void setPrice (int p) {price = p;}
    
    /**
     * @param amount the number of items delivered
     */
    public void doDelivery (int amount) 
    {
        quantity = quantity + amount;
        onOrder = false; //NOTE - PART d.)
    }
    
    //PART a.)
    /**
     * @param amount the number of items to be sold (if possible)
     */
    public void doSale (int amount) 
    {
        if (quantity >= amount)  {quantity = quantity - amount;}
    }   
    
    //PART b.)
    /**
     * @param amount the number of items needed for sale
     * @result whether sale is possible or not
     */    
    public boolean canDoSale(int amount)
    {
        if (quantity >= amount) {return true;}
        else {return false;}
        
        // better is just:
        // return (quantity >= amount)
    }
    

    public String getDescription() {return description;}
    
    public int getQuantity() {return quantity;}
    
    public int getPrice() {return price;}

    //PART c.)
    public boolean mustOrderMore()
    {
        return (quantity < 5); 
        
        //NOTE - this is better than:  if (quantity<5) {return true;} else {retiurn false;}
    }
    
    //PART d.)
    public void setOnOrder () {onOrder = true;}
    
    public String toString()
    {
        return description + " (Quantity: " + quantity + ", Price: $" + price + ")";
    }
}