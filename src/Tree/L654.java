package Tree;

import java.util.HashMap;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L654.java
 * @Description TODO
 * @createTime 2022年09月13日 16:49:00
 */
public class L654 {
}
class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length - 1);

    }
    public TreeNode dfs(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int index = left;
        int maxNum = nums[left];
        for (int i = left; i <= right; i++) {
            if(nums[i] > maxNum){
                maxNum = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        root.left = dfs(nums,left,index - 1);
        root.right = dfs(nums,index + 1,right);
        return  root;
    }
}