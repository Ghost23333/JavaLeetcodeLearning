package 每日一题;

import javax.management.DescriptorAccess;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L862.java
 * @Description TODO
 * @createTime 2022年10月26日 09:51:00
 */
public class L862 {
    public static void main(String[] args) {
        new Solution862().shortestSubarray(new int[]{1},1);
    }
}

class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] preSumArr = new long[n + 1];
        for (int i = 0; i < nums.length; i++) {
            preSumArr[i + 1] += preSumArr[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = n + 1;
        for (int i = 0; i <= nums.length; i++) {
            long curSum = preSumArr[i];
            while (!deque.isEmpty() && curSum - preSumArr[deque.peek()] >= k) {
                ans = Math.min(ans, i - deque.poll());
            }

            while (!deque.isEmpty() && preSumArr[deque.peekLast()] >= curSum){
                deque.pollLast();
            }
            deque.offer(i);
        }
        return ans > n ? -1 : ans;

    }
}