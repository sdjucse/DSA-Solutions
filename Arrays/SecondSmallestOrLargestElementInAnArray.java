package Arrays;
/*
     * Time Complexity: O(N) where N is the length of the array.
     * Space Complexity: O(1) for the max variable.
     */
public class SecondSmallestOrLargestElementInAnArray {
    int min=Integer.MAX_VALUE;
        int second_min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int second_max=Integer.MIN_VALUE;
    public int getSecondSmallest(int[] arr) {
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i]);
        }
        for(int i=0;i<n;i++){
            
            if(arr[i]<second_min && arr[i]!=min){
                second_min=arr[i];
            }
        }
        return second_min;
    }

    public int getSecondLargest(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){ 
            max=Math.max(max,arr[i]);
        }
        for(int i=0;i<n;i++){
        if(arr[i]>second_max && arr[i]!=max){
        second_max=arr[i];
        }
    }
    return second_max;
    }
}
