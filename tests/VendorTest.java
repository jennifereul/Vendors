import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {
//Assume they start with 0 to begin
    @Test
    void addPositiveTest() {
        Vendor v = new Vendor(2, 5,0);
        v.addMoney(5);

        assertEquals(5, v.getBalance());
    }
    @Test
    void addNegativeTest(){
        Vendor v = new Vendor( 2,4 ,0);
        v.addMoney(-6);
        assertEquals(  0, v.getBalance());
    }
    @Test
    void addZero(){
        Vendor v = new Vendor(3, 5 , 0);
        v.addMoney(0);
        assertEquals(0, v.getBalance());
    }
    @Test
    void addNegativeTestInitialPositive(){
        Vendor v = new Vendor(4, 5, 20);
        v.addMoney(20);
        v.addMoney( -10);
        assertEquals(30, v.getBalance());
    }
}
//Test for positives negatives and zeros
//Change the name of the item (What will happen if the item doesn't exist?)