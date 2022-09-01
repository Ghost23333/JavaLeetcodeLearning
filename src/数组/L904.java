package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L904.java
 * @Description TODO
 * @createTime 2022年03月01日 18:39:00
 */
public class L904 {


    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.totalFruit(new int[]{1,2,1,2,1,4,3,4,3,4,3});
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length<=2)
            return fruits.length;
        int left = fruits[0],right = -1;
        int ans = 1;
        int res = -1;
        for(int i =1;i<fruits.length;i++){
            if(fruits[i] == left || fruits[i] == right)
                ans ++;
            else if(right == -1){
                ans ++;
                right = fruits[i];
            }else {
                //往回推
                int j = i - 1;
                while(j>0&&fruits[j] == fruits[j-1]){
                    j--;
                }
                left = fruits[j];
                right = fruits[i];
                res = Math.max(res,ans);
                ans = i-j+1;
            }
        }
        return Math.max(ans,res);
    }
}


//滑动窗口模板
class Solution1 {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        int n = tree.length;

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int i = 0; i < n; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);  // 右边界
            while (map.size() > 2) {  // 不符合条件：水果种类大于2
                map.put(tree[left], map.get(tree[left]) - 1);
                if (map.get(tree[left]) == 0) map.remove(tree[left]);
                left++;  // 左边界
            }
            maxLen = Math.max(maxLen, i - left + 1); // 更新结果
        }
        return maxLen;
    }
}