import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubString {
    /*
     * Brute Force Approach Generate all substrings and check if they are nice.
     * T.C : O(n^2) S.C : O(n)
     */
    private boolean isNice(String str) {
        for (char c : str.toCharArray()) {
            if (!(str.contains(Character.toString(Character.toLowerCase(c))) &&
                  str.contains(Character.toString(Character.toUpperCase(c))))) {
                return false;
            }
        }
        return true;
    }
    public String LongestNiceString(String s){
        int maxLen=0;
        String res="";
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                String substr=s.substring(i,j); 
                if(isNice(substr)&& substr.length()>maxLen){
                    maxLen=substr.length();
                    res=substr;
                }
            }
        }
        return res;
    }
    /*
     * Optimized Approach Using HashSet to check if a character and its opposite case exist.
     * T.C : O(n^2) S.C : O(n)
     */
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: arr) set.add(c);
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i+1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s; 
    }
}
