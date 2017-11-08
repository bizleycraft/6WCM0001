/**
 * Tests the MarksArray class
 *
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class Test
{
    public static void main(String[] args)
    {
        BizleyTest.print("Creating MarksArray object.");
        MarksArray csm1 = new MarksArray(new int[] {12,45,34,78,55,63});
        BizleyTest.print("Number of marks (should be 6): " + csm1.sizeOf());
        BizleyTest.print("2nd mark: (should be 45)" + csm1.get(1));
        BizleyTest.print("Adjusting 2nd mark to 14.");
        csm1.put(1,14);
        BizleyTest.print("2nd mark (should be 14): " + csm1.get(1));
        BizleyTest.test("out of bounds get/set calls");
        csm1.put(-12,14);
        csm1.put(12323,14);
        csm1.get(-123);
        csm1.get(12323);
        BizleyTest.success();
        csm1.listMarks();
        csm1.assessMarks();
        BizleyTest.print("Mean Mark: " + csm1.meanMark());
        BizleyTest.print("Checking above average marks");
        csm1.aboveAverage();
        BizleyTest.print("Number of students that passed the test: " + 
            csm1.numberOfPasses());
        BizleyTest.print("Highest Mark: " + csm1.highestMark());
        BizleyTest.print("Lowest Mark: " + csm1.lowestMark());
        BizleyTest.print("Range of marks: " + csm1.getRange());
        BizleyTest.print("Best student: " + csm1.bestStudent());
        BizleyTest.end();
    }
}
