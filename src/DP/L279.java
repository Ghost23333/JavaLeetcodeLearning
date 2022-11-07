package DP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L279.java
 * @Description TODO
 * @createTime 2022年11月07日 17:36:00
 */
public class L279 {
    public static void main(String[] args) {
        new Solution279().numSquares(12);
    }
}

class Solution279 {
    public int numSquares(int n) {
        //首先找到小于n的完全平方数都有哪些
        ArrayList<Integer> perfectSquareArr = new ArrayList<>();
        for (int i = 1,num = 1; i <= n; ) {
            perfectSquareArr.add(i);
            num++;
            i = num * num;
        }
        int []dp = new int[n + 1];//背包容量为 n,dp[i]代表背包容量为i时完全平方数的最小数量
        Arrays.fill(dp,n + 1);
        dp[0] = 1;
        for (Integer goods : perfectSquareArr) {
            for(int j = 0;j <= n ;j++){
                if(j - goods >= 0){
                    dp[j] = Math.min(dp[j],dp[j - goods] + 1);
                }
            }
        }
        return dp[n];
    }
}