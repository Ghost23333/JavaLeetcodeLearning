package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L669.java
 * @Description TODO
 * @createTime 2020年11月08日 11:27:00
 */
public class L669 {
}
class Solution669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        return fun(root,low,high);
    }

    TreeNode fun(TreeNode root,int low,int high) {
        if(root == null )
            return null;
        if(root.val < low){
            return fun(root.right,low,high);
        }else if(root.val >high){
            return fun(root.left,low,high);
        }else {
            root.right = fun(root.right,low,high);
            root.left = fun(root.left,low,high);
        }
        return root;
    }
}

