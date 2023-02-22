package 二分查找;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1760.java
 * @Description TODO
 * @createTime 2022年12月21日 14:37:00
 */
public class L1760 {
    public static void main(String[] args) {
        new Solution1760().minimumSize(new int[]{2,4,8,2},4);
    }
}
class Solution1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (left <= right) {
            int y = (left + right) / 2;
            long ops = 0;
            for (int x : nums) {
                ops += (x - 1) / y;
            }
            if (ops <= maxOperations) {
                ans = y;
                right = y - 1;
            } else {
                left = y + 1;
            }
        }
        return ans;
    }
}