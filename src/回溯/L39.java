package 回溯;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L39.java
 * @Description TODO
 * @createTime 2022年09月21日 10:00:00
 */
public class L39 {
    public static void main(String[] args) {
        Solution39 s = new Solution39();
        s.combinationSum(new int[]{2,3,5},8);

    }
}
class Solution39 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking2(candidates,target,0,0);
        return ans;
    }
    public void backTracking2 (int []candidates,int target, int tempSum,int startIndex){
        if(tempSum > target){
            return;
        }
        if(tempSum == target){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] + tempSum <= target) {
                path.add(candidates[i]);
                backTracking2(candidates, target, tempSum + candidates[i],i);
                path.removeLast();
            } else {
                break;
            }
        }
    }
    public void backTracking(int[] candidates,int target,int tempSum){
        if(tempSum > target){
            return;
        }
        if(tempSum == target){
            path.sort((o1, o2) -> o1 - o2);
            int i = 0;
            for (; i < ans.size(); i++) {
                if(ans.get(i).equals(path)){
                    break;
                }
            }
            if(i == ans.size()){
                System.out.println(path);
                ans.add(new ArrayList<>(path));
            }
            return;
        }


        for (Integer candidate : candidates) {
            if (tempSum + candidate <= target) {
                path.add(candidate);
                backTracking(candidates, target, tempSum + candidate);
                path.remove(candidate);
            } else {
                break;
            }
        }
    }




}