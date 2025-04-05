package Arrays;

public class LinearSearch {
    /*
     * Time Complexity: O(N) where N is the length of the array.
     * Space Complexity: O(1) for the max variable.
     */
    public int LinearSearch(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // Return -1 if the target is not found in the array
    }
}
