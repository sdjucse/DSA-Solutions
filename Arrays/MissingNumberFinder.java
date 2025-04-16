package Arrays;

public class MissingNumberFinder {

    public static int findMissingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;

        // Cyclic sort
        while (i < n) {
            int correct = nums[i];
            if (correct < n && nums[i] != nums[correct]) {
                // swap nums[i] and nums[correct]
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                i++;
            }
        }

        // Find the missing number
        for (i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return n;
    }

}
