package 二分查找;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L704.java
 * @Description TODO
 * @createTime 2022年01月07日 20:50:00
 */
public class L704 {
    class Solution {
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;

            while (low <= high) {
                int middle = low + ((high - low) >> 1);
                if (nums[middle] < target) {
                    low = middle + 1;
                } else if (nums[middle] > target) {
                    high = middle - 1;
                } else {
                    return middle;
                }

            }
            return -1;
        }
    }
}
