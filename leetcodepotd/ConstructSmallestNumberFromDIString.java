
import java.util.*;
public class ConstructSmallestNumberFromDIString{
    /*
 * Brute Force[Finding All Possible Permutations and checking]
 * T.C:-O(n*(n+1)!)
 * S.C:-O(n+1)
 */
private boolean matchesPattern(String nums,String pattern){
    for(int i=0;i<pattern.length();i++){
        if(pattern.charAt(i)=='I'&& nums.charAt(i)>nums.charAt(i+1)||pattern.charAt(i)=='D' && nums.charAt(i)<nums.charAt(i+1)){
            return false;
        }
    }
    return true;
}
private void  nextPermutation(char[] nums){
    int i=nums.length-2;
    while(i>=0 && nums[i]>=nums[i+1]){
        i--;
    }
    if(i>=0){
        int j=nums.length-1;
        while(nums[j]<=nums[i]){
            j--;
        }
        swap(nums,i,j);
    }
    reverse(nums,i+1);

}
private void swap(char[] num, int i, int j) {
    char temp = num[i];
    num[i] = num[j];
    num[j] = temp;
}

private void reverse(char[] num, int start) {
    int end = num.length - 1;
    while (start < end) {
        swap(num, start++, end--);
    }
}
    public String smallestNumber(String pattern) {
        int n=pattern.length();
        char [] nums = new char[n+1];
        for(int i=0;i<n;i++){
            nums[i] = (char) ('1' + i);
        }
        while(!matchesPattern(new String(nums),pattern)){
            nextPermutation(nums);
        }


        return new String(nums);

    }
       /*
        * Optimized[Using STACK]
        * T.C:-O(n)
        * S.C:-O(n)
        */
        public String smallestNumber1(String pattern){
            int n = pattern.length();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int counter = 1;

        for (int i = 0; i <= n; i++) {
            stack.push((char) ('0' + counter++)); // Push the next number

            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
        }

}