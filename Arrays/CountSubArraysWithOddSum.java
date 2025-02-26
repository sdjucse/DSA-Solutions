
import java.util.*;


public class CountSubArraysWithOddSum{
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;
        int M = (int)1e9 + 7;
        int[]  pre = new int[n];
        pre[0]=arr[0];
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]+arr[i];
        }
        int cnt=0;
        int odd=0;
        int even=1;
        for(int i=0;i<n;i++){
            if(pre[i]%2==0){
                cnt=(cnt+odd)%M;
                even++;
            }
            else{
                cnt=(cnt+even)%M;
                odd++;
            }
        }
        return cnt;
    }
}