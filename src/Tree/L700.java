package Tree;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L700.java
 * @Description TODO
 * @createTime 2022年09月14日 16:01:00
 */
public class L700 {
}
class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            return searchBST(root.left,val);
        }else {
            return searchBST(root.right,val);
        }
    }
}