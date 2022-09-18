package Tree;

import com.sun.source.doctree.DocRootTree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L538.java
 * @Description TODO
 * @createTime 2022年09月18日 16:33:00
 */
public class L538 {
}
class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    int pre = 0;
    public void dfs(TreeNode root){
        if(root!=null){
            dfs(root.right);
            root.val += pre;
            pre = root.val;
            dfs(root.left);
        }
    }
}