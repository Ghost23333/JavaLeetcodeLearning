package sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 两个数组的交集.java
 * @Description TODO
 * @createTime 2020年12月06日 22:05:00
 */
public class 两个数组的交集 {
}
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i : nums1){
            hashSet.add(i);
        }
        for(int i : nums2){
            if(hashSet.contains(i)){
                hashSet.remove(i);
                ans.add(i);
            }
        }
        int []a = new int[ans.size()];
        for(int i =0;i<ans.size();i++){
            a[i] = ans.get(i);
        }
        return a;

    }
}