package Tree.二叉树层序遍历;

import Tree.TreeNode;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L107.java
 * @Description TODO
 * @createTime 2022年09月02日 17:10:00
 */
public class L107 {
}

class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Stack<List<Integer>> stack = new Stack<>();
        for(List<Integer> item : res){
            stack.push(item);
        }
        //通过栈将元素倒置
        res = new ArrayList<>();
        while(!stack.empty()){
            res.add(stack.pop());
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
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
            //直接将元素添加到队列开头
            res.add(0,item);

        }
        Stack<List<Integer>> stack = new Stack<>();
        return res;
    }
}
