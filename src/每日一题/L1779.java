package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1779.java
 * @Description TODO
 * @createTime 2022年12月01日 17:32:00
 */
public class L1779 {
}
class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = 10001;
        int resIndex = -1;
        for (int i = 0; i < points.length; i++) {
            if(points[i][0] == x || points[i][1] == y){
                if(Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y) < minDistance){
                    minDistance = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                    resIndex = i;
                }
            }
        }
        return resIndex;
    }
}