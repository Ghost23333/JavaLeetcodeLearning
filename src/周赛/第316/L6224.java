package 周赛.第316;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L6224.java
 * @Description TODO
 * @createTime 2022年10月23日 10:45:00
 */
public class L6224 {
    public static void main(String[] args) {
        new Solution6224().subarrayGCD(new int[]{3,3,4,1,2},1);
    }
}
class Solution6224 {
    public int function(int i,int j)
    {
        int k;
        if(i == 0||j == 0)
            return 0;
        while(j!=0)
        {
            k = i%j;
            i = j;
            j = k;
        }
        return i;
    }
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        int count = 0;
        if(nums[0] % k == 0){
            count = 1;
            if(nums[0] == k)
                ans = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if(count > 0){
                if(function(nums[i-1],nums[i]) == k){
                    ans += count;
                    count++;
                }else {
                    if(nums[i] % k == 0){
                        count ++;
                    }else {
                        count = 0;
                    }
                }
            }
            else {
                if(nums[i] % k == 0){
                    count = 1;
                }else {
                    count = 0;
                }
            }
            if(nums[i] == k){
                ans++;
            }
        }
        return ans;
    }
}