package 每日一题;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L322.java
 * @Description TODO
 * @createTime 2022年11月03日 17:37:00
 */
public class L322 {
    public static void main(String[] args) {
        new  Solution322().coinChange(new int[]{1,2,5},11);
    }
}
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for(int i = coin;i <= amount;i++){
                if(dp[i - coin] != amount + 1){
                    dp[i] = Math.min(dp[i],dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}