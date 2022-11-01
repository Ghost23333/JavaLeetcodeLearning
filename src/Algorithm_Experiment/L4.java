package Algorithm_Experiment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




public class L4 {
    public static void main(String[] args) {
        System.out.println("nums1:1,3,5,7,9,10,11,12");
        System.out.println("nums2:2,4,6,8");
        System.out.println( new Solution().findMedianSortedArrays(new int[]{1,3,5,7,9,10,11,12},new int[]{2,4,6,8}));
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        //如果数组总长为奇数
        if (m + n % 2 == 1) {
            int midIndex = m + n / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        }
        //数组总长度为偶数时
        else {
            int midIndex1 = (m + n) / 2 - 1, midIndex2 = (m + n) / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;
        while (true) {
            // 边界情况,数组1已经排除完，直接从数组2取
            if (index1 == m) {
                return nums2[index2 + k - 1];
            }
            // 边界情况,数组2已经排除完，直接从数组1取
            if (index2 == n) {
                return nums1[index1 + k - 1];
            }
            //边界情况,取到最后一个数字了
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, m) - 1;
            int newIndex2 = Math.min(index2 + half, n) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}



