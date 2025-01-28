
import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        reverseArray(happiness);
        long maxi=0;
        int cnt=0;
        for(int i=0;i<k;i++){
            maxi+=Math.max(happiness[i]-cnt,0);
            cnt++;
        }
        return maxi;
    }
    private void reverseArray(int[] happiness){
        int n=happiness.length;
        int i=0;
        int j=n-1;
        while(i<j){
            int temp=happiness[i];
            happiness[i]=happiness[j];
            happiness[j]=temp;
            i++;
            j--;
        }
    }
}