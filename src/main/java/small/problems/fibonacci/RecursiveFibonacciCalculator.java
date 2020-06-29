package small.problems.fibonacci;

public class RecursiveFibonacciCalculator implements FibonacciCalculator{

    @Override
    public long resultFor(long input) {
        if (input < 0) throw new IllegalArgumentException("Can't apply Fibonacci function to a negative number");
        if (input < 2) return input;
        else return resultFor(input - 1) + resultFor(input - 2);
    }
}
