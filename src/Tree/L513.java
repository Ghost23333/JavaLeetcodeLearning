package Tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L513.java
 * @Description TODO
 * @createTime 2022年09月11日 15:18:00
 */
public class L513 {
}
class Solution513 {

    //迭代法 bfs
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = root.val;
        while (!queue.isEmpty()){
            int len = queue.size();
            res = queue.peek().val;
            while (len > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right !=null){
                    queue.offer(node.right);
                }
                len--;
            }
        }
        return res;
    }


    //递归 这个错在哪里了？？？
    public int findBottomLeftValue2(TreeNode root){
        if(root.left == null&&root.right==null){
            return root.val;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(leftDepth >= rightDepth){
            return findBottomLeftValue2(root.left);
        }else{
            return findBottomLeftValue2(root.right);
        }
    }
    public int getDepth(TreeNode root){
        int depth = 0;
        if(root == null){
            return depth;
        }
        return getDepth(root.left) + getDepth(root.right) + 1;
    }
}

class Solution513_2 {
    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }
}