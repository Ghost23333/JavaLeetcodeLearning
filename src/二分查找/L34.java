package 二分查找;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L34.java
 * @Description TODO
 * @createTime 2022年01月08日 21:57:00
 */
public class L34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int []ans = new int[]{-1,-1};
            int left = 0;
            int right = nums.length - 1;
            while(left <= right){
                int middle = left + ((right - left)>>1);
                if(nums[middle] > target){
                    right = middle - 1;
                } else if(nums[middle] < target){
                    left = middle + 1;
                }else {
                    int i = middle;
                    while(middle< nums.length && nums[middle] == target){
                        middle ++;
                    }
                    ans[1]=middle - 1;
                    while(i >=0 && nums[i] == target){
                        i --;
                    }
                    ans[0] = i + 1;
                    return ans;
                }
            }
            return ans;
        }
    }
}
