package 贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L435.java
 * @Description TODO
 * @createTime 2022年10月05日 10:16:00
 */
public class L435 {
}

class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            return a[1] - b[1];
        });

        int preEnd = intervals[0][1];
        int ans = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < preEnd ){
                ans++;
            }else {
                preEnd = intervals[i][1];
            }
        }
        return ans;
    }
}