package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1764.java
 * @Description TODO
 * @createTime 2022年12月17日 14:28:00
 */
public class L1764 {
}

class Solution1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int startIndex = 0;
        for (int[] group : groups) {
            startIndex = findSub(group, nums, startIndex);
            if (startIndex == -1)
                return false;
        }
        return true;

    }

    public int findSub(int[] s, int[] nums, int startIndex) {
        int i = startIndex;
        int k = 0;
        while (i < nums.length && k < s.length) {
            if (nums[i] == s[k]) {
                i++;
                k++;
            } else {
                i = i - k + 1;
                k = 0;
            }
        }
        if (k != s.length)
            return -1;
        return i;
    }
}