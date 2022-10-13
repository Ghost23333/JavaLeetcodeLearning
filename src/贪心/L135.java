package 贪心;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L35.java
 * @Description TODO
 * @createTime 2022年10月03日 17:34:00
 */
public class L135 {
    public static void main(String[] args) {
        Solution135 s = new Solution135();
        s.candy(new int[]{1,3,4,5,2});
    }


}
//从左到右，再从右到左循环
class Solution135 {
    public int candy(int[] ratings) {
        if (ratings.length <= 1)
            return ratings.length;
        int[] ansArr = new int[ratings.length];
        Arrays.fill(ansArr, 1);

        //从左往右
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ansArr[i] = ansArr[i - 1] + 1;
            }
        }
        int ans = ansArr[ratings.length - 1];
        //从右往左
        for (int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]){
                ansArr[i] = Math.max(ansArr[i+1] + 1,ansArr[i]);
            }
            ans += ansArr[i];
        }
        return ans;
    }
}
