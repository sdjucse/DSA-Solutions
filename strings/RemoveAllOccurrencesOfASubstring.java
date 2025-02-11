import java.util.*;

public class RemoveAllOccurrencesOfASubstring{
    /*
     * Approach-1(Using Stack)
     * T.C:-O(m*n)
     * S.C:-O(m)
     */
    public boolean check(Stack<Character>st,String part,int n){
        Stack<Character>tempst=new Stack<>();
        tempst.addAll(st);
        for(int i=n-1;i>=0;i--){
            if(tempst.peek()!=part.charAt(i)){
                return false;
            }
            tempst.pop();
        }
        return true;
    }
     public String removeOccurrences(String s, String part) {
        int m=s.length();
        int n=part.length();
        Stack<Character>st=new Stack<>();
        for(int i=0;i<m;i++){
            st.push(s.charAt(i));
        if(st.size()>=n && check(st,part,n)){
            for(int j=0;j<n;j++){
                st.pop();
            }
        }
    }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();


     }
     /*
     * Approach-1(Using Stack)
     * T.C:-O(m*n)
     * S.C:-O(1)
     */ 
}