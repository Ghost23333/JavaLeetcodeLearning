package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L110.java
 * @Description TODO
 * @createTime 2022年09月09日 19:12:00
 */
public class L110 {
}
class Solution110 {
    //自顶向下的dfs
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1 ){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);


    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(dfs(root.left),dfs(root.right)) + 1;
    }

    //自底向上的dfs
    public boolean isBalanced2(TreeNode root){
        return getHeight(root) >= 0;
    }
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;

    }

}