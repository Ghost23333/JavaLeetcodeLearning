package Tree;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.security.PublicKey;
import java.util.HashMap;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L05.java
 * @Description TODO
 * @createTime 2022年09月13日 10:53:00
 */
public class L105 {
}

/*
 * 跟L106很类似
 * */
class Solution105 {
    HashMap<Integer, Integer> indexOfArrayMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexOfArrayMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexOfArrayMap.put(inorder[i], i);
        }
        return dfs(0, preorder.length - 1, 0, inorder.length - 1, preorder);

    }

    public TreeNode dfs(int p_start, int p_end, int i_start, int i_end, int[] preorder) {
        if (p_start > p_end) {
            return null;
        }
        int rootVal = preorder[p_start];
        int rootIndex = indexOfArrayMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int length = rootIndex - i_start - 1;
        root.left = dfs(p_start + 1, p_start + 1 + length, i_start, rootIndex - 1, preorder);
        root.right = dfs(p_start + 1 + length + 1, p_end, rootIndex + 1, i_end, preorder);
        return root;
    }
}