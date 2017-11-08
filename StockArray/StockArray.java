/**
 * Handles an array of StockItems
 *
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class StockArray
{
    /* Array of StockItems */
    private StockItem[] stock;
    
    /*
     * s: size of the array
     */
    public StockArray(int s)
    {
        /* If the size is a positive number */
        if(s > 0){stock = new StockItem[s];}
        else{stock = new StockItem[1];}
    }
    
    /*
     * Creates a new StockItem and adds it to the array
     * i: index where the item should be placed in the array
     * d: description of StockItem
     * p: price of StockItem
     */
    public void addNewStockItem(int i, String d, int p)
    {
        /* If the index is in the bounds of the stock array */
        if(i >= 0 && i < stock.length){stock[i] = new StockItem(d,p);}
    }
    
    /* 
     * Returns the length of the stock array 
     */
    public int noOfStockItems(){return stock.length;}
    
    /* 
     * Displays the details of a single StockItem
     * i: index of StockItem in the stock array
     */
    public void displayStockItem(int index)
    {
        /* 
         * If the index is in the bounds of the stock array 
         * and the StockItem at that index is not null
         */
        if(index >= 0 && index < stock.length && stock[index] != null)
        {
            /* Print the StockItem's details */
            System.out.println(stock[index].toString());
        }
    }
    
    /* 
     * Displays the details of a single StockItem
     */
    public void listAllStockItems()
    {
        /* For the length of the stock array */
        for(int i = 0; i < stock.length; i++)
        {
            /* If the StockItem at this index is not null */
            if(stock[i] != null){displayStockItem(i);}
        }
    }
    
    /* 
     * Displays the details of all StockItems in the stock array
     */
    public void updateStockLevel(int index, int amount)
    {
        /* 
         * If the index is in the bounds of the stock array 
         * and the StockItem at that index is not null
         */
        if(index >= 0 && index < stock.length && stock[index] != null)
        {   
            /* Update the stock level */
            stock[index].doDelivery(amount);
        }
    }
}