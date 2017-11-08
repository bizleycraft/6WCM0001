/**
 * Tests the ArrayExercises class
 *
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class Test
{
    public static void main(String[] args)
    {
        BizleyTest.print("Initializing arrays");
        ArrayExercises ae = new ArrayExercises();
        BizleyTest.print("Listing days per month");
        BizleyTest.print("Days in January (should be 31): " + ae.monthLength(1));
        BizleyTest.print("Days in February (should be 28): " + ae.monthLength(2));
        BizleyTest.print("Days in December (should be 31): " + ae.monthLength(12));
        BizleyTest.test("out of bounds indexes");
        BizleyTest.print("Days in Zeroary (should be -1): " + ae.monthLength(0));
        BizleyTest.print("Days in Thirteenber (should be -1): " + ae.monthLength(13));
        BizleyTest.success();
        BizleyTest.print("Listing marks per grade");
        BizleyTest.print("The marks should match 4,2,0,1");
        ae.printPerGrade(new int[] {12,31,24,2,45,100,101,0,-1});
        BizleyTest.print("Counting vowels in ”Sound and Fury” quote");
        BizleyTest.print("This should match 15,10,13,14,9");
        BizleyTest.print("If case is accounted for, there will be 13 'i's");
        ae.printNumberOfVowels("Out, out, brief candle! Life's but a walking shadow, a poor player that struts and frets his hour upon the stage and is heard no more. It is a tale told by an idiot, full of sound and fury, signifying nothing.");
        BizleyTest.print("Each number should be followed by that many stars");
        BizleyTest.end();
    }
}
