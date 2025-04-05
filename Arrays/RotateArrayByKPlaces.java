package Arrays;

public class RotateArrayByKPlaces {
    /*
     * Using a temporary array to store the rotated elements.
     * Time Complexity: O(N) where N is the length of the array.
     * Space Complexity: O(k) for the temporary array.
     */
    public void rotateToRight(int[] arr,int k){
        int n=arr.length;
        if(n==0){
            return;
        }
        k=k%n;
        int [] temp=new int[k];
        for(int i=n-k;i<n;i++){
            temp[i-n+k]=arr[i];
        }
        for(int i=n-k-1;i>=0;i--){
            arr[i+k]=arr[i];
        }
        for(int i=0;i<k;i++){
            arr[i]=temp[i];
        }
    }
    public void rotateToLeft(int[] arr,int k){
        int n=arr.length;
        if(n==0){
            return;
        }
        k=k%n;
        int [] temp=new int[k];
        for(int i=0;i<k;i++){
            temp[i]=arr[i];
        }
        for(int i=k;i<n;i++){
            arr[i-k]=arr[i];
        }
        for(int i=n-k;i<n;i++){
            arr[i]=temp[i-n+k];
        }
    }
    /*
     * Using the reverse method to rotate the array.
     * Time Complexity: O(N) where N is the length of the array.
     *  Space Complexity: O(1) for the array.
     */

     public void Reverse(int[] arr, int start,int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
     }
     public void rotateToRightUsingReverse(int[]arr, int k){
        int n=arr.length;
        if(n==0){
            return;
        }
        k=k%n;
        Reverse(arr,0,n-k);
        Reverse(arr,n-k,n-1);
        Reverse(arr,0,n-1);
     }
     

}
