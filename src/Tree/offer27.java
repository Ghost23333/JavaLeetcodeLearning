package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName offer27.java
 * @Description TODO
 * @createTime 2020年11月10日 20:04:00
 */
public class offer27 {
}

class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
