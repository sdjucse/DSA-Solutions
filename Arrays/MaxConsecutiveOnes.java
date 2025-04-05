package Arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCnt=0;
        int count=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
            }
            else{
                count=0;
            }
            maxCnt=Math.max(maxCnt,count);
        }
        return maxCnt;
    }

}
