package DP;

import java.text.DecimalFormat;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L63.java
 * @Description TODO
 * @createTime 2022年10月09日 11:20:00
 */
public class L63 {
    long a[] = new long[10];
    public static void main(String[] args) {
        //new Solutio63().uniquePathsWithObstacles(new int[][]{{1,0}});
    }
}
class Solutio63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = 1;
            else {
              break;
            }
        }
        for (int i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 0)
                dp[0][i] = 1;
            else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = 0;
            }
        }
        return dp[m-1][n-1];
    }
}