package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L474.java
 * @Description TODO
 * @createTime 2022年10月26日 17:30:00
 */
public class L474 {
}

class Solution474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] nums = new int[strs.length][2];
        //将字符串中的0 和 1计算出来，并存入数组nums
        for (int i = 0; i < strs.length; i++) {
            nums[i] = fun(strs[i]);
        }
        //这里是相当于有两个背包，背包容量为m和n,dp数组的含义是 dp[i][j]的意思是容量为i 和 j时能装入的str的数量
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < nums.length; i++) {
            //下面两个for循环的顺序可以交换
            for(int j = m; j >=nums[i][0];j--){
                for(int k = n;k>= nums[i][1];k--){
                    dp[j][k] = Math.max(dp[j][k],dp[j - nums[i][0]][k - nums[i][1]] + 1);
                }
            }
        }
        return dp[m][n];
    }
    //这个函数目的是将字符串str中的0和1的个数算出来并返回
    int[] fun(String str) {
        int[] ans = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                ans[0]++;
            else
                ans[1]++;
        }
        return ans;
    }
}