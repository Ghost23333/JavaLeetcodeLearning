/*
package com.ch.array;

*/
/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName Offer59.java
 * @Description TODO
 * @createTime 2020年11月23日 17:18:00
 *//*

public class Offer59 {
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int maxNum = Integer.MIN_VALUE;
        int len = nums.length;
        int []ans = new int[len - k + 1];
        int pos = 0;

        for(int i = 0;i<k; i++){
            maxNum = Math.max(maxNum,nums[i]);
        }
        ans[pos++] = maxNum;
        int left = 0;
        for(int i =k;i<len;i++){
            maxNum =
        }
    }
}*/
