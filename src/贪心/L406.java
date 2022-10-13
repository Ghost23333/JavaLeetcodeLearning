package 贪心;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L406.java
 * @Description TODO
 * @createTime 2022年10月04日 12:34:00
 */
public class L406 {
}
class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
       Arrays.sort(people,(a,b)->{
           if(a[0] == b[0]){
               return a[1] - b[1];
           }
           return b[0] - a[0];
       });
       LinkedList<int []> queue = new LinkedList<>();
        for (int[] person : people) {
            queue.add(person[1],person);
        }
        return queue.toArray(new int[people.length][]);
    }
}