package 每日一题;

import javax.print.attribute.standard.OrientationRequested;
import java.util.PriorityQueue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L769.java
 * @Description TODO
 * @createTime 2022年10月13日 12:41:00
 */
public class L769 {
    public static void main(String[] args) {
        new Solution769().maxChunksToSorted(new int[]{2,0,1});
    }
}
class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        if(arr.length == 1)
            return 1;
        int preMax = -1;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > preMax){
                preMax = arr[i];
            }
            if(preMax == i){
                ans++;
            }
        }
        return ans;
    }
}