package sort;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 判断能否形成等差数列.java
 * @Description TODO
 * @createTime 2020年12月10日 21:07:00
 */
public class 判断能否形成等差数列 {
    public static void main(String[] args) {
        Solution1502_2 s = new Solution1502_2();
        s.canMakeArithmeticProgression(new int[]{0,0,0,0});
    }
}

class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 3)
            return true;
        Arrays.sort(arr);
        int sub = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != sub)
                return false;
        }
        return true;
    }
}


/**
 * 使用set
 */
class Solution1502_2 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 3)
            return true;
        HashSet<Integer> set = new HashSet<>();
        int maxNum = -1000001, minNum = 1000001;
        for (int i = 0; i < arr.length; i++) {
            minNum = Math.min(minNum, arr[i]);
            maxNum = Math.max(maxNum, arr[i]);
            set.add(arr[i]);
        }
        if(maxNum == minNum)
            return true;
        if (set.size() != arr.length)
            return false;
        int sub = (maxNum - minNum)/(arr.length - 1);
        for (int i = 0; i < arr.length - 1; i++) {
            minNum += sub;
            if(!set.contains(minNum)){
                return false;
            }
        }
        return true;
    }
}