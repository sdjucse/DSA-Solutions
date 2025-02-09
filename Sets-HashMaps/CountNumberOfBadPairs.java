import java.util.*;

 public class CountNumberOfBadPairs{
/*
 * //Approach-1 (Brute Force)
 * T.C:-O(N^2)
 * S.C:-O(1)
 */
    public long countBadPairs(int[] nums) {
        long res=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(j-i!=nums[j]-nums[i]){
                    res++;
                }
            }
        }
        return res;
    }
/*
 * Approach-2(Using Map)
 * T.C:- O(N)
 * S.C:- O(N)
 */
public long countBadPairs1(int[] nums){
    long cnt=0;
    int n=nums.length;
    for(int i=0;i<n;i++){
        nums[i]=nums[i]-i;
    }
    HashMap<Integer,Integer>hp=new HashMap<>();
    hp.put(nums[0],1);
    for(int j=1;j<n;j++){
        int countofNumsj=hp.getOrDefault(nums[j],0);
        int totalNumsBeforej=j;
        int badPairs=totalNumsBeforej-countofNumsj;
        cnt+=badPairs;
        hp.put(nums[j],countofNumsj+1);
    }
    return cnt;
}
/*
 * Approach-3(Using Map)
 * T.C:- O(N)
 * S.C:- O(N)
 */
public long countBadPairs2(int[] nums){
    int n=nums.length;
    long res=0;
    HashMap<Integer,Integer>mp=new HashMap<>();
    for(int i=0;i<n;i++){
        int diff=nums[i]-i;
        int totalTillNow=i;
        int goodPairs=mp.getOrDefault(diff,0);
        res+=(totalTillNow-goodPairs);
        mp.put(diff,goodPairs+1);

    }
    return res;
}
 }