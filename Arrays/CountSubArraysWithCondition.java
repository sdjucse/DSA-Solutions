package Arrays;

public class CountSubArraysWithCondition {
    public int countSubArrays(int[]nums){
        int n=nums.length;
        int cnt=0;
        for(int i=1;i<n;i++){
            if(nums[i]==(nums[i-1]+nums[i+1])*2){
                cnt++;
            }
        }
        return cnt;
    }
}
