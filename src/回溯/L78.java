package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L78.java
 * @Description TODO
 * @createTime 2022年09月23日 19:00:00
 */
public class L78 {
}

class Solution78 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(path);
        backTracking(nums,0);
        return ans;
    }

    public void backTracking(int []nums,int startIndex){
        if(startIndex > nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backTracking(nums,i + 1);
            path.removeLast();
        }
    }
}
