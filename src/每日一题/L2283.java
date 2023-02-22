package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L2283.java
 * @Description TODO
 * @createTime 2023年01月11日 20:46:00
 */
public class L2283 {
    public static void main(String[] args) {
        new Solution2283().digitCount("1210");
    }
}
class Solution2283 {
        public boolean digitCount(String num) {
            int n = num.length();
            int []count = new int[10];
            for (int i = 0; i < n; i++) {
                count[num.charAt(i) - '0']++;
            }
            for (int i = 0; i < n; i++) {
                if(num.charAt(i) - '0' != count[i])
                    return false;
            }
            return true;
        }
}