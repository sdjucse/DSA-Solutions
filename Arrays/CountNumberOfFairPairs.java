package Arrays;

import java.util.Arrays;

public class CountNumberOfFairPairs {
    int lowerBounds(int[]nums,int start,int end,int target){
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
    }
    int upperBounds(int[]nums,int start,int end,int target){
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<=target){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
    }
    public long CountNumberOfFairPairs(int [] nums,int lower,int upper){
        int n=nums.length;
        int res=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int leftind=lowerBounds(nums, i+1, n, lower-nums[i]);
            int rightind=upperBounds(nums, i, n, upper-nums[i]);
            int x=leftind-1-i;
            int y=rightind-1-i;
            res+=(y-x);
        }
        return res;
         
    }
}
