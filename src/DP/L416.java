package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L416.java
 * @Description TODO
 * @createTime 2022年10月20日 16:44:00
 */
public class L416 {
}
class Solution416 {
    public boolean canPartition(int[] nums) {
        int bagWeight= 0;
        for (int num : nums) {
            bagWeight += num;
        }
        if(bagWeight % 2 == 1)  //如果元素和为奇数，则肯定不能被平分
            return false;
        bagWeight /= 2;      //背包容量
        //这里物品的weight 和 value相等
        int []dp =new int[bagWeight + 1];
        for(int i = 0;i<nums.length;i++){
            for(int j = bagWeight;j>= nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j - nums[i]] + nums[i]);
            }
        }
        if(dp[bagWeight] == bagWeight)
            return true;
        return false;
    }
}