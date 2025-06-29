import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

class EvenChecker{
    public boolean isEven(int n){return n%2==0;}
    public void throwError(){throw new IllegalArgumentException("error");}
    public void slowTask(){
        try{Thread.sleep(500);}catch(Exception e){}
    }
}

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Even{
    EvenChecker u;
    @BeforeEach
    public void setUp(){
        u=new EvenChecker();
    }
    // Parameterized Test - Even
    @ParameterizedTest
    @ValueSource(ints={2,4,6})
    @Order(1)
    public void testEvenTrue(int n){
        boolean result=u.isEven(n);
        System.out.println(n+" is "+(result?"Even":"Odd"));
        assertTrue(result);
    }
    // Parameterized Test - Odd
    @ParameterizedTest
    @ValueSource(ints={1,3,5})
    @Order(2)
    public void testEvenFalse(int n){
        boolean result=u.isEven(n);
        System.out.println(n+" is "+(result?"Even":"Odd"));
        assertFalse(result);
    }
    // Ordered Tests
    @Test
    @Order(3)
    public void testA(){
        System.out.println("A");
    }
    @Test
    @Order(4)
    public void testB(){
        System.out.println("B");
    }
    // Exception
    @Test
    @Order(5)
    public void testException(){
        assertThrows(IllegalArgumentException.class,()->u.throwError());
    }
    // Timeout
    @Test
    @Order(6)
    public void testTimeout(){
        assertTimeout(Duration.ofMillis(1000),()->u.slowTask());
    }
}
