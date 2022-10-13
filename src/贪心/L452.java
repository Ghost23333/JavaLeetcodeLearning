package 贪心;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L452.java
 * @Description TODO
 * @createTime 2022年10月04日 13:12:00
 */
public class L452 {
    public static void main(String[] args) {

        new Solution452().findMinArrowShots(new int[][]
                {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}});
    }

}
class Solution452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int ans = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > pre){
                pre = points[i][1];
                ans++;
            }
            if(points[i][1] < pre){
                pre = points[i][1];
            }
        }
        return ans;
    }
}