import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Random;


public class NewTest {

    Vendor v;

    //If you want to do something before each method
    @BeforeEach
    void setUp() {
        System.out.println("setUP");
        v = new Vendor(1, 2, 0);

    }

    @BeforeAll
    static void init() {
        System.out.println("origin");

    }

    //Write a test that adds a random value to the balance
    //Check that the balance is updated properly
    @RepeatedTest(5)
    void randomValue() {
    System.out.println("Random Value");
    Random rand = new Random(100);
    Double add = rand.nextDouble();
    v.addMoney(add);
    assertEquals(add, v.getBalance());
}

@Test
void test1(){
        System.out.println("Test1");
    v.addMoney(2.0);
    assertEquals(2, v.getBalance());
}

@Test
void Test2(){
        System.out.println("Test2");
    v.addMoney(2.0);
    v.select("Gum");
    assertEquals(1.5, v.getBalance());
}
}