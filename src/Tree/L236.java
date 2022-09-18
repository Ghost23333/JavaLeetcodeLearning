package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L236.java
 * @Description TODO
 * @createTime 2022年09月16日 15:14:00
 */
public class L236 {
}

class Solution236 {

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        Boolean lson = dfs(root.left,p,q);
        Boolean rson = dfs(root.right,p,q);
        //满足条件
        if(lson&&rson || (root.val == p.val || root.val == q.val )&&(lson || rson)){
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);

    }
}