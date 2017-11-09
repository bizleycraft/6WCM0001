public class Person implements Identifiable
{
    /* The person's id */
    private int id;
    /* The person's name */
    private String name;
    
    /*
     * r: The person's id
     * n: The person's name
     */
    public Person(int i, String n)
    {
        id = i;
        name = n;
    }
    public int getID(){return id;}
    public String getName(){return name;}
    @Override
    public String toString()
    {
        String s = "PERSON NAME: " + name;
        s = s + "\nPERSON ID: " + id;
        return s;
    }
}