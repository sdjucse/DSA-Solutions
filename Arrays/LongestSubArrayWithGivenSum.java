package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {
    /*
     * Extreme Brute Force Approach:
     * Time Complexity: O(N^3) where N is the length of the array.
     * Space Complexity: O(1) for the max variable.
     */
    public static int getLongestSubarray(int []a, long k) {
        int n = a.length; // size of the array.

        int len = 0;
        for (int i = 0; i < n; i++) { // starting index
            for (int j = i; j < n; j++) { // ending index
                // add all the elements of
                // subarray = a[i...j]:
                long s = 0;
                for (int K = i; K <= j; K++) {
                    s += a[K];
                }

                if (s == k)
                    len = Math.max(len, j - i + 1);
            }
        }
        return len;
        /*
         * Optimal Approach:
         * Time Complexity: O(N^2) where N is the length of the array.
         * Space Complexity: O(1) for the max variable.
         */
        public static int getLongestSubarray1(int []a, long k) {
            int n = a.length; // size of the array.
    
            int len = 0;
            for (int i = 0; i < n; i++) { // starting index
                long s = 0; // Sum variable
                for (int j = i; j < n; j++) { // ending index
                    // add the current element to
                    // the subarray a[i...j-1]:
                    s += a[j];
    
                    if (s == k)
                        len = Math.max(len, j - i + 1);
                }
            }
            return len;



        /*
         * Approach-3: Using HashMap
         * Time Complexity: O(N) where N is the length of the array.
         * Space Complexity: O(N) for the HashMap.
         */
 public static int lenOfLongSubarr (int a[], int N, int k) {
        int n = a.length; // size of the array.

        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // if the sum = k, update the maxLen:
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // calculate the sum of remaining part i.e. x-k:
            long rem = sum - k;

            //Calculate the length and update maxLen:
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            //Finally, update the map checking the conditions:
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }
}

