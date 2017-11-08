import java.awt.Color;
/**
 * Write a description of class Tester here.
 * 
 * @author Joshua Bizley
 * @version October 27th, 2017
 */
public class Tester
{
    private Date date1 = new Date (1, 3, 2008);
    private Date date2 = new Date (8, 4, 2008);
    
    private Session s1 = new Session ("S08_01", "BreastStroke Level 3", 0.00, date1);
    private Session s2 = new Session ("S08_02", "ButterFly Level 1", 16.00, date2); 
    
    private Member m1 = new Member (1, "Mick Wood",'A');
    private Member m2 = new Member (2, "Olenka Marczyk",'A');    
    private Member m3 = new Member (3, "David Pearson",'A');
    private Member m4 = new Member (4, "Bodo Scholtz",'A');
    
    private Centre centre1 = new Centre("Hatfield");
    
    public void doTest ()
    {
        s1.signUp(m1);
        s1.signUp(m2);
        s1.signUp(m3);
        s1.signUp(m4);
        System.out.println ("-Members-on-Session-------");
        s1.showMembersOnSession();
        centre1.addSession(s1);
        centre1.addSession(s2);
        System.out.println ("-Session-One--------------");
        System.out.println (s1.toString());
        System.out.println ("-Session-Two--------------");
        System.out.println (s2.toString());
        System.out.println ("!Deleting-Session-One!!!!!");
        centre1.cancelSession(s1);
        Date d1 = new Date (1, 3, 2008);
        Date d2 = new Date (8, 4, 2008);
        System.out.println ("-Sessions-with-Date-1-----");
        centre1.searchSessionsByDate(d1);
        System.out.println ("-Sessions-with-Date-2-----");
        centre1.searchSessionsByDate(d2);
    }
    
}

