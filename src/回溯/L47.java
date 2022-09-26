package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L47.java
 * @Description TODO
 * @createTime 2022年09月24日 21:27:00
 */
public class L47 {
}

class Solution47 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean []used ;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums);
        return ans;
    }

    public void backTracking(int[] nums) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i -1] && !used[i - 1]){
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTracking(nums);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}