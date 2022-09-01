package com.ch.array;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L283.java
 * @Description TODO
 * @createTime 2020年11月23日 16:58:00
 */
public class L283 {

}


class Solution283 {
    public void moveZeroes(int[] nums) {
        if(nums.length < 1){
            return;
        }
        int p = 0;int len = nums.length;
        for(int i =0;i<len;i++){
            if(nums[i] != 0){
                nums[p++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}