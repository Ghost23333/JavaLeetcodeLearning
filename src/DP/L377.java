package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L377.java
 * @Description TODO
 * @createTime 2022年10月30日 14:24:00
 */
public class L377 {
}
class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int []dp = new int[target + 1];
        dp[0] = 1;

        //这里要把背包容量放在外层循环,这样当背包容量固定时，元素可以任意选，满足题目要求
        for(int j = 0;j<=target;j++){
            for(int i = 0;i<nums.length;i++){
                if(j - nums[i] >=0 ){
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}