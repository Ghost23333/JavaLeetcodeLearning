package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L94.java
 * @Description TODO
 * @createTime 2020年10月26日 16:47:00
 */

public class L94{

}
class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(root!=null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}

class Solution94_2{
    class NewNode {
        TreeNode node;
        boolean visited;

        public NewNode(TreeNode node,boolean flag){
            this.node = node;
            this.visited = flag;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root){
        if(root == null)
            return new ArrayList<>();
        Deque<NewNode> stack = new ArrayDeque<Solution94_2.NewNode>();
        List<Integer> ans = new ArrayList<>();

        stack.push(new NewNode(root,false));
        while (!stack.isEmpty()){
            NewNode cur = stack.pop();
            if(!cur.visited){
                if(null != cur.node.right)
                    stack.push(new NewNode(cur.node.right,false));
                stack.push(new NewNode(cur.node, true));
                if(null != cur.node.left)
                    stack.push(new NewNode(cur.node.left,false));
            }else{
                ans.add(cur.node.val);
            }
        }
        return ans;
    }
}

