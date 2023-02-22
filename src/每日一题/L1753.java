package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1753.java
 * @Description TODO
 * @createTime 2022年12月22日 19:55:00
 */
public class L1753 {
}
class Solution1753 {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int maxVal = Math.max(Math.max(a, b), c);
        return Math.min(sum - maxVal, sum / 2);
    }
}