package leetcodepotd;

import java.util.*;

public class valid_parenthesis_String_greedy{
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the string:");
    String s= sc.nextLine();
    Solution sol= new Solution();
    boolean b= sol.checkValidString(s);
    System.out.println("Is the string valid: " + b);
    sc.close();
}






public class Solution {
    public boolean checkValidString(String s) {
        int leftMin=0,leftMax=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                leftMin++;
                leftMax++;
            }
            else if(c==')'){
                leftMin--;
                leftMax--;
            }
            else{
                leftMin--;
                leftMax++;
            }
            if(leftMax<0){
                return false;
            }
            if(leftMin<0){
                leftMin=0;
            }
        }
        return leftMin==0;
    }
}