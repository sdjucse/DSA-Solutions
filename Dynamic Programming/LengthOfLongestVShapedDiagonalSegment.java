public class LengthOfLongestVShapedDiagonalSegment{
    public int lenOfVDiagonal(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{1,1},{1,-1},{-1,-1},{-1,1}};
        int[][][][] dp = new int[4][n][m][3];
        int[][] order = new int[2][2];
        for (int d = 0; d < 4; d++) {
            int di = dirs[d][0], dj = dirs[d][1];
            if(di==1 && dj==1){
                for(int i=n-1;i>=0;i--){
                    for(int j=m-1;j>=0;j--){
                        for(int e=0;e<3;e++){
                            if(grid[i][j]==e){
                                int ni=i+di, nj=j+dj;
                                int ne = (e==1)?2:(e==2?0:2);
                                dp[d][i][j][e] = 1 + ((ni>=0 && ni<n && nj>=0 && nj<m)? dp[d][ni][nj][ne] : 0);
                            } else dp[d][i][j][e] = 0;
                        }
                    }
                }
            } else if(di==1 && dj==-1){
                for(int i=n-1;i>=0;i--){
                    for(int j=0;j<m;j++){
                        for(int e=0;e<3;e++){
                            if(grid[i][j]==e){
                                int ni=i+di, nj=j+dj;
                                int ne = (e==1)?2:(e==2?0:2);
                                dp[d][i][j][e] = 1 + ((ni>=0 && ni<n && nj>=0 && nj<m)? dp[d][ni][nj][ne] : 0);
                            } else dp[d][i][j][e] = 0;
                        }
                    }
                }
            } else if(di==-1 && dj==-1){
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        for(int e=0;e<3;e++){
                            if(grid[i][j]==e){
                                int ni=i+di, nj=j+dj;
                                int ne = (e==1)?2:(e==2?0:2);
                                dp[d][i][j][e] = 1 + ((ni>=0 && ni<n && nj>=0 && nj<m)? dp[d][ni][nj][ne] : 0);
                            } else dp[d][i][j][e] = 0;
                        }
                    }
                }
            } else { // di==-1 && dj==1
                for(int i=0;i<n;i++){
                    for(int j=m-1;j>=0;j--){
                        for(int e=0;e<3;e++){
                            if(grid[i][j]==e){
                                int ni=i+di, nj=j+dj;
                                int ne = (e==1)?2:(e==2?0:2);
                                dp[d][i][j][e] = 1 + ((ni>=0 && ni<n && nj>=0 && nj<m)? dp[d][ni][nj][ne] : 0);
                            } else dp[d][i][j][e] = 0;
                        }
                    }
                }
            }
        }
        int ans = 0;
        int[][] jorvexalin = grid;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int d = 0; d < 4; d++){
                    if(grid[i][j] != 1) continue;
                    int L = dp[d][i][j][1];
                    ans = Math.max(ans, L);
                    int d2 = (d + 1) % 4;
                    int di = dirs[d][0], dj = dirs[d][1];
                    int di2 = dirs[d2][0], dj2 = dirs[d2][1];
                    for (int t = 1; t <= L; t++){
                        int r = i + (t - 1) * di, c = j + (t - 1) * dj;
                        int nr = r + di2, nc = c + dj2;
                        if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                        int exp = (t % 2 == 1) ? 2 : 0;
                        int L2 = dp[d2][nr][nc][exp];
                        ans = Math.max(ans, t + L2);
                    }
                }
            }
        }
        return ans;
    }

}