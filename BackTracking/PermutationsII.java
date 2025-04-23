package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>resultList=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(resultList,new ArrayList<>(),nums,new boolean[nums.length]);

        return resultList;
    }
    private void backtrack(List<List<Integer>>resultlist,ArrayList<Integer>tempList,int[]nums,boolean[] used){
        if(tempList.size()==nums.length &&!resultlist.contains(tempList)){
            resultlist.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            used[i]=true;
            tempList.add(nums[i]);
            backtrack(resultlist,tempList,nums,used);
            used[i]=false;
            tempList.remove(nums[i]);
        }
    }
}
