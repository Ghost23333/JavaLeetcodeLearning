package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1752.java
 * @Description TODO
 * @createTime 2022年11月27日 15:44:00
 */
public class L1752 {
    public static void main(String[] args) {
        new Solution1752().check(new int[]{3,4,5,1,2});
    }
}
class Solution1752 {
    public boolean check(int[] nums) {
        int count = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <  pre) {
                count++;
            }
            pre = nums[i];
            if(count > 1)
                return false;
        }
        if(nums[nums.length - 1] > nums[0])
            count++;
        if(count > 1)
            return false;
        return true;
    }
}