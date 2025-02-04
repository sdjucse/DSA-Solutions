
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<Integer> list;
        int i, j, id;
        
        // Sorting diagonals starting from each row (first column)
        for (int k = 0; k < m; k++) {
            i = k;
            j = 0;
            list = new ArrayList<>();
            
            // Store the diagonal elements in a list
            while (i < m && j < n) {
                list.add(mat[i][j]);
                i++;
                j++;
            }
            
            // Sort the diagonal elements
            Collections.sort(list);
            
            // Place the sorted elements back in the matrix
            i = k;
            j = 0;
            id = 0;
            while (i < m && j < n) {
                mat[i][j] = list.get(id++);
                i++;
                j++;
            }
        }
        
        // Sorting diagonals starting from each column (first row)
        for (int k = 0; k < n; k++) {
            i = 0;
            j = k;
            list = new ArrayList<>();
            
            // Store the diagonal elements in a list
            while (i < m && j < n) {
                list.add(mat[i][j]);
                i++;
                j++;
            }
            
            // Sort the diagonal elements
            Collections.sort(list);
            
            // Place the sorted elements back in the matrix
            i = 0;
            j = k;
            id = 0;
            while (i < m && j < n) {
                mat[i][j] = list.get(id++);
                i++;
                j++;
            }
        }
        
        return mat;
    }
}
