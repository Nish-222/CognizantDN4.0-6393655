import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

class Calc{
    public int add(int a,int b){return a+b;}
    public int subtract(int a,int b){return a-b;}
    public int multiply(int a,int b){return a*b;}
    public int divide(int a,int b){return b==0?0:a/b;}
}

public class Calculator{
    Calc calc;
    @Before
    public void setUp(){
        System.out.println("Before test");
        calc=new Calc();
    }
    @After
    public void tearDown(){
        System.out.println("After test");
        calc=null;
    }
    @Test
    public void testAdd(){
    	System.out.println("In add");
        assertEquals(5,calc.add(2,3));
    }
    @Test
    public void testSubtract(){
    	System.out.println("In subt");
        assertEquals(1,calc.subtract(4,3));
    }
    @Test
    public void testMultiply(){
    	System.out.println("In mult");
        assertEquals(12,calc.multiply(3,4));
    }
    @Test
    public void testDivide(){
    	System.out.println("In div");
        assertEquals(2,calc.divide(6,3));
        assertEquals(0,calc.divide(6,0));
    }
    @Test
    public void testAssertions(){
        assertEquals(5,2+3);
        assertTrue(4<5);
        assertFalse(5<3);
        assertNull(null);
        assertNotNull(new Object());
    }
}
