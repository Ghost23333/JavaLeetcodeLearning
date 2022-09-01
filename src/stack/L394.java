package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L394.java
 * @Description TODO
 * @createTime 2020年10月14日 20:11:00
 */
public class L394 {
}

//一个栈存储数字，一个栈存储字符串
class Solution394 {
    public String decodeString(String s) {
        StringBuffer ans = new StringBuffer();
        Deque<Integer> multiStack = new ArrayDeque<>();
        Deque<StringBuffer> ansStack = new ArrayDeque<>();
        int multi = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c))
                multi = multi*10 + c-'0';
            else if(c == '['){
                ansStack.push(ans);
                multiStack.push(multi);
                ans = new StringBuffer();
                multi = 0;
            }else if(Character.isAlphabetic(c)){
                ans.append(c);
            }else {
                StringBuffer tempAns = ansStack.pop();
                int tempMulti = multiStack.pop();
                for(int i =0;i<tempMulti;i++)
                    tempAns.append(ans);
                ans = tempAns;
            }
        }
        return ans.toString();

    }
}