package Tree;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName Offer7.java
 * @Description TODO
 * @createTime 2020年11月10日 16:17:00
 */
public class Offer7 {
}

class Solutionoffer7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0],null,null);
        int left_length = 0;
        int val = preorder[0];
        for(int i =0;i< inorder.length;i++){
            if(val == inorder[i]){
                left_length = i;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder,1,1+left_length),Arrays.copyOfRange(inorder,0,left_length));
        root.right = buildTree(Arrays.copyOfRange(preorder,1+left_length,preorder.length),Arrays.copyOfRange(inorder,left_length+1,inorder.length));

        return root;

    }
}
