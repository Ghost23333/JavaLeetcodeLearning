package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L46.java
 * @Description TODO
 * @createTime 2022年09月24日 20:00:00
 */
public class L46 {
    public static void main(String[] args) {
        Solution46 s = new Solution46();
        System.out.println(s.permute(new int[]{1,2,3}));
    }
}

class Solution46 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int[] used = new int[21];

    public List<List<Integer>> permute(int[] nums) {
        backTracking(nums);
        return ans;
    }

    public void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i + 10] == 0){
                path.add(nums[i]);
                used[i + 10] = 1;
                backTracking(nums);
                used[i + 10 ] = 0;
                path.removeLast();
            }
        }
    }
}