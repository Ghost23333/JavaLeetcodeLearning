package 数组.移除元素;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L26.java
 * @Description TODO
 * @createTime 2022年01月29日 17:26:00
 */
public class L26 {
}
class Solution26 {
    public int removeDuplicates(int[] nums) {
        int i = 0,k = 0;
        for(;i < nums.length;i++){
            if(nums[k] != nums[i]){
                nums[++k] = nums[i];
            }
        }
        return k + 1;

    }
}
