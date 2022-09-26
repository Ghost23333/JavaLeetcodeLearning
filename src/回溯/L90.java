package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L90.java
 * @Description TODO
 * @createTime 2022年09月23日 19:15:00
 */
public class L90 {
}

class Solution90 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        ans.add(path);
        Arrays.sort(nums);
        backTracking(nums, 0);
        return ans;

    }

    public void backTracking(int[] nums, int startIndex) {
        if (startIndex >= nums.length) {
            return;
        }
        int pre = 100;
        for (int i = startIndex; i < nums.length; i++) {
            if (pre == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backTracking(nums, i + 1);
            path.removeLast();
            pre = nums[i];
        }
    }
}