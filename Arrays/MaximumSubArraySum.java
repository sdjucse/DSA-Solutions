
public class MaximumSubArraySum {
    /*
     * Approach:
     * 1. Initialize a variable `maxi` to Long.MIN_VALUE to keep track of the maximum sum.
     * 2. Initialize a variable `sum` to 0 to keep track of the current sum.
     * 3. Iterate through the array:
     *   - Add the current element to `sum`.
     *  - If `sum` is greater than `maxi`, update `maxi` to `sum`.
     *  - If `sum` becomes negative, reset it to 0.
     * 4. Return `maxi` as the result.
     *  * Time Complexity: O(N) where N is the length of the array.
     * Space Complexity: O(1) for the sum variable.
     */
    public static long maxSubarraySum(int[] arr, int n) {
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
            }   

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxi < 0) maxi = 0;

        return maxi;
    }
}