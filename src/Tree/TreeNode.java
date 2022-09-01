package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName DFS.TreeNode.java
 * @Description TODO
 * @createTime 2020年10月26日 16:48:00
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
