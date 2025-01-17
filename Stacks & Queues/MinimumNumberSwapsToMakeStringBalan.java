import java.util.Stack;

//Approach-1 (Using stack)
//T.C : O(n)
//S.C : O(n)


public class MinimumNumberSwapsToMakeStringBalan {
    /**
     * Calculates the minimum number of swaps required to make the input string of brackets balanced.
     *
     * @param s A string consisting of '[' and ']' characters representing the brackets sequence.
     * @return The minimum number of swaps needed to balance the brackets.
     */

     public int minSwaps(String s) {
        // Stack to track unmatched '[' brackets
        Stack<Character> st = new Stack<>();
        
        // Traverse through each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                // Push '[' onto the stack
                st.push(ch);
            } else if (!st.isEmpty()) {
                // If the stack is not empty and we encounter ']', it balances with a '['
                st.pop();
            }
        }

        // The size of the stack represents the number of unmatched '[' brackets.
        // The number of swaps needed to balance these unmatched brackets is (stack size + 1) / 2.
        return (st.size() + 1) / 2;
    }
}


//Approach-2 (without using stack)
//T.C : O(n)
//S.C : O(1)
class Solution {
    public int minSwaps(String s) {
        int size = 0;

        // Traverse through the string
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                size++; // Increment for every '['
            } else if (size != 0) {
                size--; // Decrement if there's a '[' to balance ']'
            }
        }

        // The number of swaps needed is (size + 1) / 2
        return (size + 1) / 2;
    }
}