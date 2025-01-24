class Solution {

    // Helper function to check if a character is a vowel
    boolean isVowel(char s) {
        // Check if the character is a vowel (both uppercase and lowercase)
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' || 
            s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U') {
            return true;
        }
        return false;
    }

    // Function to reverse only the vowels in a string
    public String reverseVowels(String s) {
        // Convert the string to a character array for easy modification
        char[] ch = s.toCharArray();
        int i = 0; // Pointer to the start of the array
        int j = s.length() - 1; // Pointer to the end of the array

        // Use two pointers to find and swap vowels
        while (i < j) {
            // Move the left pointer forward if the character is not a vowel
            if (!isVowel(ch[i])) {
                i++;
            }
            // Move the right pointer backward if the character is not a vowel
            else if (!isVowel(ch[j])) {
                j--;
            }
            // If both pointers point to vowels, swap them
            else {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;

                // Move both pointers inward
                i++;
                j--;
            }
        }

        // Convert the modified character array back to a string and return
        return new String(ch);
    }
}
