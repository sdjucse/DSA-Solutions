package Arrays;

public class SetMatrixZeroes {
    /*
     *  * Approach-1 (Brute Force)
     *  * T.C : O((N*M)*(N + M)) + O(N*M) where n is the number of elements in the matrix.
     * S.C : O(1) for the matrix.*/
    static void markRow(int[][]matrix,int row,int col,int i){
        for(int j=0;i<row;i++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-1;
            }
        }
    }
    static void markCol(int[][]matrix,int row,int col,int j){
        for(int i=0;i<col;i++){
            if(matrix[i][j]!=0){
                matrix[i][j]=-1;
            }
        }
    }
    static void setZeroes(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==0){
                    markRow(matrix,row,col,i);
                    markCol(matrix,row,col,j);
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=0;
                }
            }
        }
}
    /*
     * T.C:  O(2*(N*M))
     * S.C: O(1) for the matrix.
     */
    static int[][] zeroMatrix(int[][] matrix, int n, int m) {
        int col0 = 1;

        // Step 1: Use first row and first column as markers
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // Mark row
                    matrix[0][j] = 0; // Mark column
                }
            }
        }

        // Step 2: Use the marks to set elements to 0
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 3: Set first row to 0 if needed
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 4: Set first column to 0 if needed
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }
}
