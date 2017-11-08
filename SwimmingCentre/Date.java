/**
 * Simple Date Class - no error checking.
 * 
 * @author 
 * @version Version 1.0 - 31/10/02 Amended by A.Marczyk 10/10/2003
 * 
 */
public class Date
{
    /** Fields of a Date - just the day, month and year*/
    private int day;
    private int month;
    private int year;
    
    /**
     * Parameterless constructor for objects of class Date
     * Date set to 1/1/2000 */
    public Date()
    {
        day = 1;
        month = 1;
        year = 2000;
    }
    
    /**
     * Constructor for objects of class Date
     * @param d - the day part of the date (1 - 31, depending on the month).
     * @param m - the month part of the date (1 - 12).
     * @param y - the year part of the date.*/
    public Date(int d, int m, int y)
    {
        day = d;
        month = m;
        year = y;
    }

    /**
     * method to set the Date
     * @param d - the day part of the date (1 - 31, depending on the month).
     * @param m - the month part of the date (1 - 12).
     * @param y - the year part of the date.
     * Note: No error checking in this version ! */
    public void setDate(int d, int m, int y)
    {
        day = d;
        month = m;
        year = y;
    }
    
    /**
     * @return the date as a String, format "09/11/2002" */
    public String toString ()
    {
        return as2Digits(day) + "/" + as2Digits(month) + "/" + year;
    }
    
    /** Internal method to add a leading zero if necessary. */
    private String as2Digits (int i)
    {
        if (i <10) {return "0" + i;}
        else {return "" + i;}
    }
    /* 
     * The equals() method has been mostly copied from Chris's code,
     * reformatted to my style. Thanks Chris.
     * 
     * Formatting changes:
     * I use single-letters as formal parameters
     * I put blocks with a single line on a single line
     * I use 'this' as little as possible
     * 
     * I had originally overloaded instead of overridden equals, 
     * which is a bad idea due to the way some collection classes 
     * make use of equals().
     * 
     * I was confused about why '@Override' was written here.
     * The method is an override with or without that line.
     * It turns out that @Override notifies the compiler that
     * you intend to override a method here.
     * 
     * If you have overridden it incorrectly, the compiler will tell you.
     * 
     * o: Object to compare to *this* object
     */
    @Override
    public boolean equals(Object o) 
    {
        /* If the objects are literally the same */
        if (this == o){return true;}
        /* If the passed object is null */
        else if (o == null){return false;}
        /* If they are not the same class */
        else if (o.getClass() != getClass()){return false;}
        else
        {
            Date d = (Date) o;
            /* If they are effectively the same object */
            return d.day == day && d.month == month  && d.year == year;
        }
    }
}