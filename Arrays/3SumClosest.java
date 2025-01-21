package Arrays;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array to use the two-pointer technique effectively.
        int closestSum = Integer.MAX_VALUE; // Initialize the closest sum to the maximum possible value.

        // Iterate through the array, fixing one number at a time.
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1; // Pointer for the second number.
            int r = n - 1; // Pointer for the third number.

            // Use two pointers to find the closest sum for the fixed number nums[i].
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r]; // Calculate the current triplet's sum.

                // Update the closest sum if the current sum is closer to the target.
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                // Adjust the pointers based on the comparison of the sum with the target.
                if (sum > target) {
                    r--; // Move the right pointer left to decrease the sum.
                } else {
                    l++; // Move the left pointer right to increase the sum.
                }
            }
        }
        return closestSum; // Return the closest sum found.
    }
}
