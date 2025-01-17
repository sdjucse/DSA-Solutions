package Arrays;

class Solution {

    /**
     * Calculates the number of valid split points in the array where the sum of the left subarray 
     * is greater than or equal to the sum of the right subarray.
     *
     * @param nums An integer array representing the input array.
     * @return The number of valid splits.
     */
    public int waysToSplitArray(int[] nums) {
        int n = nums.length; // Length of the array

        // Calculate the total sum of the array elements
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Initialize variables for the left subarray sum and split count
        long leftSum = 0;
        int splitCount = 0;

        // Iterate through the array to calculate valid split points
        for (int i = 0; i < n - 1; i++) {
            // Add the current element to the left subarray sum
            leftSum += nums[i];

            // Calculate the right subarray sum
            long rightSum = totalSum - leftSum;

            // If the left sum is greater than or equal to the right sum, increment the split count
            if (leftSum >= rightSum) {
                splitCount++;
            }
        }

        // Return the total number of valid splits
        return splitCount;
    }
}
