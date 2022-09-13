package Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L106.java
 * @Description TODO
 * @createTime 2022年09月13日 09:40:00
 */
public class L106 {
    public static void main(String[] args) {
        Solution106 s = new Solution106();
        s.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}

class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        if(inorder.length == 1)
            return new TreeNode(inorder[0]);
        int count = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                break;
            }
            count++;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        root.left = buildTree(Arrays.copyOfRange(inorder, 0, count), Arrays.copyOfRange(postorder, 0, count));
        root.right = buildTree(Arrays.copyOfRange(inorder, count + 1, inorder.length), Arrays.copyOfRange(postorder, count, postorder.length - 1));

        return root;
    }
}

//利用一个Map缓存将inorder中值和下标缓存下来，就不用每次都循环求index
class Solution106_2 {
    HashMap<Integer,Integer> indexOfArrayMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexOfArrayMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexOfArrayMap.put(inorder[i],i);
        }
        return dfs(0,inorder.length -1,0, postorder.length -1,postorder);
    }

    //左闭右闭区间
    public TreeNode dfs(int i_start,int i_end,int p_start,int p_end,int []postorder){
        if(i_start > i_end ||p_start > p_end){
            return null;
        }
        int rootVal = postorder[p_end];
        int rootIndex = indexOfArrayMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int length = rootIndex - i_start -1;
        root.left = dfs(i_start,rootIndex - 1,p_start,p_start + length,postorder);
        root.right = dfs(rootIndex + 1,i_end,p_start + length + 1,p_end -1 ,postorder);
        return root;
    }
}