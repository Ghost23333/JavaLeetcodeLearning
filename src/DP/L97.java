package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L97.java
 * @Description TODO
 * @createTime 2022年10月15日 15:23:00
 */
public class L97 {
    public static void main(String[] args) {
        new Solution97().isInterleave("aabcc"
                ,"dbbca"
                ,"aadbbcbcac");
    }
}

//回溯又超时了捏
class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        return backtracking(s1,s2,s3,0,0,0);
    }
    public boolean backtracking(String s1, String s2, String s3,int i,int j,int k){
        if(k == s3.length()){
            return true;
        }
        if(i<s1.length() && s3.charAt(k) == s1.charAt(i)){
            if(backtracking(s1,s2,s3,i+1,j,k+1)){
                return true;
            }
        }
        if(j<s2.length() && s3.charAt(k) == s2.charAt(j)){
            if(backtracking(s1,s2,s3,i,j + 1,k+1)){
                return true;
            }
        }
        return false;
    }


}


class Solution97_dp {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }
}