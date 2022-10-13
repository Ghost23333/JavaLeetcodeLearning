package 贪心;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L53.java
 * @Description TODO
 * @createTime 2022年09月28日 11:02:00
 */
public class L53 {
}
class Solution53 {
    public int maxSubArray(int[] nums) {

        int ans = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count+=nums[i];
            if(count>ans){
                ans = count;
            }
            if(count<0)
            {
                count=0;
            }

        }
        return ans;
    }
}