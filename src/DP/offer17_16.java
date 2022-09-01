package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName offer17_16.java
 * @Description TODO
 * @createTime 2020年11月16日 10:27:00
 */
public class offer17_16 {
}
class Solution17_16 {
    public int massage(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int []f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length;i++){
            f[i] =  Math.max(f[i-2]+nums[i],f[i-1]);
        }
        return f[nums.length - 1];

    }
}

class Solution17_16_2{
    public int massage(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        if(len == 1)
            return nums[0];
        int [][]dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i =1;i<len;i++){
            dp[i][0] = Math.max(dp[i - 1][0],dp[i-1][1]);
            dp[i][1] = nums[i] + dp[i-1][0];
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

}