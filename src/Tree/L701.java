package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L701.java
 * @Description TODO
 * @createTime 2022年09月17日 12:38:00
 */
public class L701 {
}
class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        dfs(root,val);
        return root;
    }

    public void dfs(TreeNode root ,int val){
        if(root.val > val){
            if(root.left !=null){
                dfs(root.left,val);
            }else{
                root.left = new TreeNode(val);
            }
        }else{
            if(root.right != null){
                dfs(root.right,val);
            }else {
                root.right = new TreeNode(val);
            }
        }
    }
}