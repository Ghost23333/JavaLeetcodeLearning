package 每日一题;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1441.java
 * @Description TODO
 * @createTime 2022年10月15日 09:36:00
 */
public class L1441 {
}
class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1, j=0; i <= n && j< target.length ; i++) {
            ans.add("Push");
            if(i != target[j]){
                ans.add("Pop");
            }else {
                j++;
            }

        }
        return ans;
    }
}