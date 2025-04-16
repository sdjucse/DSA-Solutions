package Arrays;
import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer>findMissingNumbers(int[] nums){
        int n=nums.length;
        List<Integer>missingNumbers=new ArrayList<>();
        int i=0;
        while(i<n){
            int ind=nums[i]-1;
            if(nums[i]!=nums[ind]){
                int temp=nums[i];
                nums[i]=nums[ind];
                nums[ind]=temp;
            }
            else{
                i++;
            }
        }
        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                missingNumbers.add(i+1);
            }
        }


        return missingNumbers;
    }
}
