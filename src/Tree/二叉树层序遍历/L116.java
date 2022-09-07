package Tree.二叉树层序遍历;

import java.awt.image.renderable.RenderableImage;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L16.java
 * @Description TODO
 * @createTime 2022年09月05日 17:09:00
 */
public class L116 {
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node pre = null;
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if(pre != null){
                    pre.next = node;
                }
                pre = node;
                if(node.left !=null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }

        }
        return root;
    }

    public Node connect2(Node root){
        if (root == null) {
            return null;
        }
        Node cur = root;//cur指针用于在当前层游走
        while (cur != null){
            Node dummy = new Node(0);//下一层的虚拟头节点
            Node pre = dummy;//pre指针用于在下一层游走

            //然后开始遍历当前层
            while(cur != null){
                if(cur.left != null){
                    pre.next = cur.left;
                    pre = pre.next;
                }

                if(cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            //然后将cur指针移到下一层
            cur = dummy.next;
        }
        return root;
    }
}