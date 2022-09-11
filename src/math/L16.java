package math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L16.java
 * @Description TODO
 * @createTime 2022年09月09日 20:58:00
 */
public class L16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        solution16.threeSumClosest(new int[]{0,0,0},1);
    }
}
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            for(int j = i + 1;j<nums.length;j++){
                for(int k = j + 1;k< nums.length;k++){
                    set.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        double min = Double.MAX_VALUE;
        int res = 0;
        for (Integer integer : set) {
            if(Math.abs(integer - target) < min){
                min = Math.abs(integer - target);
                res = integer;
            }
        }
        return res;

    }
}