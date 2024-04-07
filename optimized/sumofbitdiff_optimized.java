package optimized;

import java.util.Scanner;

public class sumofbitdiff_optimized {
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

        System.out.println("Sum of subarray mins for nums array: " + solution.sumBitDifferences_optmized(nums, n));
        sc.close();
    }
}

// idea is to take all the possible subarrays and thus vheck using bitwise or
// and increment count by 1
class Solution {
    public long sumBitDifferences_optmized(int[] arr, int n) {
        long ans = 0;

        for (int i = 0; i < 32; i++) {
            long count = 0;

            for (int j = 0; j < n; j++) {
                // at each position, find the set bit
                if ((arr[j] & (1 << i)) != 0) {
                    count++;
                }
            }
            ans += count * (n - count) * 2;
        }
        return ans;
    }
}
