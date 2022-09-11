package Tree;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L257.java
 * @Description TODO
 * @createTime 2022年09月10日 18:31:00
 */
public class L257 {
}

class Solution257 {

    //写的很憨批的 递归+回溯
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root, "",result);
        return result;
    }
    public void dfs(TreeNode root, String path,List<String> result) {
        path += root.val;
        //root为叶子节点
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {

            dfs(root.left, path + "->",result);
        }
        if (root.right != null) {
            dfs(root.right, path + "->",result);
        }
    }

    //改进版的递归+回溯

    public List<String> binaryTreePaths2(TreeNode root){
        List<String> result = new ArrayList<>();
        if(root ==null){
            return result;
        }
        List<Integer> paths = new ArrayList<>();
        dfs2(root,paths,result);
        return result;

    }

    public void dfs2(TreeNode root,List<Integer> paths,List<String> result ){
        paths.add(root.val);
        if(root.left == null &&root.right == null){
            //找到叶子节点了
            StringBuffer path = new StringBuffer();
            for (int i = 0; i < paths.size() - 1; i++) {
                path.append(paths.get(i)).append("->");
            }
            path.append(paths.get(paths.size() - 1));
            result.add(path.toString());
            return;
        }
        if(root.left != null){
            dfs2(root.left,paths,result);
            paths.remove(paths.size() - 1);//回溯
        }
        if(root.right!=null){
            dfs2(root.right,paths,result);
            paths.remove(paths.size() - 1);
        }
    }



}