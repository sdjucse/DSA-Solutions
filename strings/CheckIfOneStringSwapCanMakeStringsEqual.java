

 public class CheckIfOneStringSwapCanMakeStringsEqual{
    /*
    * Approach-1
    * T.C:-O(N)
    * S.C:-O(26)
    */
    public boolean areAlmostEqual(String s1, String s2) {
        int n=s1.length();
        if(s1.equals(s2)){
            return true;
        }    
        int [] freq1= new int[26];
        int [] freq2= new int[26];
        int diff=0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
            }
        if(diff>2){
            return false;
        }
        freq1[s1.charAt(i)-'a']++;
        freq2[s2.charAt(i)-'a']++;
    }
    for(int i=0;i<26;i++){
        if(freq1[i]!=freq2[i]){
            return false;
        }
    }
        return true;
    }
    //Approach-2 (using counting only. No map required)
    //T.C : O(n)
    //S.C : O(1)
    public boolean areAlmostEqual2(String s1, String s2) {
        int n=s1.length();
        if(s1.equals(s2)){
            return true;
        }  
        int diff=0;
        int firstindex=0;
        int secondindex=0;
        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                diff++;
                if(diff>2){
                    return false;
                }
                else if (diff==1) {
                    firstindex=i;
                }
                else{
                    secondindex=i;
                }
            }
        }
        return s1.charAt(firstindex)==s2.charAt(secondindex)&& s1.charAt(secondindex)==s2.charAt(firstindex);
    }
 }