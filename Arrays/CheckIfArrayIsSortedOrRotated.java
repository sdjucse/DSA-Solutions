
import java.util.Arrays;



public class CheckIfArrayIsSortedOrRotated{
    //Approach-1 (Super Brute Force)
    //T.C : O(n^2)
    //S.C : O(n)
    public boolean check(int[] nums) {
        int n=nums.length;
        int [] sortedArr= new int[n];

        for(int r=0;r<n;r++){
            int idx=0;
            for(int i=r;i<n;i++){
                sortedArr[idx]=nums[i];
                idx++;
            }
            for(int i=0;i<r;i++){
                sortedArr[idx]=nums[i];
                idx++;
            }
            boolean isSorted=true;
            for(int i=0;i<n-1;i++){
                if(sortedArr[i]>sortedArr[i+1]){
                    isSorted=false;
                    break;
                }
            }
            if(isSorted){
                return  true;
            }

        }
        return false;

    }
    //Approach-2 (Better Brute Force)
    //T.C : O(n^2)
    //S.C : O(n)
    public boolean check1(int[] nums) {
        int n=nums.length;
        int []sortedArr= nums.clone();
        Arrays.sort(sortedArr);
        for(int i=0;i<n;i++){
            boolean isSorted=true;
            for(int j=0;j<n;j++){
                if(sortedArr[j]!=nums[(i+j)%n]){
                    isSorted=false;
                    break;
                }
            }
            if(isSorted){
                return true;
            }

        }
        return false;
    }

   //Approach-3 (Optimal)
    //T.C : O(n)
    //S.C : O(1)
    public boolean check2(int[]nums){
        int n = nums.length;

        int peak = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                peak++;
            }
        }

        return peak <= 1;

    }
}