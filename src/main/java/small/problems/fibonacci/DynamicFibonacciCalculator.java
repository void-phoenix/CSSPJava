package small.problems.fibonacci;

public class DynamicFibonacciCalculator implements FibonacciCalculator {

    long methodCalls;

    @Override
    public long resultFor(long input) {
        if (input < 0) throw new IllegalArgumentException("Can't apply Fibonacci function to a negative number");
        long last = 0, next = 1;
        for (long i = 0; i < input; i++) {
            methodCalls += 1;
            final long temp = last;
            last = next;
            next = temp + last;
        }
        return last;
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
