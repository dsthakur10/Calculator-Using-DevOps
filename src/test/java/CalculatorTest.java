import calculator.Calculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calculator = new Calculator();

    @Test
    public void powerTruePositive(){
        assertEquals("Calculating power for True Positive", 27, calculator.power(3, 3), DELTA);
        assertEquals("Calculating power for True Positive", 248832, calculator.power(12, 5), DELTA);
    }

    @Test
    public void powerTrueNegative(){
        assertNotEquals("Calculating power for True Negative", 0.69, calculator.power(2, -5), DELTA);
        assertNotEquals("Calculating power for True Negative", -205, calculator.power(-20, 5), DELTA);
    }

    @Test
    public void factorialTruePositive(){
        assertEquals("Calculating factorial for True Positive", 120, calculator.factorial(5), DELTA);
        assertEquals("Calculating factorial for True Positive", 1, calculator.factorial(0), DELTA);
    }

    @Test
    public void factorialTrueNegative(){
        assertNotEquals("Calculating factorial for True Negative", 100, calculator.factorial(6), DELTA);
        assertNotEquals("Calculating factorial for True Negative", 870, calculator.factorial(9), DELTA);
    }

    @Test
    public void logETruePositive(){
        assertEquals("Calculating natural log for True Positive", 0, calculator.logE(1), DELTA);
        assertEquals("Calculating natural log for True Positive", 5.703782474656201, calculator.logE(300), DELTA);
    }

    @Test
    public void logETrueNegative(){
        assertNotEquals("Calculating natural log for True Negative", 3.598, calculator.logE(6.8), DELTA);
        assertNotEquals("Calculating natural log for True Negative", 10, calculator.logE(20.7), DELTA);
    }

    @Test
    public void squareRootTruePositive(){
        assertEquals("Calculating square root for True Positive", 12, calculator.squareRoot(144), DELTA);
        assertEquals("Calculating square root for True Positive", 555, calculator.squareRoot(308025), DELTA);
    }

    @Test
    public void squareRootTrueNegative(){
        assertNotEquals("Calculating square root for True Negative", 0, calculator.squareRoot(3), DELTA);
        assertNotEquals("Calculating square root for True Negative", -8, calculator.squareRoot(64), DELTA);
    }


}
