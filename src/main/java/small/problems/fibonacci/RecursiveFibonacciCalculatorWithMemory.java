package small.problems.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class RecursiveFibonacciCalculatorWithMemory implements FibonacciCalculator{

    private Map<Long, Long> knownAnswers = new HashMap<>();

    @Override
    public long resultFor(long input) {
        if (input < 0) throw new IllegalArgumentException("Can't apply Fibonacci function to a negative number");
        if (input < 2) return input;
        if (knownAnswers.containsKey(input)) return knownAnswers.get(input);
        long result = resultFor(input - 1) + resultFor(input - 2);
        knownAnswers.putIfAbsent(input, result);
        return result;
    }
}
