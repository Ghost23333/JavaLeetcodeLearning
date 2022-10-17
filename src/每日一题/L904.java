package 每日一题;

import java.util.Base64;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L904.java
 * @Description TODO
 * @createTime 2022年10月17日 14:12:00
 */
public class L904 {
    public static void main(String[] args) {
        new Solution().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length <= 2)
            return fruits.length;
        int ans = 1,cur = 1;
        int basket1 = fruits[0], basket2 = -1;
        for (int i = 1; i < fruits.length; i++) {
            if(fruits[i] == basket1){
                cur++;
            }else if(basket2 == -1){
                cur++;
                basket2 = fruits[i];
            }else if(fruits[i] == basket2){
                cur++;
            }else {
                ans = Math.max(ans,cur);
                basket2 = fruits[i];
                basket1 = fruits[i - 1];
                cur = 2;
                for(int j = i - 2;j >=0;j--){
                    if(fruits[j] == basket1){
                        cur++;
                    }else {
                        break;
                    }
                }
            }
        }
        return Math.max(cur,ans);
    }
}