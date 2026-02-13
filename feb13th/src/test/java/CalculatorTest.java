import org.junit.jupiter.api.Test;
import org.zeta.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class CalculatorTest {
    Calculator a;
    @Test
    public void testAdd() {
        int res = Calculator.addInteger(Integer.MAX_VALUE, 3);
        assertEquals(Integer.MAX_VALUE, res);
    }
    @Test
    public void testAdd10() {
        int res = Calculator.addInteger(1, 3);
        assertEquals(Integer.MAX_VALUE, res);
    }

    @Test
    public void testAddNegative() {
        int res = Calculator.addInteger(-2, 3);
        assertEquals(1, res);
    }
    @Test
    public void testAddLargeNumber() {
        int res = Calculator.addInteger(99999999, 9999999);
        assertEquals(109999998, res);
    }
@Test
    public void divideByZero() {
        try{
            Calculator.divideInteger(1,0);
        }catch (ArithmeticException e){
            assertEquals(ArithmeticException.class,e.getClass());
        }
        //assertThrowsExactly(ArithmeticException.class,()->Calculator.divideInteger(10,0));
    }
}
