package small.problems.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class RecursiveFibonacciCalculatorWithMemory implements FibonacciCalculator{

    private Map<Long, Long> knownAnswers = new HashMap<>();

    long methodCalls;

    @Override
    public long resultFor(long input) {
        methodCalls += 1;
        if (input < 0) throw new IllegalArgumentException("Can't apply Fibonacci function to a negative number");
        if (input < 2) return input;
        if (knownAnswers.containsKey(input)) return knownAnswers.get(input);
        knownAnswers.putIfAbsent(input, resultFor(input - 1) + resultFor(input - 2));
        return knownAnswers.get(input);
    }

    @Override
    public long numberOfMethodCalls() {
        return methodCalls;
    }

    @Override
    public void reset() {
        knownAnswers = new HashMap<>();
        methodCalls = 0;
    }
}
