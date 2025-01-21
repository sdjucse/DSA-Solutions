package Arrays;

//Using two pointer approach
//T.C:-O(n)
//S.C:-O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Initialize two pointers: one at the start, the other at the end.
        int i = 0, j = numbers.length - 1;

        // Loop until the pointers meet.
        while (i < j) {
            // Calculate the sum of the elements at the two pointers.
            if (numbers[i] + numbers[j] == target) {
                // If the sum matches the target, return the 1-based indices.
                return new int[]{i + 1, j + 1};
            } else if (numbers[i] + numbers[j] > target) {
                // If the sum is too large, move the right pointer left to decrease the sum.
                j--;
            } else {
                // If the sum is too small, move the left pointer right to increase the sum.
                i++;
            }
        }

        // If no valid pair is found, return [0, 0].
        return new int[]{0, 0};
    }
}
