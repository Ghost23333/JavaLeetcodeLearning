package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L518.java
 * @Description TODO
 * @createTime 2022年10月30日 12:00:00
 */
public class L518 {
    public static void main(String[] args) {
        new Solution518().change(5,new int[]{1,2,5} );
    }
}

class Solution518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];//dp[i]代表背包容量为i时有多少种解法
        dp[0] = 1;//初始化，因为dp[0]代表金额为0时，唯一解法就是不放硬币
        for (int i = 0; i < coins.length; i++) {
            //这里从前往后找，就能使物品能够重复使用
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}