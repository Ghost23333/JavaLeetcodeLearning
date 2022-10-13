package 贪心;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L738.java
 * @Description TODO
 * @createTime 2022年10月06日 11:12:00
 */
public class L738 {
    public static void main(String[] args) {
        Solution738 s = new Solution738();
        s.monotoneIncreasingDigits(10);
    }
}

class Solution738 {
    public int monotoneIncreasingDigits(int n) {
        if (n >= 0 && n <= 9)
            return n;
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            if(chars[i] < chars[i - 1]){
                for(int j = i;j<chars.length;j++){
                    chars[j] = '9';
                }
                chars[i - 1] -= 1;
            }
        }
        return Integer.valueOf(String.valueOf(chars));
    }
}