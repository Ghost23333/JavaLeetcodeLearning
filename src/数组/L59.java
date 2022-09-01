package 数组;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L59.java
 * @Description TODO
 * @createTime 2022年03月02日 22:28:00
 */
public class L59 {
    public static void main(String[] args) {
        Solution59 s = new Solution59();
        s.generateMatrix(4);
    }
}
class Solution59 {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++)
                mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++)
                mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}