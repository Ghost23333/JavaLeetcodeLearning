package heap;

import java.util.PriorityQueue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L703.java
 * @Description TODO
 * @createTime 2020年10月30日 14:25:00
 */
public class L703 {
    public static void main(String[] args) {
        int arr[] = {4,5,8,2};
        KthLargest k = new KthLargest(3,arr);
        k.add(3);
    }
}
class KthLargest {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int kth;
    private int[]temp;
    public KthLargest(int k, int[] nums) {
        kth = k;
        for(int i =0;i< nums.length;i++){
            queue.offer(nums[i]);
        }
        temp = new int[k];

    }

    public int add(int val) {
        int ans;
        queue.offer(val);
        for(int i =0;i< kth-1 ;i++)
            temp[i] =  queue.poll();
        ans = queue.poll();
        for(int i =0;i< kth - 1 ;i++)
            queue.offer(temp[i]);
        return ans;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */