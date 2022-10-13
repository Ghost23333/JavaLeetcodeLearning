package 每日一题;

import Tree.TreeNode;

import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L870.java
 * @Description TODO
 * @createTime 2022年10月08日 20:57:00
 */
public class L870 {
    public static void main(String[] args) {
        new Solution870().advantageCount(new int[]{2,0,4,1,2},new int[]{1,3,0,0,2});
    }
}

class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            list.add(new int[]{nums2[i],i});
        }
        list.sort((a,b)->{
            return b[0] - a[0];
        });
        int j = nums1.length - 1;
        int i = 0;
        for (int k = 0; k < list.size(); k++) {
            if(nums1[j] <= list.get(i)[0]){
                nums2[list.get(k)[1]] = nums1[i++];
            }else{
                nums2[list.get(k)[1]] = nums1[j];
                j--;
            }
            if(i > j){
                break;
            }
        }
        return nums2;
    }
}