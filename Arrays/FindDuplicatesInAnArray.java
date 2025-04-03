

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicatesInAnArray {
   public List<Integer> findDuplicates(int[] nums) {
    Map<Integer, Integer> countMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    // Count occurrences of each number
    for (int num : nums) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    // Find elements that appear exactly twice
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
        if (entry.getValue() == 2) {
            result.add(entry.getKey());
        }
    }
    
    return result;
    } 
}
