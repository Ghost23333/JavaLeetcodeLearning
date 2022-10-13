package 贪心;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L45.java
 * @Description TODO
 * @createTime 2022年09月28日 14:03:00
 */
public class L45 {
    public static void main(String[] args) {
        Solution45 s =new Solution45();
        s.jump(new int[]{2,3,1,1,4});
    }
}
class Solution45 {
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int coverRange = 0;
        int pre = 0;
        int ans = 0;
        while (true){
            int temp = coverRange;
            for(int i=pre;i<=coverRange;i++){
                temp = Math.max(nums[i] + i,temp);
            }
            ans ++;
            pre = coverRange;
            coverRange = temp;
            if(coverRange >= nums.length - 1){
                return ans;
            }
        }
    }
}

class Solution45_2 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}