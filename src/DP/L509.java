package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L509.java
 * @Description TODO
 * @createTime 2022年10月07日 11:40:00
 */
public class L509 {
}
class Solution509 {
    public int fib(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}