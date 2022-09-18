package Tree;

import javax.swing.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L530.java
 * @Description TODO
 * @createTime 2022年09月15日 08:42:00
 */
public class L530 {
    public static void main(String[] args) {
        Solution530 s = new Solution530();
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(0);
        TreeNode b = new TreeNode(48);
        TreeNode c = new TreeNode(12);
        TreeNode d = new TreeNode(49);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        s.getMinimumDifference(root);
    }



}
class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    int pre = -100001;
    int min = 100001;
    public void dfs(TreeNode root){
        if(root != null){
            dfs(root.left);
            if(root.val - pre < min){
                min = root.val - pre;
            }
            pre = root.val;
            dfs(root.right);
        }
    }
}