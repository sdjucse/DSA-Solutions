import java.util.Stack;

class Solution {
    /**
     * This method evaluates a mathematical expression given as a string. The expression
     * may contain digits, '+', '-', '(', and ')' characters. It calculates the result 
     * of the expression, respecting the order of operations (parentheses and signs).
     *
     * @param s The mathematical expression as a string.
     * @return The evaluated result of the expression as an integer.
     */
    public int calculate(String s) {
        int number = 0;         // Holds the current number being processed
        int res = 0;            // Holds the intermediate result
        Stack<Integer> st = new Stack<>(); // Stack to manage parentheses and signs
        int sign = 1;           // Keeps track of the current sign (+1 for positive, -1 for negative)

        // Loop through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // If the character is a digit, update the current number
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                // If the character is '+', add the current number (with its sign) to the result
                res += sign * number;
                number = 0;  // Reset the number
                sign = 1;    // Update the sign for the next number
            } else if (c == '-') {
                // If the character is '-', add the current number (with its sign) to the result
                res += sign * number;
                number = 0;  // Reset the number
                sign = -1;   // Update the sign for the next number
            } else if (c == '(') {
                // If the character is '(', push the current result and sign onto the stack
                // and reset them for the expression inside the parentheses
                st.push(res);  // Save the current result
                st.push(sign); // Save the current sign
                number = 0;    // Reset the number
                res = 0;       // Reset the result
                sign = 1;      // Reset the sign
            } else if (c == ')') {
                // If the character is ')', complete the calculation for the expression inside the parentheses
                res += sign * number;  // Add the last number inside the parentheses
                number = 0;            // Reset the number
                res *= st.pop();       // Multiply by the sign before the parentheses
                res += st.pop();       // Add the result before the parentheses
            }
        }

        // Add any remaining number to the result (for cases where the expression ends with a number)
        res += (sign * number);

        return res; // Return the final result
    }
}
/*Explanation of the Code:
Initialization:

number stores the current number being processed.
res accumulates the result as the expression is evaluated.
st (stack) is used to handle nested parentheses and maintain context.
sign keeps track of whether the current number is positive (+1) or negative (-1).
Processing the Input String:

Traverse each character of the string s:
Digits (0-9): Update number by shifting digits (e.g., 12 becomes 1 * 10 + 2).
Operators (+ and -):
Add the current number (multiplied by its sign) to res.
Reset number and update sign based on the operator.
Opening Parenthesis (():
Push the current res and sign onto the stack to save the context.
Reset res, number, and sign to evaluate the subexpression inside the parentheses.
Closing Parenthesis ()):
Add the last number to res.
Multiply res by the sign popped from the stack (before the parentheses).
Add the res popped from the stack (result before the parentheses).
Final Addition:

Add any remaining number (multiplied by its sign) to res.
Example Execution:
Input: "1 + (2 - (3 + 4))"
Traverse "1" → res = 1.
Encounter "+" → Prepare for next number.
Encounter "(" → Push res = 1 and sign = +1 onto the stack; reset res.
Traverse "2" → res = 2.
Encounter "-" → Prepare for next number with sign = -1.
Encounter "(" → Push res = 2 and sign = -1 onto the stack; reset res.
Traverse "3" → res = 3.
Encounter "+" → Prepare for next number.
Traverse "4" → res = 7 (inside second parentheses).
Encounter ")" → Multiply by sign = -1 and add res = 2 (from stack).
Encounter ")" → Multiply by sign = +1 and add res = 1 (from stack).
Output: -4.
Key Points:
Stack Usage: Handles nested parentheses efficiently.
Sign Management: Keeps track of whether numbers are added or subtracted.
Edge Cases: The code correctly handles edge cases such as leading/trailing spaces or complex nesting.*/

