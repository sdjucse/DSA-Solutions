import java.util.*;

public class SumofSubArrayMins_bruteforce {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Sum of subarray mins for nums array: " + solution.sumOfSubArrayMins(nums));
    }
}

class Solution {
    public int sumOfSubArrayMins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = i; j < nums.length; j++) {
                x = Math.min(nums[j], x);
                sum += x;
            }
        }
        return (int) (sum % (Math.pow(10, 9) + 7));
    }
}
