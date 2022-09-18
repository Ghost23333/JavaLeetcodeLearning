package Tree;

import javax.net.ssl.HostnameVerifier;
import java.awt.*;
import java.util.PropertyResourceBundle;

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

    public TreeNode trimBST2(TreeNode root, int low, int high){
        return dfs(root,low,high);
    }
    TreeNode dfs(TreeNode root,int low ,int high){
        if(root == null){
            return null;
        }
        if(root.val < low){
            return  dfs(root.right,low,high);
        }
        if(root.val > high){
            return dfs(root.left,low,high);
        }else {
            root.left = dfs(root.left,low, high);
            root.right = dfs(root.right,low,high);
        }
        return root;
    }

    /*迭代解法*/
    public TreeNode trimBST3(TreeNode root, int low, int high){
        //首先将root置于 [low,high]区间
        while(root !=null &&(root.val <low || root.val > high)){
            if(root.val <low){
                root = root.right;
            }else {
                root = root.left;
            }
        }
        if(root == null){
            return null;
        }
        //然后对root的左右孩子进行剪枝

        //root的左节点出界的情况只能是小于low
        for(TreeNode node = root;node.left != null;){
            if(node.left.val < low){
                node.left = node.left.right;
            }else {
                node = node.left;
            }
        }

        for(TreeNode node = root;node.right != null;){
            if(node.right.val > high){
                node.right = node.right.left;
            }else {
                node = node.right;
            }
        }
        return root;

    }
}

