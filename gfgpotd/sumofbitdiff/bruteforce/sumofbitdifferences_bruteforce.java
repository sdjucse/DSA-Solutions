import java.util.Scanner;

public class sumofbitdifferences_bruteforce {
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

        System.out.println("Sum of subarray mins for nums array: " + solution.sumofbitDifferences_bruteforce(nums, n));
        sc.close();
    }
}

// idea is to take all the possible subarrays and thus vheck using bitwise or
// and increment count by 1
class Solution {
    public long sumofbitDifferences_bruteforce(int arr[], int n) {
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = arr[i] ^ arr[j];
                cnt += Integer.bitCount(tmp);
            }
        }
        return cnt;
    }
}
