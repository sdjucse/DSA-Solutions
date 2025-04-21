package Arrays;

import java.util.HashSet;
import java.util.Set;
public class LongestConsecutiveSequenceInAnArray {
    public int LongestConsecutiveSequenceInAnArray(int[]nums){
        int n=nums.length;
        if(n==0){
            return 0;
        }
        int longest=1;
        Set<Integer>s=new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(nums[i]);
        }
        for(int i:s){
            if(!s.contains(i-1)){
                int cnt=1;
                int x=i;
                while(s.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
                longest=Math.max(longest,cnt);
            }
        }
        return longest;
    }
}