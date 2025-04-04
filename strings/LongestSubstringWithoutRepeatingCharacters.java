
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
     * * Approach-1: Using HashSet (Sliding Window) [O(N)]
     * * Time Complexity: O(N^2) where N is the length of the string.
     * * Space Complexity: O(n) where M is the size of the character set.
     */
    public int lengthOfLongestSubstring_HashSet(String str) {
        if(str.length()==0)
        return 0;
   int maxans = Integer.MIN_VALUE;
   for (int i = 0; i < str.length(); i++) // outer loop for traversing the string
   {
       Set < Character > se = new HashSet < > ();
       for (int j = i; j < str.length(); j++) // nested loop for getting different string starting with str[i]
       {
           if (se.contains(str.charAt(j))) // if element if found so mark it as ans and break from the loop
           {
               maxans = Math.max(maxans, j - i);
               break;
           }
           se.add(str.charAt(j));
       }
   }
   return maxans;
}
/*
 * * Approach-2: Using HashMap (Sliding Window) [O(N)]
 * * Time Complexity: O(N) where N is the length of the string.    
 * * * Space Complexity: O(n) where M is the size of the character set.
 */
public int lengthOfLongestSubstring(String s) {
    HashMap<Character, Integer> mpp = new HashMap<>();

    int left = 0, right = 0;
    int n = s.length();
    int len = 0;

    while (right < n) {
        if (mpp.containsKey(s.charAt(right))) {
            left = Math.max(mpp.get(s.charAt(right)) + 1, left);
        }

        mpp.put(s.charAt(right), right);
        len = Math.max(len, right - left + 1);
        right++;
    }
    
    return len;
}
}
