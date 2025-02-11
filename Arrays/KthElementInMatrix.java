import java.util.*;

public class KthElementInMatrix{
    /*
     * T.C:-O(M) i.e O(N*N)
     * S.C:-O(M) i.e O(N*N)
     */
    public static int KthSmallest(int[][]mat,int n,int k){
        int m=n*n;
        int[] arr= new int[m];
        int r=mat.length;
        int c=mat[0].length;
        int x=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[x]=mat[i][j];
                x++;
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }

}