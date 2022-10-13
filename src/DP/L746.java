package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L746.java
 * @Description TODO
 * @createTime 2022年10月08日 11:04:00
 */
public class L746 {

}
class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2)
            return  Math.min(cost[0],cost[1]);
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[cost.length - 1],cost[cost.length - 2]);
    }
}