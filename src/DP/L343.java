package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L343.java
 * @Description TODO
 * @createTime 2022年10月09日 16:48:00
 */
public class L343 {
    public static void main(String[] args) {
        new Solution343().integerBreak(2);
    }
}

class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}