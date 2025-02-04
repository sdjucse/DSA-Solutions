/*
 * Brute Force
 * T.C:- O(N^2)
 * S.C:- O(1)
 */

 class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxsum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=nums[i];
            int j=i+1;
            while(j<n && nums[j]>nums[j-1]){
                sum+=nums[j];
                j++;
            }
            maxsum=Math.max(sum,maxsum);
        }
        return maxsum;
    }
    /*
 * Optimized
 * T.C:O(N)
 * S.C:O(1)
 */

 public int maxAscendingSum1(int[] nums) {
    int maxsum=0;
    int n=nums.length;
    int sum=nums[0];
    for(int i=1;i<n;i++){
       
        if(nums[i]>nums[i-1]){
             sum+=nums[i];
        }
        else{
            maxsum=Math.max(sum,maxsum);
            sum=nums[i];
        }
        
    }
    maxsum=Math.max(sum,maxsum);
    return maxsum;
}
}
