import java.util.*;
public class ClearDigits{
    /*
     * Brute Force
     * T.C:-O(N^2)
     * S.C:-O(1)
     */
    public String ClearDigits_BruteForce(String s){
        StringBuilder sb= new StringBuilder();
        int i=0;
        while(i<sb.length()){
            if(Character.isDigit(sb.charAt(i))){
                sb.deleteCharAt(i);
                if(i>0){
                    sb.deleteCharAt(i-1);
                    i--;
                }
            }
            else{
                i++;
            }
            
        }
        return sb.toString();
    }
    /*Approach-2
     * Using Stack
     * T.C:-O(N)
     * S.C:-O(N)
     */
    public String ClearDigits_UsingStack(String s){
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch>='a'&& ch<='z'){
                st.push(ch);
            }
            else if(!st.isEmpty()){
                st.pop();
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    /*Approach-3
     * Without using Extra Space and time
     * T.C:-O(N)
     * S.C:-O(1)
     */
    public String ClearDigits_NotUsingStack(String s){
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch>='a'&&ch<='z'){
                sb.append(ch);
            }
            else if(sb.length()>0){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }   
}