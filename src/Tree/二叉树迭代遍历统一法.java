package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 二叉树迭代遍历统一法.java
 * @Description TODO
 * @createTime 2022年09月01日 21:00:00
 */

/*
*关键是在往栈中添加元素时，轮到访问节点时先不访问，而是做一个标记，具体做法就是接着push一个null节点到栈中，这样当访问
 空节点时，可知道此时该访问这个节点了
* */

public class 二叉树迭代遍历统一法 {
    public static void main(String[] args) {
    }

}

class Solution11 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            }
            else {//遇到要访问的节点了
                result.add(stack.peek().val);
                stack.pop();
            }
        }
        return result;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (node.left != null) {
                    stack.push(node.left);
                }

            }
            else {//遇到要访问的节点了
                result.add(stack.peek().val);
                stack.pop();
            }
        }
        return result;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root != null){
            stack.push(root);
        }
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }

            }
            else {//遇到要访问的节点了
                result.add(stack.peek().val);
                stack.pop();
            }
        }
        return result;
    }
}

