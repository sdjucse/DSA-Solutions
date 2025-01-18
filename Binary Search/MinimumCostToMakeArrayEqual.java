import java.util.Arrays;

class Solution {
    
    // Helper method to calculate the total cost of converting all elements to a target value.
    private long getCost(int[] nums, int[] cost, int target) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            // Compute cost for each element as |nums[i] - target| * cost[i]
            res += (long) Math.abs(nums[i] - target) * cost[i];
        }
        return res;
    }
    
    public long minCost(int[] nums, int[] cost) {
        long answer = Long.MAX_VALUE;

        // Determine the range of potential target values
        int left = Arrays.stream(nums).min().getAsInt();
        int right = Arrays.stream(nums).max().getAsInt();

        // Perform binary search to find the optimal target value
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Calculate costs for mid and mid + 1
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);

            // Update the minimum cost found so far
            answer = Math.min(cost1, cost2);

            // Adjust the search range based on cost comparison
            if (cost1 > cost2) {
                left = mid + 1; // Move to the right range
            } else {
                right = mid - 1; // Move to the left range
            }
        }

        // Return the minimum cost, or 0 if no valid answer
        return answer == Long.MAX_VALUE ? 0 : answer;
    }
}
