package Arrays;

public class MaximumSubArrayAverage {
    public double findMaxAverage(int[] nums, int k) {
        int  n=nums.length;
        int l=0;
        int r=k;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        int max_sum=sum;
        while(r<n){
            sum-=nums[l];
            l++;
            sum+=nums[r];
            r++;
            max_sum=Math.max(sum,max_sum);
        }
        return (double)max_sum/k;   
    }
}
