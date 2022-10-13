package 贪心;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L55.java
 * @Description TODO
 * @createTime 2020年11月22日 11:16:00
 */
public class L55 {
}

/*class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length == 1)
            return true;
        for(int i = 0;i< nums.length;i++){
            for(int j = 0;j<nums[i] - 1;j++){
                if(!fun(nums)){
                    nums[i] --;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public boolean fun(int []nums){
        for(int i = 0;i< nums.length;){
            if(nums[i] + i >= nums.length)
                return true;
            if(nums[i] == 0)
                return false;
            i = nums[i] + i;
        }
        return false;
    }
}*/

class Solution55{
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange,nums[i] + i);
            if(coverRange >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
