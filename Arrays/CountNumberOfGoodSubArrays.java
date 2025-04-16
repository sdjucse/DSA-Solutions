package Arrays;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfGoodSubArrays {
    public long countGood(int[]nums,int k){
        int n=nums.length;
        long cnt=0;
        long pairs=0;
        Map<Integer,Integer>map=new HashMap<>();
        int i=0,j=0;
        while(j<n){
            pairs+=map.getOrDefault(nums[j],0);
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
        }
        while(pairs>=k){
            cnt+=n-j;
            map.put(nums[i],map.get(nums[i])-1);
            pairs-=map.getOrDefault(nums[i],0);
            i++;
        }
        j++;


        return cnt;
    }
}
