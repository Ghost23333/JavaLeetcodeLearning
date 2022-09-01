package com.ch.array;

import java.util.*;

public class LeetcodeTest {
    public static void main(String[] args) {
    }
}

/*class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int maxNum = 0;
        for(int i=0;i<candies.length;i++)
        {
            maxNum = Math.max(maxNum,candies[i]);
        }
        for(int i =0;i<candies.length;i++)
        {
            if(candies[i] + extraCandies < maxNum)
                res.add(false);
            else
                res.add(true);
        }
        return res;
    }
}*/


//414
/*
class Solution {
    public int thirdMax(int[] nums) {
        long num1 = Long.MIN_VALUE, num2 = Long.MIN_VALUE, num3 = Long.MIN_VALUE;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 0; i < len; i++) {
            if (nums[i] >= num1) {
                if (nums[i] > num1) {
                    num3 = num2;
                    num2 = num1;
                    num1 = nums[i];
                }
                continue;
            } else if (nums[i] >= num2) {
                if (nums[i] > num2) {
                    num3 = num2;
                    num2 = nums[i];
                }
                continue;
            } else if (nums[i] >= num3) {
                num3 = nums[i];
                continue;
            }
        }
        if (num3 != Long.MIN_VALUE)
            return (int) num3;
        return (int) num1;
    }
};
*/
//解法二
/*
class Solution {
    public int thirdMax(int[] nums) {
        if (len == 1)
            return nums[0];
        if (len == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        TreeSet<Integer> t = new TreeSet<Integer>();
        for(int i: nums)
        {
            t.add(i);
            if(t.size()>3)
                t.remove(t.first());
        }
        return t.size() < 3?t.last():t.first();

    }
};
*/



//605 种花问题
/*
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if( n == 0)
            return true;
        int len = flowerbed.length;
        if(len == 1) {
            if(flowerbed[0] == 0)
            {
                if(n == 1)
                    return true;
            }
            return false;
        }
        if(len == 2){
            if(flowerbed[0]==0 && flowerbed[1] == 0){
                if(n == 1)
                    return true;
                return false;
            }
            return false;
        }
        if(flowerbed[0] == 0)
        {
            if(flowerbed[1]!=1)
            {
                n--;
                flowerbed[0] = 1;
            }
        }
        if(flowerbed[len -1] ==0)
        {
            if(flowerbed[len - 2] == 0) {
                n--;
                flowerbed[len-1] = 1;
            }
        }
        for(int i = 1;i<len - 1;i++) {
            if(flowerbed[i] == 0)
            {
                if(flowerbed[i-1] ==0 && flowerbed[i+1] == 0)
                {
                   n--;
                   flowerbed[i] =1;
                }

            }
        }
        if( n > 0)
            return false;
        return true;
    }
};*/


//解二 解一真是傻逼


