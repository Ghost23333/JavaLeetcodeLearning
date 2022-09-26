package 回溯;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L40.java
 * @Description TODO
 * @createTime 2022年09月21日 11:29:00
 */
public class L40 {
}

class Solution40 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList path = new LinkedList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates,target,0,0);
        return ans;

    }

    public void backTracking(int[] candidates,int target,int tempSum, int startIndex){
        if(tempSum > target){
            return;
        }
        if(tempSum == target){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex,pre = 0; i < candidates.length; i++) {
            if(candidates[i] == pre){
                continue;
            }
            pre = candidates[i];
            if (candidates[i] + tempSum <= target) {
                path.add(candidates[i]);
                backTracking(candidates, target, tempSum + candidates[i],i + 1 );
                path.removeLast();
            } else {
                break;
            }
        }
    }
}
