


//Approach-1 (Using Binary Search) - T.C : O(logn)


class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        int mid;
        while(left<right){
            mid=left+(right-left)/2;
            if(arr[mid]>arr[mid+1]){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;    
    }
}

//Approach-2 (Using Linear Search) - T.C : O(n)//


class Solution1 {
        int peakIndexInMountainArray(int[] arr) {
            int n = arr.length;
            
            int i = 0;
           //You can remove i < n-1 check because array is gauranteed to be Mountain (given in qn)
            while(i < n-1 && arr[i] < arr[i+1])
                i++;
            
            return i;
        }
    };