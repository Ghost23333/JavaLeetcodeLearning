package 贪心;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L54.java
 * @Description TODO
 * @createTime 2022年10月06日 10:32:00
 */
public class L56 {
}
class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        ArrayList<int []> ans = new ArrayList<>();
        int interval[] = new int[2];
        interval[0] = intervals[0][0];
        interval[1] = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] <= interval[1]){
                if(intervals[i][1] > interval[1])
                    interval[1] = intervals[i][1];
            }else {
                ans.add(interval);
                interval = new int[2];
                interval[0] = intervals[i][0];
                interval[1] = intervals[i][1];
            }
        }
        if(!ans.contains(interval)){
            ans.add(interval);
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}