package Greedy;

/**
 * This class provides a solution to minimize the cost of removing adjacent balloons of the same color.
 */
class Solution {

    /**
     * Finds the minimum total time required to make the string of balloons have no two adjacent balloons of the same color.
     * 
     * @param colors A string where each character represents the color of a balloon.
     * @param neededTime An integer array where `neededTime[i]` is the time needed to remove the `i-th` balloon.
     * @return The minimum total time to make the balloons string valid.
     */
    public int minCost(String colors, int[] neededTime) {
        int totaltime = 0;   // To store the total time required.
        int currMax = 0;     // To store the maximum removal time of the current group of balloons.
        int n = colors.length(); // Length of the colors string.

        // Iterate through each balloon in the string.
        for (int i = 0; i < n; i++) {
            // If the current balloon's color is different from the previous one, reset `currMax`.
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                currMax = 0;
            }

            // Add the smaller of the current maximum or the current balloon's removal time to the total time.
            totaltime += Math.min(currMax, neededTime[i]);

            // Update `currMax` to the larger of its current value or the current balloon's removal time.
            currMax = Math.max(currMax, neededTime[i]);
        }

        return totaltime; // Return the total minimum time required.
    }
}
