package 每日一题;


import java.awt.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.prefs.PreferencesFactory;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1235.java
 * @Description TODO
 * @createTime 2022年10月22日 10:32:00
 */
public class L1235 {
    public static void main(String[] args) {
        new Solution1235().jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6  },
                new int[]{50,10,40,70});
    }
}

class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = endTime.length;
        Integer[] index = new Integer[n]; //用来存储endTime的索引
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (i, j) -> {
            return endTime[i] - endTime[j];
        });
        int[] dp = new int[n + 1]; //创建dp数组，dp[i]代表前i份兼职能获取的最大报酬
        for (int i = 1; i <= index.length; i++) {
            //这里 i - 1才是第i份兼职，因为startTime endTime profit数组是从0开始编号
            //startTime[i - 1]代表第 i份兼职开始的时间
            //向前找到最近的结束时间小于等于当前兼职的起始时间的兼职
            int pre = 0;
            for (int j = i - 1; j >= 1; j--) {
                if(endTime[index[j - 1]] <= startTime[index[i - 1]]){
                    pre = j;
                    break;
                }
            }
            dp[i] = Math.max(dp[i - 1],dp[pre] + profit[index[i - 1]]);
        }
        return dp[n];
    }
}
