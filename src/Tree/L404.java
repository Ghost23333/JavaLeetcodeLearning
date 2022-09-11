package Tree;

import java.util.logging.Level;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L404.java
 * @Description TODO
 * @createTime 2022年09月11日 14:48:00
 */
public class L404 {
}
class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        return dfs(root);

    }
    public int dfs(TreeNode root){
        int num = 0;
        //叶子节点
        if(root.left !=null){
            if(root.left.left ==null && root.left.right==null){
                num += root.left.val;
            }else {
                num += dfs(root.left);
            }
        }
        if(root.right !=null){
            num += dfs(root.right);
        }
        return num;
    }
}