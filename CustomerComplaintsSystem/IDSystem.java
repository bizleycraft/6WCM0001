import java.util.*;

public class IDSystem
{
    private int numOfIDs = 0;
    public int newID(){return ++numOfIDs;}
    
    @Override
    public String toString()
    {
        return "NUMBER OF IDS: " + numOfIDs;
    }
    public static <T extends Identifiable> T findWithID(List<T> c, int i)
    {
        for(T s : c)
        {
            if(s.getID() == i){return s;}
        }
        return null;
    }
}