package small.problems.fibonacci;

public class RecursiveFibonacciCalculator implements FibonacciCalculator{

    long methodCalls;

    @Override
    public long resultFor(long input) {
        methodCalls += 1;
        if (input < 0) throw new IllegalArgumentException("Can't apply Fibonacci function to a negative number");
        if (input < 2) return input;
        else return resultFor(input - 1) + resultFor(input - 2);
    }

    @Override
    public long numberOfMethodCalls() {
        return methodCalls;
    }

    @Override
    public void reset() {
        methodCalls = 0;
    }
}
