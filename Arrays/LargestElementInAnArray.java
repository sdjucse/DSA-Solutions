package Arrays;

public class LargestElementInAnArray {
    /*
     * Time Complexity: O(N) where N is the length of the array.
     * Space Complexity: O(1) for the max variable.
     */
    public int LargestElementInAnArray(int[] arr){
        int n=arr.length;
        int max=arr[0];
        for(int i=1;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
}
