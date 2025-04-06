package Arrays;

public class MaximumSubArraySumofSizeK {
    public static int maxSum(int arr[],int k){
        int n=arr.length;
        int l=0;
        int r=k;
        int window_sum=0;
        int max_sum=0;
        for(int i=0;i<k;i++){
            window_sum+=arr[i];
        }
        max_sum=window_sum;
        while(r<n){
            window_sum-=arr[l];
            l++;
            window_sum+=arr[r];
            r++;
            max_sum=Math.max(max_sum,window_sum);
        }
        return max_sum;
    }
}
