package 数组;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L977.java
 * @Description TODO
 * @createTime 2022年02月13日 20:49:00
 */
public class L977 {

//  较大数只可能从两端产生
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
                if (nums[i] * nums[i] > nums[j] * nums[j]) {
                    ans[pos] = nums[i] * nums[i];
                    ++i;
                } else {
                    ans[pos] = nums[j] * nums[j];
                    --j;
                }
                --pos;
            }
            return ans;
        }
    }

}
