package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L491.java
 * @Description TODO
 * @createTime 2022年09月24日 09:16:00
 */
public class L491 {
}
class Solution491 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0,-101);
        return ans;
    }

    public void backTracking(int []nums, int startIndex,int pre){
        if(startIndex >= nums.length)
            return;
        int []used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {

            if(used[nums[i] + 100] == 1){
                continue;
            }
            used[nums[i] + 100] = 1;
            if(nums[i] >= pre){
                path.add(nums[i]);
                if(path.size() >= 2){
                    ans.add(new ArrayList<>(path));
                }
                backTracking(nums,i+1,nums[i]);
                path.removeLast();
            }
        }

    }
}

