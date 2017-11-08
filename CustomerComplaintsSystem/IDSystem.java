public class IDSystem
{
    private int numOfIDs = 0;
    public int newID(){return ++numOfIDs;}
    
    @Override
    public String toString()
    {
        return "NUMBER OF IDS: " + numOfIDs;
    }
}