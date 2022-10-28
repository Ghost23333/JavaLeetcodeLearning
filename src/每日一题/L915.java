package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L915.java
 * @Description TODO
 * @createTime 2022年10月24日 09:31:00
 */
public class L915 {
    public static void main(String[] args) {
        new Solution915().partitionDisjoint(new int[]{
                5,0,3,8,6});
    }
}
class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int []minNums = new int[nums.length];
        int minNum = 1000001;
        for (int i = nums.length - 1; i >= 0; i--) {
            minNums[i] = minNum;
            minNum = Math.min(nums[i],minNum);
        }
        int maxNum = -1;
        for (int i = 0; i < nums.length; i++) {
            maxNum = Math.max(maxNum,nums[i]); //更新从索引0到当前索引数组的最大值
            if(maxNum <= minNums[i]){//如果当前数组的最大值 小于等于 后面数组的最小值就满足题意返回结果
                return i + 1;
            }
        }
        return nums.length;//因为题目中说了有解，所以不会走到这一步
    }
}
