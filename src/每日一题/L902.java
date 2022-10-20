package 每日一题;

import javax.sound.sampled.LineUnavailableException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L902.java
 * @Description TODO
 * @createTime 2022年10月18日 16:13:00
 */
public class L902 {
    public static void main(String[] args) {
        new Solution902().atMostNGivenDigitSet(new String[]{"3","5"},4);
    }
}

class Solution902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {

        int[]nums = new int[digits.length]; //定义nums数组
        //将digits转为nums数组
        for (int i = 0; i < digits.length; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        //将数字转化为list数组
        ArrayList<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }

        int ans = 0;
        int m = digits.length;
        int len = list.size();
        //位数比n少的情况,这种情况就是排列组合，这种情况下长度为len < n的长度 的每一位都可以有m种排法
        for (int i = 1; i < len; i++) {
            ans += Math.pow(m, i);
        }
        //位数和n相同，从list的最高位往最低位遍历
        for (int i = len - 1; i >= 0; i--) {
            //找到nums中大于大于或等于当前位的索引
            int j = 0;
            for (; j < m; j++) {
                if (nums[j] >= list.get(i)) {
                    break;
                }
            }
            //这表示nums均小于当前位，这也就说明当前位和之后的位数位置上可以选择nums数组中所有数字
            if (j == m){
                ans += m * Math.pow(m,i);
                break;
            }
            //若nums[j]等于当前位 nums[j]保留到下一位数，比nums[j]小的这次循环就可以直接求出其后的解
            if(nums[j] == list.get(i)){
                //i - 0 + 1 —1 代表的还剩下的位数
                ans += j * Math.pow(m, i);
                //若为最后一位 上面j * Math.pow(m, i)=0 这时应该+1
                if(i == 0)
                    ans ++;
                //若nums[j]大于当前位 nums[j]保留到下一位数，比nums[j]小的这次循环就可以直接求出其后的解
            }else if(nums[j] > list.get(i)){
                ans += j * Math.pow(m,i);
                break;
            }
        }
        return ans;
    }
}