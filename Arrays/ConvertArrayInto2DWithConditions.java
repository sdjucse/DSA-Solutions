package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayInto2DWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        // Initialize the result list and frequency array.
        ArrayList<List<Integer>> res = new ArrayList<>();
        int[] freq = new int[nums.length + 1]; 
        
        // Iterate through the input array.
        for (int i : nums) {
            // If the current frequency equals the size of the result list, add a new sublist.
            if (freq[i] == res.size()) {
                res.add(new ArrayList<>());
            }
            // Add the current element to the corresponding sublist.
            res.get(freq[i]).add(i);
            // Increment the frequency of the current element.
            freq[i]++;
        }
        
        // Return the constructed 2D list.
        return res;
    }
}
