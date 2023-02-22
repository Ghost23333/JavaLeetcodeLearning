package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L2011.java
 * @Description TODO
 * @createTime 2022年12月23日 14:34:00
 */
public class L2011 {
}

class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int res = 0;
        for (String operation : operations) {
            if (operation.charAt(0) == '+' || operation.charAt(1) == '+' || operation.charAt(2) == '+')
                res++;
            else
                res--;
        }
        return res;
    }
}