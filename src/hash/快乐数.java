package hash;

import java.util.HashSet;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 快乐数.java
 * @Description TODO
 * @createTime 2022年04月07日 10:02:00
 */
public class 快乐数 {
    public static void main(String[] args) {
        Solution202 solution202 = new Solution202();
        solution202.isHappy(19);
    }
}

class Solution202 {
    public boolean isHappy(int n) {
        HashSet set = new HashSet<Integer>();
        while (true) {
            int ans = 0;
            while (n > 0) {
                ans += (n % 10) * (n % 10);
                n /= 10;
            }
            if (ans == 1)
                return true;

            if (set.contains(ans))
                return false;
            set.add(ans);
            n = ans;
        }
    }
}