package Arrays;

public class CheckIfAnArrayIsSorted {
    /*
     * Time Complexity: O(N)
        Space Complexity: O(1)
     */
    static boolean isSorted(int arr[], int n) {
        for (int i = 1; i < n; i++) {
          if (arr[i] < arr[i - 1])
            return true;
        }
    
        return false;
      }
}
