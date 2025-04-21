package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>>permute(int[]nums){
        List<List<Integer>>resultList=new ArrayList<>();
        backstrack(resultList,new ArrayList<>(),nums);
        return resultList;
    }
    private void backstrack(List<List<Integer>>resultList,ArrayList<Integer>tempList,int[] nums){
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
          }
        for(int number:nums){
            if(tempList.contains(number)){
                continue;
            }
         tempList.add(number);
         backstrack(resultList,tempList,nums);
         tempList.remove(tempList.size()-1);   
        }
    }
}
