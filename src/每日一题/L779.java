package 每日一题;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L779.java
 * @Description TODO
 * @createTime 2022年10月20日 14:09:00
 */
public class L779 {
    public static void main(String[] args) {
        new Solution779().kthGrammar(10, 78);
    }

}

class Solution779 {
    public int kthGrammar(int n, int k) {
        if (k == 1 || k == 2)
            return k - 1;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(k);
        while (k != 1 && k != 2) {
            k = (k + 1) / 2;   //找到k的父节点,也就是谁生成了k
            path.add(k);
        }
        String strs[] = {"01", "10"};
        String start = strs[0];
        int index = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            int cur = path.get(i);
            if (cur % 2 == 0) {
                index = Integer.parseInt(String.valueOf(start.charAt(1)));
                start = strs[index];
            } else {
                index = Integer.parseInt(String.valueOf(start.charAt(0)));
                start = strs[index];
            }
        }
        return index;
    }
}
