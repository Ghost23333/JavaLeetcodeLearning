package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L754.java
 * @Description TODO
 * @createTime 2022年11月04日 09:33:00
 */
public class L754 {
    public static void main(String[] args) {
        int a = new Solution754().reachNumber(4);
        System.out.println(a);

    }
}
class Solution754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            k++;
            target -= k;
        }
        if(target == 0)
            return k;
        int gap1 = Math.abs(target);
        int gap2 = target + k;
        if(gap1 < gap2)
            return k + gap1 * 2;
        return k - 1 + gap2 * 2;
    }
}