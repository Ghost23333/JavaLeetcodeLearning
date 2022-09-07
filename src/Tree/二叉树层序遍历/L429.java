package Tree.二叉树层序遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L429.java
 * @Description TODO
 * @createTime 2022年09月04日 19:06:00
 */


public class L429 {
}
/*
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root == null){
            return new ArrayList<>();
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            List<Integer> item = new ArrayList<>();
            while(len >  0){
                Node tempNode = queue.poll();
                item.add(tempNode.val);
                for(Node node : tempNode.children){
                    if(node != null){
                        queue.offer(node);
                    }
                }
                len --;
            }
            res.add(item);
        }
        return res;
    }
}*/
