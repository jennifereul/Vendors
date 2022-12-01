import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {
    //Assume they start with 0 to begin
    @Test
    //CORRECT
    void addPositiveTest() {
        Vendor v = new Vendor(2, 5, 0);
        v.addMoney(5);

        assertEquals(5, v.getBalance());
    }

    @Test
        //CORRECT
    void addNegativeTest() {
        Vendor v = new Vendor(2, 4, 0);
        v.addMoney(-6);
        assertEquals(0, v.getBalance());
    }

    @Test
        //CORRECT
    void addZero() {
        Vendor v = new Vendor(3, 5, 0);
        v.addMoney(0);
        assertEquals(0, v.getBalance());
    }

    @Test
        //CORRECT
    void addNegativeTestInitialPositive() {
        Vendor v = new Vendor(4, 5, 20);
        v.addMoney(20);
        v.addMoney(-10);    //20+20-10=30
        assertEquals(30, v.getBalance());
    }


    @Test
        //CORRECT???
    void addNegativeTestInitialNegative() {
        Vendor v = new Vendor(4, 5, -20); //initial negative
        v.addMoney(20);      //=0
        v.addMoney(-10);      //=-10  //add negative
        assertEquals(-10, v.getBalance()); //end negative
    }

    @Test
        //CORRECT
    void testBuyPositivegum() {       //TEST TO BUY POSITIVE GUM
        Vendor v = new Vendor(4, 5, 20);
        //initial = 20 dollars
        //numCandy = Candy
        //numGum = Gum
        v.select("Gum");
        assertEquals(4, v.getStock("Gum"));
    }

    @Test //CORRECT
    void testBuyPositivecandy() {     //TEST TO BUY POSITIVE CANDY
    Vendor v = new Vendor(4, 5, 20);
    v.select("Candy");

    assertEquals(4,v.getStock("Candy"));
}
    @Test      //CORRECT
    void testBuyZero(){
        Vendor v = new Vendor(0, 0, 20);
        //What happens if you try to buy something if there are no items?
        //Initial doesn't matter
        v.select("Gum");
        assertEquals(0, v.getStock("Gum"));
        //If the item doesn't exist then code breaks

    }
    //void addZero(){
    //    Vendor v = new Vendor(3, 5 , 0);
    //    v.addMoney(0);
    //    assertEquals(0, v.getBalance());
    //}
    //CREATING BUT UNSURE BELOW
    //TEST RESTOCK BELOW
    @Test    //CORRECT
    void addZeroRestock() {
        //What happens when you try to restock with 0 items
        Vendor v = new Vendor(0,0,15 );
        v.select("Gum"); //one item at a time
        assertEquals(9, v.restock("Gum"));
    }

    //You start with 0 gum (zero). You restock 10 Gum. Then you select 1 Gum. Therefore you can expect 9 Gum.

    // }
    //USE BELOW - NOTICE THE CURRENT AMOUNT + 10
    //int restock (String item){     //November 21, 2022
    //    Item value = Stock.get(item);
    //    int currentamount = value.stock;
    //    int futureamount = currentamount + 10;
    //     Item newitem = new Item (value.price , futureamount);
    //    Stock.put(item, newitem );
    //    return newitem.stock;
    // }

    @Test      //CORRECT
    void addPositiveRestock(){
        //What happens when you try to restock
        Vendor v = new Vendor(10,10, 15);
        v.select("Gum"); //takes one out
        assertEquals(19, v.restock("Gum")); //???
    }

    //restock and try to buy

    //You start with 10 gum (positive). You restock 10 restock. You select 1 gum. 10-1=9.
    //Your starting gum + your restock and select gum = 19

    @Test    //CORRECT
    void addNegativeRestock(){
        Vendor v = new Vendor(-10, -10, 15);
        v.select("Gum");
        assertEquals(-1, v.restock("Gum"));
    }

    //You have -10 gum. You select an additional gum which is -1. The restock method adds 10. Therefore we
    //will finish with -1.

    @Test  //CORRECT???
    void addPositiveRestockAndBuyWithZeroInitial() {
        //What happens when you try buy after you restock
        Vendor v = new Vendor(0, 0, 15);// initially 0 added to stock
        v.restock("Gum"); // 10 added to stock
        v.select("Gum"); // 10 -1 =9
        assertEquals(19,v.restock("Gum")); // when re stocking 9+10 = 19
    }

    @Test   //CORRECT??
    void addPositiveRestockAndBuyWithInitial() {
        //What happens when you try buy after you restock
        Vendor v = new Vendor(10, 10, 15);// initially 10 added to stock
        v.restock("Gum"); // 10 +10=20 added to stock
        v.select("Gum"); // 20 -1 =19
        assertEquals(29,v.restock("Gum")); // when re stocking 19+10 = 29
    }

    @Test   //CORRECT ???
    void changeStockNameFromCandyToCookie() {
        //What happens when you change the item name
        Vendor v = new Vendor(10, 40, 15);// initially 10 added to stock
        v.restock("Candy");// 10+10=20
        assertEquals(20, v.ChangeStockName("Candy","Cookie").stock); // when re stocking 10+10 = 20
    }

    @Test   //CORRECT ??
    void changeStockNameFromGumToCookie() {
        //What happens when you change the item name
        Vendor v = new Vendor(10, 40, 15);// initially 40 added to stock
        v.restock("Gum");// 40+10=50
        assertEquals(50, v.ChangeStockName("Gum","Cookie").stock); // when re stocking 40+10 = 50
    }

    //Change Stock name
    @Test  //NOT CORRECT
   void changeStockNameFromBookToCookie() {
        //What happens when you change the item name which not exist
        Vendor v = new Vendor(10, 40, 15);// initially 10 added to stock
        v.restock("Book");// 10+10=20 -- Failure and null pointer, because we dont have null check here
        assertEquals(20, v.ChangeStockName("Book","Cookie").stock); // when re stocking 10+10 = 20
        //BOOK NEVER HAS AND NEVER WILL EXIST
    }

    //Empty inventory Positive initial
    @Test  //CORRECT ??
    void emptyInventoryOfCandyPositive() {
        Vendor v = new Vendor(10, 40, 15);// initially 10 added to stock
        assertEquals(0, v.emptyInventory("Candy"));
    }

    @Test  //CORRECT??
    void emptyInventoryBothPositive() {
        Vendor v = new Vendor(10, 10, 15);// initially 10 added to stock
        assertEquals(0, v.emptyInventory("Candy"));
        assertEquals(0, v.emptyInventory("Gum"));
    }

    @Test  //CORRECT??
    void emptyInventoryOfCandy() {
        Vendor v = new Vendor(-10, 40, 15);// initially -10 added to stock
        assertEquals(0, v.emptyInventory("Candy"));
    }

    @Test //CORRECT??
    void printInventoryOfVendor() {
        Vendor v = new Vendor(10, 40, 15);// initially 10 and 40 added to stock
        v.printInventoryOfVendor();
    }
    //HOW DO I PRINT 5 VENDORS? DO I NEED TO MAKE 5 VENDORS?

}


