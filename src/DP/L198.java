package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L198.java
 * @Description TODO
 * @createTime 2022年11月26日 19:31:00
 */
public class L198 {
}
class Solution198 {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0],nums[1]);
        int []dp = new int[nums.length];//dp[i]代表i号房屋及之前能偷窃到的最高金额
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}