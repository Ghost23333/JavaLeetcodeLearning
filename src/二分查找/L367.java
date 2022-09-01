package 二分查找;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L367.java
 * @Description TODO
 * @createTime 2022年01月11日 21:14:00
 */


class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        int left = 1;
        int right = num;
        while( left  <= right){
            int middle = left + ((right - left)>>1);  //防止溢出
            if(num/middle < middle){  //防止溢出
                right = middle - 1;
            }else if(num/middle > middle){
                left = middle + 1;
            }else {
                if(middle * middle == num)
                    return true;
                else
                    return false;
            }
        }
        return false;
    }
}

public class L367 {
    public static void main(String[] args) {
        Solution s = new Solution();
        boolean flag = s.isPerfectSquare(5);
    }
}
