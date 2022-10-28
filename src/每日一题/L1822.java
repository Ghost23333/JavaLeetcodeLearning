package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L822.java
 * @Description TODO
 * @createTime 2022年10月27日 09:36:00
 */
public class L1822 {
}
class Solution1822 {
    public int arraySign(int[] nums) {
        int neg = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                return 0;
            else if(nums[i] < 0)
                neg++;
        }
        if(neg % 2 == 0)
            return 1;
        return -1;
    }
}