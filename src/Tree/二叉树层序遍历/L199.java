package Tree.二叉树层序遍历;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L199.java
 * @Description TODO
 * @createTime 2022年09月02日 17:40:00
 */

public class L199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            TreeNode temp = null;
            while(len > 0){
                temp = queue.poll();
                if(temp.left !=null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                len--;
            }
            res.add(temp.val);

        }
        return res;
    }
}
