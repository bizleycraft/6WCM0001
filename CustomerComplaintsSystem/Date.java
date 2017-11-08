/**
 * Date class.  Deals with dates from 01/01/1900.
 * 
 * @author Mick Wood
 * @version Version 2.0 - June 2004
 */
public class Date implements Comparable<Date>
{
    /** Fields of a Date - just the day, month and year.
     * Set to the default date 01/01/1900
     */
    private int day = 1;
    private int month = 1;
    private int year = 1900;
        
    private int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    /**
     * Constructor for objects of class Date
     *
     * Sets the Date fields to (d, m, y) if these form a valid date, otherwise Date defaults to 01/01/1900.
     * @param d - the day part of the date (1 &lt= d &lt= 31, depending on the month and (possibly!) year).
     * @param m - the month part of the date (1 &lt= m &lt= 12).
     * @param y - the year part of the date (y &gt= 1900).
     */
    public Date(int d, int m, int y)
    {
        if (isValidDate (d, m, y))
        {
            day = d;
            month = m;
            year = y;
        }
    }

    /** Compares two dates for equality
     * 
     * @return whether 'this' and 'other' parameter represent the same date
     */
    public boolean equals (Date other)
    {
        return this.day == other.day && 
               this.month == other.month &&
               this.year == other.year;
    }
    
    /** Returns string representation of the date
     * 
     * @return the date as a String, format "09/11/2002"
     */
    public String toString ()
    {
        return as2Digits(day) + "/" + as2Digits(month) + "/" + year;
    }
    
    
    /** is 'this' after/later than 'date'?
     * 
     * @return whether this date comes after parameter date
     */
    public boolean isLater (Date date)
    {        
        return this.daysLater (date) > 0;
    }
    
    public int compareTo (Date other)
    {
        return -this.daysLater (other);
    }
        
    /** returns how many days later 'this' date is than parameter 'date' 
     *  For example, if:
     *      d1 = new Date (31, 12, 2004),
     *      d2 = new Date (5, 6, 2005)
     *  then
     *      d2.daysLater (d1) returns 157
     *      
     * Will return negative number if 'date' is after 'this'.
     * 
     * @return number of days this date is later than parameter date
     */
    public int daysLater (Date date)
    {
        return this.daysSince1_1_1900() - date.daysSince1_1_1900();
    }
    
     
    
    /*** Return the date 'numberOfDays' after this one.
     * 
     * @param numberOfDays: the number of days to be added
     * @return a new date numberOfDays later
     * 
     * Example:  Date d1 = new Date (14, 7, 2004)
     *           Date d2 = d1.addDays (18);  // d2.toString() is "01/08/2004"
     *           
     * precondition: numberOfDays >= 0
     */
    public Date addDays (int numberOfDays)
    {
       int newYear = this.year;
       int daysFromStartOfYear = 0;
       
       //find how many days from start of year (Jan 1st is day zero)
       for (int months = 1; months < month; months++)
       {
             daysFromStartOfYear += monthLength [months - 1];   
       }
       daysFromStartOfYear+= day - 1;
       
       int totalDaysFromStartOfYear = daysFromStartOfYear + numberOfDays;
       
       //now find the new year.
       while (totalDaysFromStartOfYear >= 0)       
       {
           totalDaysFromStartOfYear -= yearLength (newYear);
           newYear++;
       }

       newYear--;
       totalDaysFromStartOfYear += yearLength (newYear);
             
       //now find the new month
       int newMonth = 1;
       while (totalDaysFromStartOfYear >= 0)       
       {
           totalDaysFromStartOfYear -= monthLength (newMonth, newYear);
           newMonth++;
       } 
       newMonth--;
       totalDaysFromStartOfYear += monthLength (newMonth, newYear);       

       return new Date (totalDaysFromStartOfYear + 1, newMonth, newYear);        
    }
    
    /*********  PRIVATE METHODS *****************************/
    /** Internal method to add a leading zero if necessary. */
    private String as2Digits (int i)
    {
        if (i <10) {return "0" + i;}
        else {return "" + i;}
    }
    
    private int daysSince1_1_1900()
    {
        int days = 0;
        for (int years = 1900; years < year; years++)
        {
            days += yearLength (years);   

        }
        
        for (int months = 1; months < month; months++)
        {
            days += monthLength (months, year);
        }                   
        
        return days + day;
    }
    
    private boolean isLeapYear (int y)
    {
        if (y % 100 == 0 && y % 400 !=0) {return false;}
        
        return y % 4 == 0;
    }
    
    private boolean isValidDate (int d, int m, int y)
    {
        if (m < 1 || m > 12) {return false;}
        if (y < 1900) {return false;}
        if (isLeapYear (y) && m == 2 && d == 29)
        {
            return true;
        }

        if (d < 1 || d > monthLength [m-1])
        {
            return false;
        }
        return true;
    }       
    private int monthLength (int month, int year)
    {
        if (isLeapYear (year) && month == 2) {return 29;}
        else {return monthLength [month - 1];}
    }      
        
    private int yearLength (int year)
    {
        if (isLeapYear (year)) {return 366;} else {return 365;}
    }    
}
