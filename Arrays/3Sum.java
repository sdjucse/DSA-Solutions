package Arrays;

import java.util.*;
/*
 * Two Pointer Approach
 * T.C:-O(N^2)
 * S.C:-O(N)
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // Initialize result list to store triplets.
        Arrays.sort(nums); // Sort the array to make it easier to use two-pointer technique.

        // Iterate through the array to fix the first element of the triplet.
        for (int i = 0; i < nums.length; i++) {
            // Skip duplicate elements to avoid duplicate triplets.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j = i + 1; // Pointer for the second element of the triplet.
            int k = nums.length - 1; // Pointer for the third element of the triplet.

            // Use two pointers to find pairs that sum to -nums[i].
            while (j < k) {
                int total = nums[i] + nums[j] + nums[k]; // Calculate the sum of the triplet.

                if (total > 0) {
                    k--; // If the sum is too large, move the right pointer left to decrease the sum.
                } else if (total < 0) {
                    j++; // If the sum is too small, move the left pointer right to increase the sum.
                } else {
                    // Add the triplet to the result list if the sum is zero.
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++; // Move the left pointer to the next position.

                    // Skip duplicate values for the second element of the triplet.
                    while (nums[j] == nums[j - 1] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res; // Return the list of unique triplets.
    }
}
