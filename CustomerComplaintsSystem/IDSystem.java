import java.util.*;

public class IDSystem<T extends Identifiable>
{
    private int numOfIDs = 0;
    public int newID(){return ++numOfIDs;}
    @Override
    public String toString()
    {
        return "NUMBER OF IDS: " + numOfIDs;
    }
    public static <T extends Identifiable> T findWithID(List<T> list, int id)
    {
        for(T obj : list)
        {
            if(obj.getID() == id){return obj;}
        }
        return null;
    }
    public static <T extends Identifiable> void removeWithID(List<T> list, int id)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).getID() == id)
            {
                list.remove(i); 
                break;
            }
        }
    }
}