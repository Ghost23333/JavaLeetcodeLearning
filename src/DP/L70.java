package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L70.java
 * @Description TODO
 * @createTime 2022年10月08日 10:21:00
 */
public class L70 {
}
class Solution {
    public int climbStairs(int n) {
        if(n <= 3)
            return n;
        int a = 2;
        int b = 3;
        int c;
        for(int i= 3;i<n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}