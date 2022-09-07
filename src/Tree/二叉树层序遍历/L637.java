package Tree.二叉树层序遍历;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L637.java
 * @Description TODO
 * @createTime 2022年09月03日 22:45:00
 */
public class L637 {
}

class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Double item = 0.0;
            int len = queue.size();
            int num = len;
            while (len > 0) {
                TreeNode temp = queue.poll();
                item += temp.val;
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
            res.add(item/num);

        }
        return res;

    }
}
