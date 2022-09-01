package 二分查找;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L69.java
 * @Description TODO
 * @createTime 2022年01月11日 20:41:00
 */
public class L69 {
    class Solution {
        public int mySqrt(int x) {
            if(x == 0)
                return 0;
            if(x <= 3)
                return 1;
            int left = 1;
            int right = x/2;
            while( left  <= right){
                int middle = left + ((right - left)>>1);  //防止溢出
                if(x/middle < middle){  //防止溢出
                    right = middle - 1;
                }else if(x/middle > middle){
                    left = middle + 1;
                }else {
                    return middle;
                }
            }
            return left - 1;

        }
    }
}
