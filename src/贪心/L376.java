package 贪心;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L376.java
 * @Description TODO
 * @createTime 2022年09月26日 15:22:00
 */
public class L376 {
    public static void main(String[] args) {
        Solution376 s = new Solution376();
        s.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8});
    }
}

class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int ans = 1;
        int count = 1;
        int flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                if (flag <= 0) {
                    count++;
                }
                flag = 1;
            } else {
                if (flag >= 0) {
                    count++;
                }
                flag = -1;
            }
        }
        return Math.max(count, ans);

    }

    public int wiggleMaxLength2(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int count = 1;
        int curDiff = 0;
        int preDiff = 0;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)){
                preDiff = curDiff;
                count++;
            }
        }
        return count;

    }
}