package Arrays;

import java.util.HashMap;
import java.util.Map;

//Approach-1 (Using two for loops..The traditional approach)
//T.C : O(n^2)
//S.C : O(1)
public class TwoSum {
    public int[] TwoSumIndex(int[]nums,int target){
        int[]tsi=new int[2];
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    tsi[0]=i;
                    tsi[1]=j;
                    break;
                }
            }
        }
        return tsi;
    }
}
//Approach-2 (Using one for loop..Using Map)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Step 1: Create a HashMap to store numbers and their indices.
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length;

        // Step 2: Iterate through the array.
        for (int i = 0; i < n; i++) {
            // Calculate the complement.
            int r = target - nums[i];

            // Step 3: Check if the complement exists in the HashMap.
            if (mp.containsKey(r)) {
                // If found, return the indices of the two numbers.
                return new int[]{mp.get(r), i};
            }

            // Step 4: Otherwise, add the current number and its index to the HashMap.
            mp.put(nums[i], i);
        }

        // Step 5: If no pair is found, return an empty array.
        return new int[]{};
    }
}
