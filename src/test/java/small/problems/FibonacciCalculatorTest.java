package small.problems;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import small.problems.fibonacci.DynamicFibonacciCalculator;
import small.problems.fibonacci.FibonacciCalculator;
import small.problems.fibonacci.RecursiveFibonacciCalculator;
import small.problems.fibonacci.RecursiveFibonacciCalculatorWithMemory;

import java.util.List;

/**
 * fib(n) = fib(n - 1) + fib(n - 2)
 *
 */
@RunWith(Parameterized.class)
public class FibonacciCalculatorTest {

    FibonacciCalculator calculator;

    public FibonacciCalculatorTest(FibonacciCalculator calculator) {
        this.calculator = calculator;
    }

    @Before
    public void resetStatistics() {
        calculator.reset();
    }

    @After
    public void showStatistics() {
        System.out.println("The calculator.resultFor method was called for " + calculator.numberOfMethodCalls() + " times");
    }

    @Parameterized.Parameters
    public static List<FibonacciCalculator> implementations() {
        return List.of(new RecursiveFibonacciCalculator(),
                new RecursiveFibonacciCalculatorWithMemory(),
                new DynamicFibonacciCalculator());
    }

    @Test
    public void testNegativeValue() { ;
        Assert.assertThrows(IllegalArgumentException.class, () -> calculator.resultFor(-1));
    }

    @Test
    public void testZero() {
        Assert.assertEquals(0, calculator.resultFor(0));
    }

    @Test
    public void testOne() {
        Assert.assertEquals(1, calculator.resultFor(1));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(1, calculator.resultFor(2));
    }

    @Test
    public void testFive() {
        Assert.assertEquals(5, calculator.resultFor(5));
    }

    @Test
    public void testEight() {
        Assert.assertEquals(21, calculator.resultFor(8));
    }

}
