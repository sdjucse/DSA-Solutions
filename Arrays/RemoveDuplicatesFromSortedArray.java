
import java.util.HashSet;




public class RemoveDuplicatesFromSortedArray {
    /* Brute Force
 * //T.C : O(nlog(n))+O(n)
    //S.C : O(n)
 */
    public  int removeDuplicates1(int[] arr) {
        HashSet < Integer > set = new HashSet < > ();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x: set) {
            arr[j++] = x;
        }
        return k;
    }
     //Optimized Approach//
//T.C : O(n)
//S.C : O(1)
public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    int i = 0, j = 1;

    while (j < n) {
        if (nums[i] != nums[j]) {
            nums[++i] = nums[j];
        }
        j++;
    }

    return i + 1;
}
}