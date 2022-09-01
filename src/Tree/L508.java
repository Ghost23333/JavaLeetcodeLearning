package Tree;

import java.sql.Connection;
import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L508.java
 * @Description TODO
 * @createTime 2020年11月13日 17:22:00
 */
public class L508 {
}

class Solution508 {
    HashMap<Integer,Integer> hashMap = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        fun(root);
        int maxCount = -1,length = 0;
        for(Integer count : hashMap.values()){
            if(count > maxCount){
                maxCount = count;
                length = 1;
            }
            if(count == maxCount){
                length ++;
            }
        }

        int []ans = new int[length - 1];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if(count == maxCount){
                ans[i++] = num;
            }
        }
        return ans;
    }

    int fun(TreeNode root){
        if(root != null){
            int val = root.val + fun(root.left) + fun(root.right);
            hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
            return val;
        }
        return 0;
    }

}