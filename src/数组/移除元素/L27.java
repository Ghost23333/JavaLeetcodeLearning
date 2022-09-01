package 数组.移除元素;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L27.java
 * @Description TODO
 * @createTime 2022年01月29日 16:58:00
 */
public class L27 {
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, k = 0;
        for (; i < nums.length; i++) {
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }
        return k;

    }
}


//方法一的优化
class Solution2 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}