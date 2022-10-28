package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1049.java
 * @Description TODO
 * @createTime 2022年10月21日 13:50:00
 */
public class L1049 {
}
class Solution1049 {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum+=stone;
        }
        int bagWeight = sum / 2;
        int []dp = new int[bagWeight + 1];
        for (int i = 0; i < stones.length; i++){
            for (int j = bagWeight; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        /*
            预期除去背包中剩下的石头   sum - bagWeight
            实际除去背包中剩下的石头   sum - bagWeight + bagWeight - dp[bagWeight]
            碰撞后剩下的石头         sum - bagWeight + bagWeight - dp[bagWeight] - dp[bagWeight]
            简化后为   sum  - 2 * dp[bagWeight]
         */
        return sum  - 2 * dp[bagWeight];
    }
}