/**
 * Handles an array of marks
 * 
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class MarksArray
{
    /* Array of marks */
    private int[] marks;
    
    /*
     * m: the array of marks
     */
    public MarksArray(int[] m)
    {
        marks = m;
    }
    
    /*
     * Places a mark in the marks array
     * d: index where mark will go in the array
     * v: value of mark
     */
    public void put(int i, int v)
    {
        /* If the index is in the bounds of the marks array */
        if (i >= 0 && i < marks.length){marks[i] = v;}
    }
    
    /*
     * Returns the mark in the marks array at the passed int
     * Returns -1 if the int is out of bounds
     * i: index of the mark
     */
    public int get(int i)
    {
        /* If the index is in the bounds of the marks array */
        if (i >= 0 && i < marks.length){return marks[i];}
        else{return -1;}
    }
    
    /*
     * Returns the size of the marks array
     */
    public int sizeOf(){return marks.length;}
    
    /*
     * Prints a compact list of the marks in the marks array
     */
    public void listMarks()
    {
        System.out.print("Compact list: ");
        /* For each mark in the marks array */
        for(int m : marks)
        {
            /* Print the mark and a space */
            System.out.print(m + " ");
        }
        /* Print a new line */
        System.out.println();
    }
    
    /*
     * Prints a list of the marks in the marks array
     * along with that mark's grade
     */
    public void assessMarks()
    {
        System.out.println("Results: ");
        /* Initialises an int to number the marks */
        int n = 1;
        /* For each mark */
        for(int m : marks)
        {
            /* Print which mark this is */
            System.out.print(n++ + ". ");
            /* If the mark is less than 45 */
            if(m < 45)
            {
                System.out.println(m + " FAIL");
            }
            /* If the mark is less than 75 */
            else if (m < 75)
            {
                System.out.println(m + " PASS");
            }
            else
            {
                System.out.println(m + " DISTINCTION");
            }
        }
    }
    
    /*
     * Returns the mean average of the marks in the marks array
     */
    public int meanMark()
    {
        /* Initialises an int to tally up the marks */
        int t = 0;
        /* For every mark */
        for(int m : marks)
        {
            /* Add the mark to the tally */
            t += m;
        }
        /* Divide the total by the number of marks and return it */
        return t / marks.length;
    }
    
    /*
     * Returns the marks that were above average
     */
    public void aboveAverage()
    {
        /* Get the average mark */
        int a = meanMark();
        System.out.print("Above Average Marks: ");
        /* For each mark */
        for(int m : marks)
        {
            /* If the mark is above average, print it */
            if(m > a){System.out.print(m + " ");}
        }
        /* Print a new line */
        System.out.println();
    }
    
    /*
     * Returns the number of PASS marks
     */
    public int numberOfPasses()
    {
        /* Initialises an int to tally up the passes */
        int p = 0;
        /* For each mark */
        for(int m : marks)
        {
            /* If the mark is greater than or equal to 45 */
            if(m >= 45)
            {
                /* Increment the number of passes */
                p++;
            }
        }
        /* Return the total number of passes */
        return p;
    }
    
    /*
     * Returns the highest mark
     */
    public int highestMark()
    {
        /* 
         * Initialises an int to keep track of the highest 
         * mark so far
         */
        int h = 0;
        /* For each mark */
        for(int m : marks)
        {
            /* If the mark is higher than the highest mark so far */
            if(m > h)
            {
                /* Update the highest mark so far */
                h = m;
            }
        }
        /* Return the highest mark */
        return h;
    }
    
    /*
     * Returns the lowest mark
     */
    public int lowestMark()
    {
        /* 
         * Initialises an int to keep track of the lowest 
         * mark so far (starting with the highest possible mark)
         */
        int l = 100;
        /* For each mark */
        for(int m : marks)
        {
            /* If the mark is lower than the lowest mark so far */
            if(m < l)
            {
                /* Update the lowest mark so far */
                l = m;
            }
        }
        /* Return the lowest mark */
        return l;
    }
    
    /*
     * Returns the range between the highest and lowest mark
     */
    public int getRange(){return highestMark() - lowestMark();}
    
    /*
     * Returns the best student
     */
    public int bestStudent()
    {
        /* 
         * Initialises an int to keep track of the highest 
         * mark so far 
         */
        int h = 0;
        /* Initialises an int to number the marks */
        int n = 1;
        /* 
         * Initialises an int to keep track of location 
         * of the highest mark so far 
         */
        int l = 1;
        /* For each mark */
        for(int m : marks)
        {
            /* If the mark is higher than the highest mark so far */
            if(m > h)
            {
                /* Update the highest mark so far */
                h = m;
                /* Update the location of the highest mark so far */
                l = n;
            }
            /* Increment the mark number */
            n++;
        }
        /* Return the location of the best mark so far */
        return l;
    }
}