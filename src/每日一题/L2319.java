package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L2319.java
 * @Description TODO
 * @createTime 2023年01月31日 11:08:00
 */
public class L2319 {
}

class Solution2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    if (grid[i][j] == 0)
                        return false;
                } else {
                    if (grid[i][j] != 0)
                        return false;
                }
            }
        }
        return true;
    }
}