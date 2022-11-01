package 周赛.第317;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L6220.java
 * @Description TODO
 * @createTime 2022年10月30日 10:31:00
 */
public class L6220 {
}
class Solution6220 {
    public int averageValue(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 == 0 && nums[i] % 2 ==0) {
                ans += nums[i];
                count ++;
            }
        }
        if(count == 0)
            return 0;
        return ans / count;
    }
}