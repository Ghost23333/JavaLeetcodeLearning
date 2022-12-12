package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1827.java
 * @Description TODO
 * @createTime 2022年12月11日 09:43:00
 */
public class L1827 {
}

class Solution1827 {
    public int minOperations(int[] nums) {
        if (nums.length == 1)
            return 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return count;
    }
}