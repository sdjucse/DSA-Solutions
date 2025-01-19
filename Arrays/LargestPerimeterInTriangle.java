package Arrays;

import java.util.Arrays;

public class LargestPerimeterInTriangle {
    public int largestPerimeter(int[] nums) {
        // Step 1: Sort the array in ascending order.
        Arrays.sort(nums);
        
        // Step 2: Start from the largest possible triplet and check triangle inequality.
        int n = nums.length;
        for (int i = n - 3; i >= 0; i--) {
            // Check if the three sides can form a valid triangle.
            if (nums[i] + nums[i+1] > nums[i+2]) {
                // Return the perimeter of the triangle.
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }
        
        // Step 3: If no valid triangle is found, return 0.
        return 0;
    }
}
