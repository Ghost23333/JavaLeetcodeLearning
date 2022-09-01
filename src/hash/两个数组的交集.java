package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 两个数组的交集.java
 * @Description TODO
 * @createTime 2022年04月12日 17:05:00
 */
public class 两个数组的交集 {
}
class Solution249 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set set = new HashSet<Integer>();
        Set ans = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if(set.contains(i))
                ans.add(i);
        }
        int []resArr = new int[ans.size()];
        int index = 0;
        for (Object an : ans) {
            resArr[index++] = (int) an;
        }
        return resArr;
    }
}