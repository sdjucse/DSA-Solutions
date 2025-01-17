package Arrays;

/**
 * This class provides a solution to find the number of ways to split an array
 * such that the sum of the left subarray is greater than or equal to the sum of the right subarray.
 */
class Solution {

    /**
     * Calculates the number of valid split points in the array where the sum of the left subarray 
     * is greater than or equal to the sum of the right subarray.
     *
     * @param nums An integer array representing the input array.
     * @return The number of valid splits.
     */
    public int waysToSplitArray(int[] nums) {
        // Initialize variables
        long sum = 0;         // The total sum of all elements in the array
        long rightSum = 0;    // The sum of elements in the right subarray
        long leftSum = 0;     // The sum of elements in the left subarray
        int cnt = 0;          // Counter for the number of valid splits
        int n = nums.length;  // Length of the array

        // Calculate the total sum of the array elements
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // Iterate through the array to calculate valid split points
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];        // Update the left subarray sum
            rightSum = sum - leftSum;  // Calculate the right subarray sum

            // Check if the left sum is greater than or equal to the right sum
            if (leftSum >= rightSum) {
                cnt++; // Increment the count of valid splits
            }
        }

        // Return the total count of valid splits
        return cnt;
    }
}
