package Tree;

import java.util.PriorityQueue;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L450.java
 * @Description TODO
 * @createTime 2022年09月17日 13:38:00
 */
public class L450 {
}

class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return dfs(root,key);

    }
    public TreeNode dfs(TreeNode root ,int key){
        if(root ==null){
            return null;
        }
        if(root.val > key){
            root.left = dfs(root.left,key);
        }else if(root.val < key){
            root.right = dfs(root.right,key);
        }else {
            if(root.left ==null){
                return root.right;
            }else if(root.right ==null){
                return root.left;
            }
            TreeNode node = root.right;
            while (node.left != null){
                node = node.left;
            }
            node.left = root.left;
            root = root.right;
        }
        return root;
    }

}
