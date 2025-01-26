class Solution {

    // Variable to store the sum of digits (used in Brute Force).
    private int sum = 0;

    /**
     * Add digits of a number using either the Brute Force or Mathematical approach.
     * @param num The input number.
     * @param useMathApproach Boolean flag to choose the approach:
     *                        - `true` for Mathematical Approach
     *                        - `false` for Brute Force Approach
     * @return The single-digit result.
     */
    public int addDigits(int num, boolean useMathApproach) {
        if (useMathApproach) {
            // Mathematical Approach
            if (num == 0) return 0;
            if (num % 9 == 0) return 9;
            return num % 9;
        } else {
            // Brute Force Approach
            while (getCountDigits(num) > 1) {
                num = sum;
            }
            return sum;
        }
    }

    /**
     * Helper method to calculate the sum of digits and count the digits in a number.
     * @param num The input number.
     * @return The number of digits in the number.
     */
    private int getCountDigits(int num) {
        sum = 0; // Reset the sum for each calculation.
        int count = 0; // Counter for digits.

        // Loop to calculate the sum of digits and count the digits.
        while (num > 0) {
            sum += num % 10; // Add the last digit to the sum.
            num /= 10; // Remove the last digit.
            count++; // Increment the digit count.
        }
        return count; // Return the count of digits.
    }
}
