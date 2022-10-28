package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L494.java
 * @Description TODO
 * @createTime 2022年10月24日 14:50:00
 */
public class L494 {
}
class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }//求和
        int bagWeight = sum - target;
        if(bagWeight < 0 || bagWeight % 2 == 1){ //如果为零或者为奇数则代表没有解
            return 0;
        }
        bagWeight /= 2;  //bagWeight为背包容量
        int []dp = new int[bagWeight + 1]; //dp[i]为装满容量为i的物品有多少种装法
        dp[0] = 1;
        for(int i = 0;i< nums.length;i++){
            for(int j = bagWeight;j>= nums[i];j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagWeight];
    }
}
