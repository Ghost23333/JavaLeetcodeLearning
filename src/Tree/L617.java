package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L617.java
 * @Description TODO
 * @createTime 2022年09月14日 15:22:00
 */
public class L617 {
    public static void main(String[] args) {
        Solution617 s = new Solution617();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        root1.left = a;
        a.left = b;
        root2.right = c;
        c.right = d;
        TreeNode root = s.mergeTrees(root1,root2);
    }
}

class Solution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
