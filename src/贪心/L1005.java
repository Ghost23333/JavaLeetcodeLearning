package 贪心;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1005.java
 * @Description TODO
 * @createTime 2022年09月29日 13:04:00
 */
public class L1005 {
    public static void main(String[] args) {
        Solution1005 s = new Solution1005();
        s.largestSumAfterKNegations(new int[]{3,-1,0,2},3);
    }
}

class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int negNum = 0;
        int ans = 0;
        for (; negNum < nums.length; negNum++) {
            if (nums[negNum] > 0) {
                break;
            }
        }
        if (k >= negNum ) {
            for (int j = 0; j < negNum; j++) {
                ans -= nums[j];
            }
            if ((k - negNum) % 2 == 0) {
                ans += nums[negNum];
            } else {
                ans -= nums[negNum];
            }
            for (int j = negNum + 1 ; j < nums.length; j++) {
                ans += nums[j];
            }
        } else {
            for (int j = 0; j < k; j++) {
                ans -= nums[j];
            }
            for (int j = k; j < nums.length; j++) {
                ans += nums[j];
            }
        }
        return ans;
    }

    public int largestSumAfterKNegations2(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0 && k > 0){
                nums[i] *= -1;
                k --;
            }
            sum += nums[i];
        }
        if(k == 0 || k % 2 == 0){
            return sum;
        }
        Arrays.sort(nums);
        return sum - nums[0]*2;
    }
}