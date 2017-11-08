/**
 * Handles various arrays
 * 
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class ArrayExercises
{
    /* 
     * The number of days in each month 
     * We are allowed to ignore leap years
     */
    public static final int[] DAYS_IN_MONTHS = 
        {31,28,31,30,31,30,31,31,30,31,30,31};
    
    /* The divisions between grade tiers */
    public static final int[] GRADE_RANGES = {0,25,50,75,101};
    
    /* The vowels */
    public static final char[] VOWELS = {'a','e','i','o','u'};

    /* 
     * Returns the number of days in the passed month 
     * m: month
     */
    public int monthLength(int m)
    {
        /* If the number is a valid month */
        if(m >= 1 && m <= DAYS_IN_MONTHS.length)
        {
            return DAYS_IN_MONTHS[m-1];
        }
        else
        {
            return -1;
        }
    }
    
    /* 
     * Prints the number of marks that were in each grade tier
     * m: array of marks
     */
    public void printPerGrade(int[] m)
    {
        /* Initialises an int array to tally up the marks per tier */
        int[] results = {0,0,0,0};
        /* For each mark */
        for(int i : m)
        {
            /* For each tier */
            for(int j = 0; j < results.length; j++)
            {
                /* If the mark is within the range of this tier, increment the tally */
                if(i >= GRADE_RANGES[j] && i < GRADE_RANGES[j+1]){results[j]++;}
            }  
        }
        /* Prints the resulting tallies */
        for(int i = 0; i < results.length; i++)
        {
            System.out.println("Marks in range " + GRADE_RANGES[i] + " to " +
                (GRADE_RANGES[i+1]-1) + ": " + results[i]);
        }
    }
    
    /*
     * Prints the number of each vowel in the passed String
     * and displays an equal number of stars
     * s: String to find vowels in
     */
    public void printNumberOfVowels(String s)
    {
        /* Initialises an int array to tally up the vowel counts */
        int[] tally = {0,0,0,0,0};
        /* For each char in the String */
        for(int i = 0; i < s.length(); i++)
        {
            /* 
             * If the char is a vowel, increment the relevant tally
             * The exercise told me to use a switch
             */
            switch (s.charAt(i)) 
            {
                case 'a': case 'A':  tally[0]++; break;
                case 'e': case 'E':  tally[1]++; break;
                case 'i': case 'I':  tally[2]++; break;
                case 'o': case 'O':  tally[3]++; break;
                case 'u': case 'U':  tally[4]++; break;
            }
        }
        /* For each vowel */
        for(int i = 0; i < VOWELS.length; i++)
        {
            /* Print the number of vowels */
            System.out.print(tally[i] + " '" + VOWELS[i] + "'s: ");
            /* Display an equal number of stars */
            printStars(tally[i]);
            /* Print a new line */
            System.out.println();
        }
    }
    
    /*
     * Prints a number of stars equal to the passed int
     * n: number of stars
     */
    private void printStars(int n)
    {
        /* For the passed number */
        for(int i = 0; i < n; i++)
        {
            /* Print a star */
            System.out.print("*");
        }
    }
}
