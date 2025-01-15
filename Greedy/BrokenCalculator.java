package Greedy;

/**
 * This class provides a solution for the "Broken Calculator" problem.
 * The objective is to transform a `startValue` into a `target` value using the minimal number of operations.
 */
class Solution {

    /**
     * Solves the "Broken Calculator" problem using a recursive approach.
     * 
     * Operations allowed:
     * 1. Multiply the current value by 2.
     * 2. Subtract 1 from the current value.
     * 
     * The goal is to minimize the number of operations to transform `startValue` into `target`.
     * 
     * @param startValue The initial value of the calculator.
     * @param target The target value to reach.
     * @return The minimum number of operations required to reach the target from the startValue.
     */
    public int brokenCalc(int startValue, int target) {
        // If the startValue is greater than or equal to the target, we can only decrement to reach the target.
        if (startValue >= target) {
            return startValue - target;
        }

        // If the target is even, it's more efficient to divide it by 2 (reverse of multiplication).
        if (target % 2 == 0) {
            return 1 + brokenCalc(startValue, target / 2);
        }

        // If the target is odd, add 1 to make it even, and then continue.
        return 1 + brokenCalc(startValue, target + 1);
    }
}

