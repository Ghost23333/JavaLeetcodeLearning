package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L235.java
 * @Description TODO
 * @createTime 2020年11月05日 10:47:00
 */
public class L235 {
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (true){
            if(node.val > p.val && node.val > q.val)
                node = node.left;
            else if(node.val < p.val && node.val < q.val)
                node = node.right;
            else
                return node;
        }

    }
}
