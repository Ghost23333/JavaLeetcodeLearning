package Sliding_Window;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName offer59_1.java
 * @Description TODO
 * @createTime 2020年12月02日 15:43:00
 */
public class offer59_1 {
}


class Solution59_1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0)
            return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int index = 0;
        int []ans = new int[nums.length - k + 1];
        for(int i =0;i<k;i++){
            while(!deque.isEmpty()&&nums[i] > deque.peekLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }

        ans[index++] = deque.peekFirst();

        for(int i = k;i< nums.length;i++){
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.offerLast(nums[i]);
            ans[index++] = deque.peekFirst();
        }
        return ans;
    }
}