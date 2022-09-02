package Tree.二叉树层序遍历;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName leverOrder.java
 * @Description TODO
 * @createTime 2022年09月02日 16:36:00
 */
public class leverOrder {

    //利用迭代的宽度优先(bfs)
    public List<List<Integer>> bfsLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> item = new ArrayList<>();
            int len = queue.size();
            while(len > 0){
                TreeNode temp = queue.poll();
                item.add(temp.val);
                if(temp.left !=null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                len--;
            }
            res.add(item);

        }
        return res;
    }
}
