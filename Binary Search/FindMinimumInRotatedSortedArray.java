/**
 * This class provides a solution to find the minimum element in a rotated sorted array.
 */
class Solution {

    /**
     * Finds the minimum element in a rotated sorted array.
     *
     * @param arr An integer array that was originally sorted in ascending order but then rotated.
     *            It is guaranteed that no duplicate elements exist in the array.
     * @return The minimum element in the array.
     */
    public int findMin(int[] arr) {
        int n = arr.length; // Get the length of the array.
        int l = 0;          // Left pointer, initially at the start of the array.
        int r = n - 1;      // Right pointer, initially at the end of the array.

        // Perform binary search to locate the minimum element.
        while (l < r) {
            int mid = l + (r - l) / 2; // Calculate the mid-point to prevent overflow.

            // If the mid element is greater than the rightmost element,
            // the minimum must be in the right part of the array.
            if (arr[mid] > arr[r]) {
                l = mid + 1;
            }
            // Otherwise, the minimum is in the left part (or could be mid itself).
            else {
                r = mid;
            }
        }

        // After the loop, the left pointer will point to the minimum element.
        return arr[l];
    }
}
