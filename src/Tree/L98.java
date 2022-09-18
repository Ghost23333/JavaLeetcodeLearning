package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L98.java
 * @Description TODO
 * @createTime 2022年09月14日 16:20:00
 */
public class L98 {
}

class Solution98 {
    //这样做是错的因为不能保证子树中的节点一定大于或小于根节点的值
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    long pre = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBST2(root.left)){
            return false;
        }
        if(pre >= root.val){
            return false;
        }
        pre = root.val;
        return isValidBST2(root.right);
    }
}