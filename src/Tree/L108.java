package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L108.java
 * @Description TODO
 * @createTime 2022年09月18日 15:27:00
 */
public class L108 {
}
class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length -1);
    }

    public TreeNode dfs(int []nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = (right - left) / 2;
        TreeNode root = new TreeNode(nums[left + mid]);
        root.left = dfs(nums,left,left + mid - 1);
        root.right = dfs(nums,left + mid + 1,right);
        return root;
    }
}