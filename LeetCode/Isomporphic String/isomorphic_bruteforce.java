import java.util.Scanner;

public class isomorphic_bruteforce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        
        // Prompt user to enter strings
        System.out.print("Enter the first string: ");
        String s = scanner.nextLine();
        
        System.out.print("Enter the second string: ");
        String t = scanner.nextLine();
        
        // Test isIsomorphic method
        System.out.println("Isomorphic for " + s + " and " + t + ": " + solution.isIsomorphic(s, t));
        
        // Close scanner
        scanner.close();
    }
}

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Base case: for different length of two strings...
        if(s.length() != t.length())
            return false;
        // Create two maps for s & t strings...
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        // Traverse all elements through the loop...
        for(int idx = 0; idx < s.length(); idx++){
            // Compare the maps, if not equal, return false...
            if(map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;
            // Insert each character if string s and t into separate map...
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;
        }
        return true;    // Otherwise return true...
    }
}
