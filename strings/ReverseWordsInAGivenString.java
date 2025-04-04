public class ReverseWordsInAGivenString {
    /*
     * Approach-1 (Using StringBuilder)
     * Time Complexity: O(N) where N is the length of the string.
     *  Space Complexity: O(N) for the StringBuilder.
     */
    public String reverseWords(String s){
        String [] arr=s.split(" +");
        StringBuilder sb=new StringBuilder();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    /*
     * Approach-2 (Using Two Pointer)
     * Time Complexity: O(N) where N is the length of the string.
     * Space Complexity: O(N) for the two pointers.
     */
    public String reverseWords_TwoPointerString(){
        public String reverseWords_TwoPointerString(String s) {
            // Trim leading and trailing spaces and reduce multiple spaces to single
            char[] chars = s.trim().toCharArray();
            int n = chars.length;
    
            // Reverse the entire string
            reverse(chars, 0, n - 1);
    
            // Reverse each word in the reversed string
            int start = 0;
            for (int end = 0; end < n; end++) {
                if (chars[end] == ' ') {
                    reverse(chars, start, end - 1);
                    start = end + 1;
                }
            }
            // Reverse the last word
            reverse(chars, start, n - 1);
    
            // Remove extra spaces between words
            return cleanSpaces(chars, n);
        
    }
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    // Helper method to clean up extra spaces
    private String cleanSpaces(char[] chars, int n) {
        int i = 0, j = 0;
        while (j < n) {
            // Skip spaces
            while (j < n && chars[j] == ' ') j++;
            // Copy non-space characters
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];
            // Add a single space if not at the end
            if (j < n) chars[i++] = ' ';
        }
        return new String(chars, 0, i).trim();
    }
}
