package Tree.二叉树层序遍历;

import Tree.TreeNode;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L515.java
 * @Description TODO
 * @createTime 2022年09月04日 21:05:00
 */
public class L515 {
}

class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            while (len > 0){
                TreeNode temp = queue.poll();
                max = Math.max(max,temp.val);
                if(temp.left !=null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                len--;
            }
            res.add(max);
        }
        return res;

    }
}
