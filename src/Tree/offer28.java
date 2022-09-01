package Tree;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName offer28.java
 * @Description TODO
 * @createTime 2020年11月10日 20:09:00
 */
public class offer28 {
}
class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return recur(root.left,root.right);

    }

    public boolean recur(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right ==null || left.val != right.val){
            return false;
        }else {
            return recur(left.left,right.right)&&recur(left.right,right.left);
        }
    }
}