package Arrays;

public class MoveZeroesToEnd {
    /*
     * Time Complexity: O(N) where N is the length of the array.
     * Space Complexity: O(N) for the max variable.
     */
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int count = 0; // Count of non-zero elements

        // Traverse the array and move non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count++] = arr[i]; // Move non-zero element to the front
            }
        }

        // Fill remaining positions with zeroes
        while (count < n) {
            arr[count++] = 0;
        }
    }
    /*
     * Two pointer approach:
     * Time Complexity: O(N) where N is the length of the array.
     * Space Complexity: O(1) for the max variable.
     */
    public static int[] moveZeros(int n, int []a) {
        int j = -1;
        //place the pointer j:
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                j = i;
                break;
            }
        }

        //no non-zero elements:
        if (j == -1) return a;

        //Move the pointers i and j
        //and swap accordingly:
        for (int i = j + 1; i < n; i++) {
            if (a[i] != 0) {
                //swap a[i] & a[j]:
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                j++;
            }
        }
        return a;
    }
}
