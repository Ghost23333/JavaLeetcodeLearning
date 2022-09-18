package Tree;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L501.java
 * @Description TODO
 * @createTime 2022年09月16日 14:13:00
 */
public class L501 {
}
class Solution501 {
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        inorder(root,hashMap);
        List<Integer> res = new ArrayList<>();
        int max = -1;
        for (Integer integer : hashMap.keySet()) {
            if(hashMap.get(integer) > max){
                max = hashMap.get(integer);
            }
        }
        for (Integer integer : hashMap.keySet()) {
            if(hashMap.get(integer) == max){
                res.add(integer);
            }
        }
        int []nums = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }
        return nums;


    }
    public void inorder(TreeNode root,HashMap<Integer,Integer> hashMap){
        if(root !=null){
            inorder(root.left,hashMap);
            hashMap.put(root.val,hashMap.getOrDefault(root.val,0) + 1);
            inorder(root.right,hashMap);
        }
    }

    //中序遍历的优化,不采用hashmap来存储

    int maxCount,pre=100001,count;
    List<Integer> answer = new ArrayList<>();
    public int[] findMode2(TreeNode root){
        dfs(root);
        int []ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;

    }
    public void update(int cur){
        if(cur == pre){
            count ++;
        }else{
            count = 1;
            pre = cur;
        }
        if(count == maxCount){
            answer.add(cur);
        }
        if(count > maxCount){
            maxCount = count;
            answer.clear();//清空answer数组
            answer.add(cur);
        }
    }
    public void dfs(TreeNode root){
        if(root != null){
            dfs(root.left);
            update(root.val);
            dfs(root.right);
        }
    }
}