package 数组.每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L34.java
 * @Description TODO
 * @createTime 2020年12月01日 09:33:00
 */
public class L34 {
    public static void main(String[] args) {
        int []nums = {1,2,2};
        Solution34 s = new Solution34();
        s.searchRange(nums,2);
    }
}
class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target)
            return new int[2];
        int []ans = {-1,-1};
        int index1 = fun(nums,0,nums.length-1,target);
        if(index1 == -1){
            return ans;
        }
        int i;
        for(i = index1 - 1;i>=0;i--){
            if(nums[i] != target)
                break;
        }
        ans[0] = i+1;
        for(i = index1 + 1;i<nums.length;i++){
            if(nums[i] != target)
                break;
        }
        ans[1] = i - 1;
        return ans;

    }

    int fun(int []nums,int begin,int end, int target){
        if(begin > end)
            return -1;
        int mid = (end - begin)/2 + begin;
        if(nums[mid] > target){ return fun(nums,begin,mid - 1,target);
        }else if(nums[mid] < target){
            return fun(nums,mid + 1,end,target);
        }else{
            return mid;
        }
    }

}
