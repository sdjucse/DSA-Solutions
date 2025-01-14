package leetcodepotd;


/*Approach 1 BruteForce (O(N^3)) */
public class Solution {
    public int[] findThePrefixCommonArray(int[] A,int[] B){
        int n=A.length;
        int[] C= new int[n];
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<=i;j++){
                for(int k=0;k<=i;k++){
                    if(B[k]==A[j]){
                        cnt++;
                        break;
                    }
                }
            }
            C[i]=cnt;
        }
        return C;
    }
}
/*
 Time Complexity: O(n^3)
 Space Complexity: O(1)
 */

//Approach-2 (Better Approach)
//T.C : O(n^2)
//S.C : O(n)
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] result = new int[n];

        boolean[] isPresentA = new boolean[n+1];
        boolean[] isPresentB = new boolean[n+1];

        for(int i = 0; i < n; i++) {
            isPresentA[A[i]] = true;
            isPresentB[B[i]] = true;

            int count = 0;
            for(int num = 1; num <= n; num++) {
                if(isPresentA[num] == true && isPresentB[num] == true) {
                    count++;
                }
            }

            result[i] = count;
        }

        return result;
    }
}
/*
 * Approach-3 Best Approach
 * 
 */



 class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int[] result = new int[n];

        HashMap<Integer, Integer> mp = new HashMap();

        int count = 0;

        for(int i = 0; i < n; i++) {
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1); //mp[A[i]]++ ;
            if(mp.get(A[i]) == 2) {
                count++;
            }
            
            mp.put(B[i], mp.getOrDefault(B[i], 0) + 1); //mp[B[i]]++ ;
            if(mp.get(B[i]) == 2) {
                count++;
            }

            result[i] = count;

        }

        return result;
    }
}