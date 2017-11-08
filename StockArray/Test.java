/**
 * Tests the StockArray class
 *
 * @author Joshua Bizley
 * @version 6/27/2017
 */
public class Test
{
    public static void main(String[] args)
    {
        BizleyTest.print("Initializing stock");
        StockArray sa = new StockArray(5);
        sa.addNewStockItem(1,"Bread",100);
        sa.addNewStockItem(3,"Beans",60);
        BizleyTest.test("out-of-bounds initialization");
        sa.addNewStockItem(-8,"Bread",100);
        sa.addNewStockItem(8,"Bread",100);
        BizleyTest.success();
        BizleyTest.print("Displaying stock");
        sa.listAllStockItems();
        BizleyTest.print("Updating stock");
        sa.updateStockLevel(3,34);
        BizleyTest.print("Displaying stock");
        sa.listAllStockItems();
        BizleyTest.test("null update");
        sa.updateStockLevel(2,88);
        BizleyTest.success();
        BizleyTest.test("out-of-bounds update");
        sa.updateStockLevel(-8,88);
        sa.updateStockLevel(8,88);
        BizleyTest.success();
        BizleyTest.test("null display");
        sa.displayStockItem(2);
        BizleyTest.success();
        BizleyTest.test("out-of-bounds display");
        sa.displayStockItem(-8);
        sa.displayStockItem(8);
        BizleyTest.success();
        BizleyTest.end();
    }
}