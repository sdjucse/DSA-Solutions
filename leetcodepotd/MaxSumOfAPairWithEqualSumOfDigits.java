import java.util.*;
public class MaxSumOfAPairWithEqualSumOfDigits{
    /*
     * Brute Force
     * T.C:-O(N^2*m)
     * S.C:-O(1)
     */
    public int getDigitSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }

    public int maximumSum_bruteforce(int[] nums){
        int n=nums.length;
        int res=-1;
        for(int i=0;i<n;i++){
            int digitSumi=getDigitSum(nums[i]);
            for(int j=i+1;j<n;j++){
                int digitSumj=getDigitSum(nums[j]);
                if(digitSumi==digitSumj){
                    res=Math.max(res,nums[i]+nums[j]);
                }
            }
        }



        return res;
    }
    /*
     * Better Approach
     * T.C:O(N*m)
     * S.C:-O(N)
     */
    public int maximumSum_better(int[] nums){
        int n =nums.length;
        int res=-1;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int digitSum=getDigitSum(nums[i]);
            if(map.containsKey(digitSum)){
                res=Math.max(res,nums[i]+map.get(digitSum));
            }
            map.put(digitSum,Math.max(map.getOrDefault(digitSum,0),nums[i]));
        }
        return res;
    }
    /*
     * Best Amongst All
     * T.C:-O(N*m)
     * S.C:O(1)
     */
    public int maximumSum_best(int[] nums){
        int n=nums.length;
        int res=-1;
        int []mp=new int[82]; 
        for(int i=0;i<n;i++){
            int digitSum=getDigitSum(nums[i]);
            if(mp[digitSum]>0){
                res=Math.max(res,nums[i]+mp[digitSum]);
            }
            mp[digitSum]=Math.max(mp[digitSum],nums[i]);
        }
        return res;
    }

}