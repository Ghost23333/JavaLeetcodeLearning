package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName offer40.java
 * @Description TODO
 * @createTime 2020年10月30日 13:35:00
 */
public class offer40 {
}
class Solutionoffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int []ans = new int[k];
        if(k == 0)
            return ans;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0;i<k;i++){
            queue.offer(arr[i]);
        }
        for(int i = k;i<arr.length;i++){
            if(queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for(int i = 0;i<k;i++){
            ans[i] = queue.poll();
        }
        return ans;
    }
}