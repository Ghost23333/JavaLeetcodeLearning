package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1046.java
 * @Description TODO
 * @createTime 2020年10月30日 14:08:00
 */
public class L1046 {
}
class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i< stones.length;i++){
            queue.offer(stones[i]);
        }
        while(queue.size() > 1){
            int w1 = queue.poll();
            int w2 = queue.poll();
            if( w1 > w2)
            {
                queue.offer(w1-w2);
            }
        }
        if(queue.size() == 1)
            return queue.poll();
        else
            return 0;

    }

}