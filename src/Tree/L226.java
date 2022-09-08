package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L226.java
 * @Description TODO
 * @createTime 2020年11月03日 21:00:00
 */
public class L226 {
}

class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        return fun(root);
    }
    public TreeNode fun(TreeNode root) {
        if(root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }
}

