package Tree.二叉树层序遍历;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L104.java
 * @Description TODO
 * @createTime 2022年09月06日 22:54:00
 */
public class L104 {
}
class Solution104 {
    //bfs
    public int maxDepth(TreeNode root) {
        int count = 0;
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            count ++;
            int len = queue.size();
            while(len > 0){
                TreeNode temp = queue.poll();
                if(temp.left !=null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                len--;
            }
        }
        return count;
    }

    //dfs递归
    public int maxDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        int a = maxDepth2(root.left);
        int b = maxDepth2(root.right);
        return Math.max(a,b) + 1;
    }
}