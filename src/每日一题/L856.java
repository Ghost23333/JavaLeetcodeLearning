package 每日一题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L856.java
 * @Description TODO
 * @createTime 2022年10月09日 09:44:00
 */
public class L856 {
    public static void main(String[] args) {
        new Solution856().scoreOfParentheses("(()()(()))");
    }
}

class Solution856 {
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<Integer>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }
        return st.peek();
    }
}