public class Action
{
    /* The ID of the complaint */
    private int id;
    /* A description of the action */
    private String description;
    /* The date the action was taken */
    private Date date;
    
    /*
     * i: The complaint's id
     * s: The description of the action
     * d: The date the action was taken
     */
    public Action(int i, String s, Date d)
    {
        id = i;
        description = s;
        date = d;
    }
    @Override
    public String toString()
    {
        String s = "ACTION";
        s = s + "\nCOMPLAINT ID: " + id;
        s = s + "\nDESCRIPTION OF ACTION: " + description;
        s = s + "\nDATE OF ACTION: " + date;
        return s;
    }
}