package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L150.java
 * @Description TODO
 * @createTime 2020年10月15日 09:21:00
 */
public class L150 {
    public static void main(String[] args) {
        Solution150 s = new Solution150();
        s.evalRPN(new String[]{"2","1","+","3","*"});
    }
}
class Solution150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0;i< tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());
                int temp = 0;
                if(tokens[i].equals("+"))
                    temp = a + b;
                else if(tokens[i].equals("-"))
                    temp = a - b;
                else if(tokens[i].equals("*"))
                    temp = a * b;
                else
                    temp = a / b;
                stack.push(temp);
            }else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }
}