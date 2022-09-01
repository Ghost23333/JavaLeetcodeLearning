package heap;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L347.java
 * @Description TODO
 * @createTime 2020年11月03日 09:49:00
 */
public class L347 {
    public static void main(String[] args) {
        int []nums = {4,1,-1,2,-1,2,3};
        Solution347 s = new Solution347();
        s.topKFrequent(nums,2);
    }
}
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        if (k == 0)
            return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();

            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});

                }
            } else
                queue.offer(new int[]{num, count});
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}