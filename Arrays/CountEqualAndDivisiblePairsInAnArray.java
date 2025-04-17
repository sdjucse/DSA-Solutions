public class CountEqualAndDivisiblePairsInAnArray {
    /*
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public static int countPairs(int[] nums, int k) {
        int n = nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j]&&((i*j)%k==0))
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}