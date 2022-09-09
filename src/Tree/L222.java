package Tree;

import org.w3c.dom.Node;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L222.java
 * @Description TODO
 * @createTime 2022年09月09日 17:06:00
 */
public class L222 {
}

class Solution222 {
    //简单dfs,针对于普通二叉树
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    //针对完全二叉树的dfs
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNodesNum = getTreeDepth(root.left);
        int rightNodesNum = getTreeDepth(root.right);
        if (leftNodesNum == rightNodesNum) {
            return (1 << leftNodesNum) - 1 + countNodes2(root.right) + 1;
        } else {
            return (1 << rightNodesNum) - 1 + countNodes2(root.left) + 1;
        }
    }

    public int getTreeDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }
}