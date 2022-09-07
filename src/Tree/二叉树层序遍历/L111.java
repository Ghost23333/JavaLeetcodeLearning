package Tree.二叉树层序遍历;

import Tree.TreeNode;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L111.java
 * @Description TODO
 * @createTime 2022年09月06日 23:03:00
 */
public class L111 {
}
class Solution111 {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int a = minDepth(root.left);
        int b = minDepth(root.right);
        if(a == 0)
            return b + 1;
        if(b == 0)
            return a + 1;
        return  Math.min(a,b) + 1;
    }
}