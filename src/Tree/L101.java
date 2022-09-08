package Tree;

import java.awt.desktop.QuitEvent;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L101.java
 * @Description TODO
 * @createTime 2022年09月07日 15:15:00
 */
public class L101 {
}

class Solution101 {
    //递归实现
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        } else if (a.val != b.val) {
            return false;
        }
        return judge(a.left, b.right) && judge(a.right, b.left);
    }

    //迭代实现
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode a = queue.poll();
            TreeNode b = queue.poll();
            if (a != null && b != null) {
                if (a.val != b.val) {
                    return false;
                }
                queue.offer(a.left);
                queue.offer(b.right);
                queue.offer(a.right);
                queue.offer(b.left);
            } else if (a == null && b != null || a != null && b == null) {
                return false;
            }
        }
        return true;
    }
}