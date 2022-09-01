package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName ms17_12.java
 * @Description TODO
 * @createTime 2020年11月06日 09:23:00
 */
public class ms17_12 {
}

//非递归
class Solutionms17_12 {
    public TreeNode convertBiNode(TreeNode root) {

        TreeNode head = new TreeNode(0);
        TreeNode pre = head;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while(node !=null || !stack.isEmpty()){

            while(node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node.left = null;
            pre.right = node;
            pre = node;

            node = node.right;
        }
        return head.right;
    }
}

//
//class Solutionms17_12_2 {
//    public DFS.TreeNode convertBiNode(DFS.TreeNode root) {
//
//
//
//    }
//
//    DFS.TreeNode fun(DFS.TreeNode node,DFS.TreeNode pre){
//        if(node != null){
//            pre = fun(node.left,pre);
//            node.left  = null;
//            pre.right = node;
//            pre = node;
//            pre = fun(node.right,pre);
//        }
//        return pre;
//    }
//}

