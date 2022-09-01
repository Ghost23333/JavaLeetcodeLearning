package 数组.每日一题;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L976.java
 * @Description TODO
 * @createTime 2020年11月29日 10:30:00
 */
public class L976 {
    public static void main(String[] args) {
        Solution976 s = new Solution976();
        s.largestPerimeter(new int []{1,2,1});
    }
}

class Solution976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int a = 0,b = 0,c = 0;
        for(int i = A.length - 1;i >= 2;i--){
            a = A[i];
            for(int j = i - 1; j>= 1; j--){
                b = A[j];
                for(int k = j - 1; k>= 0; k--){
                    c = A[k];
                    if(b + c <= a )
                        break;
                    else
                        return a + b + c;
                }
                if(b + c <= a)
                    break;
            }
        }
        return 0;
    }
}



