/**
 * Tests the Train class
 *
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class Test
{
    public static void main()
    {
        Train t = new Train("London",2,300,74,"Mr. Goldings",27);
        BizleyTest.print("20 people enter the train");
        for(int i = 0; i < 20; i++){t.enterTrain();}
        BizleyTest.print("Total takings: £" + t.getTotalTakings());
        BizleyTest.end();
    }
}