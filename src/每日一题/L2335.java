package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L2335.java
 * @createTime 2023年02月11日 21:02:00
 */
public class L2335 {
}

class Solution2335 {
    public int fillCups(int[] amount) {
        int count = 0;
        int num1 = amount[0], num2 = amount[1], num3 = amount[2];
        while (true) {
            if (num1 == 0 && num2 == 0 && num3 == 0)
                return count;
            if (num1 * num2 * num3 == 0)
                return count + Math.max(num1, Math.max(num2, num3));
            if (num1 >= num2 && num3 >= num2) {
                num1--;
                num3--;
            } else if (num2 >= num1 && num3 >= num1) {
                num2--;
                num3--;
            } else {
                num1--;
                num2--;
            }
            count++;
        }
    }
}