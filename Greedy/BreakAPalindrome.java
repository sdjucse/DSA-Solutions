package Greedy;

public class BreakAPalindrome {
    
}/**
 * This class provides a solution to break a given palindrome string by making the smallest lexicographical change.
 */
class Solution {

    /**
     * Modifies a palindrome string to make it non-palindromic by replacing a single character.
     * 
     * @param palindrome A string that is guaranteed to be a palindrome.
     * @return The lexicographically smallest string that is not a palindrome. If the input string
     *         has a length of 1, returns an empty string as it's impossible to break the palindrome.
     */
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length(); // Get the length of the input string.
        
        // If the string has only one character, it cannot be made non-palindromic.
        if (n == 1) {
            return "";
        }
        
        // Convert the string into a character array for easier modification.
        char[] pal = palindrome.toCharArray();
        
        // Iterate through the first half of the palindrome.
        for (int i = 0; i < n / 2; i++) {
            // Find the first character that is not 'a' and replace it with 'a'.
            if (pal[i] != 'a') {
                pal[i] = 'a'; // Make the smallest lexicographical change.
                return new String(pal); // Return the modified string.
            }
        }
        
        // If all characters in the first half are 'a', replace the last character with 'b'.
        pal[n - 1] = 'b';
        return new String(pal); // Return the modified string.
    }
}

/*
 * Time     Complexity:O(n)
 * Space Complexit: 0(1)
 */
