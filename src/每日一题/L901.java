/*
package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;

*/
/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L901.java
 * @Description TODO
 * @createTime 2022年10月21日 12:53:00
 *//*

public class L901 {
}
class StockSpanner901 {
    private Deque<int[]> stack ;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int cnt = 1; //因为题目包含今天，所以初始化为1
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            cnt += stack.pop()[1];
        }
        stack.push(new int[] {price, cnt});
        return cnt;
    }
}
*/
