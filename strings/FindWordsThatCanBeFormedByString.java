//T.C : O(words.length())
//S.C : O(26)

class Solution {
    public int countCharacters(String[] words, String chars) {
        int [] charCnt= new int[26];
        for(char ch:chars.toCharArray()){
            charCnt[ch-'a']++;

        }
        int res=0;
        for(String word:words){
            int[] wordCount= new int[26];
            for (char ch : word.toCharArray()) {
                wordCount[ch - 'a']++;
            }
            boolean ok=true;
            for(int i=0;i<26;i++){
                if(wordCount[i]>charCnt[i]){
                    ok=false;
                    break;
                }
            }
            if(ok){
                res+=word.length();
            }
        }
        return res;
    }
}