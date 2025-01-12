import java.util.Stack;

class Solution {
    /**
     * This method removes all adjacent duplicate characters from the input string `s`.
     * It uses a stack to process characters and ensures that duplicate characters are
     * removed efficiently.
     *
     * @param s The input string from which duplicates need to be removed.
     * @return A new string with all adjacent duplicates removed.
     */
    public String removeDuplicates(String s) {
        // Initialize a stack to keep track of characters
        Stack<Character> st = new Stack<>();

        // Traverse each character of the input string
        for (int i = 0; i < s.length(); i++) {
            // If the stack is not empty and the top of the stack matches the current character,
            // it means we found a duplicate, so pop the stack
            if (!st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else {
                // Otherwise, push the current character onto the stack
                st.push(s.charAt(i));
            }
        }

        // Use a StringBuilder to construct the result string from the stack
        StringBuilder result = new StringBuilder();

        // Pop all elements from the stack and append them to the result
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        // Since the stack stores characters in reverse order, reverse the result before returning
        return result.reverse().toString();
    }
}
/*Explanation of the Code:
Initialization:

A Stack<Character> is initialized to keep track of characters as we process the string.
Processing the Input String:

Iterate through each character in the string.
If the stack is not empty and the top character of the stack matches the current character, it indicates a duplicate, so the character at the top of the stack is removed using st.pop().
Otherwise, the current character is added to the stack using st.push().
Building the Result:

A StringBuilder is used to build the final result string from the stack contents.
Characters are popped from the stack and appended to the StringBuilder. Since the stack operates in LIFO (Last In, First Out) order, the characters are added in reverse.
Reversing the Result:

The StringBuilder is reversed to get the correct order of characters and converted to a String using .toString().
Return the Result:

The resulting string is returned, with all adjacent duplicates removed.
Example Execution:
Input: "abbaca"
Step-by-Step Process:
Stack after each iteration:

Push a: [a]
Push b: [a, b]
Pop b: [a]
Push c: [a, c]
Push a: [a, c, a]
Convert stack to result string: result = "aca" (reverse of the stack order).

Output: "ca"
This documentation provides clarity on the logic and functionality of the code, making it easy to understand.
*/





