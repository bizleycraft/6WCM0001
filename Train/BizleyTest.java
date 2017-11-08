/**
 * Beautifies the console output during testing
 * 
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class BizleyTest
{
    /* 
     * A hammer in ASCII art format
     * Source: http://www.ascii-art.de/ascii/ghi/hammer.txt
     */
    public static String[] HAMMER = {"  ,",
                                       " /(  ___________",
                                       "|  >:===========`",
                                       " )(",
                                       " \"\""};
    
    /* 
     * "success" in ASCII art format
     * Source: http://success.ascii.uk/
     */
    public static String[] SUCCESS = {" ___ _   _  ___ ___ ___  ___ ___ ",
                                       "/ __| | | |/ __/ __/ _ \\/ __/ __|",
                                       "\\__ \\ |_| | (_| (_|  __/\\__ \\__ \\",
                                       "|___/\\__,_|\\___\\___\\___||___/___/"};
    
    /* 
     * Butterflies in ASCII art format
     * Source: http://www.ascii-art.de/ascii/ab/butterfly.txt
     */
    public static String[][] BUTTERFLIES = {{" __   __",
                                             "(  \\,/  )",
                                             " \\_ | _/",
                                             " (_/ \\_)"},
                                            {" ___   ___",
                                             "( @ \\Y/ @ )",
                                             " \\__+|+__/",
                                             "  {_/ \\_}"},
                                            {" ___   ___",
                                             "((o)\\,/(o))",
                                             " \\__ | __/",
                                             "  {_/'\\_}"},
                                            {" ___   ___",
                                             "( @ \\v/ m )",
                                             " \\__+|+__/",
                                             "  {_/ \\_}"},
                                            {" ___   ___",
                                             "{ ~ \\,/ ~ }",
                                             " \\_~_|_~_/",
                                             "  (_/'\\_)"},
                                            {" __   __",
                                             "(()\\,/  )",
                                             " \\_ | _/",
                                             " { /'\\*}"},
                                            {" __ Y __",
                                             "(()\\o/())",
                                             " \\_ I _/",
                                             "  (/I\\)"},
                                            {"  __   __",
                                             "( s \\Y/ s )",
                                             " \\_<>|<>_/",
                                             "  (_/'\\_)"},
                                            {" ___   ___",
                                             "( q \\,/ p )",
                                             " \\_ 6|9 _/",
                                             "  {_/ \\_} "}};
    
    /* 
     * Marking the constructor as private ensures the user 
     * learns that this class's methods are static 
     */
    private BizleyTest(){}
    
    /* 
     * Prints a hammer
     * Call before running error-testing code
     * s: String with what you are testing, e.g. "null indexes"
     */
    public static void test(String s)
    {
        System.out.println(HAMMER[0]);
        System.out.println(HAMMER[1]);
        System.out.println(HAMMER[2]);
        System.out.print(HAMMER[3]);
        System.out.println(" Testing " + s);
        System.out.println(HAMMER[4]);
    }
    
    /* 
     * Prints a butterfly in front of a single line 
     * s: String to be printed
     */
    public static void print(String s)
    {
        int r = (int)(Math.random() * BUTTERFLIES.length);
        System.out.println(BUTTERFLIES[r][0]);
        System.out.println(BUTTERFLIES[r][1]);
        System.out.print(BUTTERFLIES[r][2]);
        System.out.println(" " + s);
        System.out.println(BUTTERFLIES[r][3]);
    }
    
    /* 
     * Prints "success" in ASCII art format 
     */
    public static void success()
    {
        for(String s : SUCCESS){System.out.println(s);}
    }
    
    /* 
     * Prints credits 
     */
    public static void end()
    {
        System.out.println("\nCredits:");
        System.out.println("ascii-art.de/ascii/ab/butterfly.txt");
        System.out.println("success.ascii.uk");
        System.out.println("ascii-art.de/ascii/ghi/hammer.txt");
    }
}