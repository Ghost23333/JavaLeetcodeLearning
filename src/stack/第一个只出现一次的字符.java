package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 第一个只出现一次的字符.java
 * @Description TODO
 * @createTime 2020年12月05日 17:40:00
 */
public class 第一个只出现一次的字符 {
}
class Solution50 {
    public char firstUniqChar(String s) {

        Deque<Character> deque = new LinkedList<>();
        int []chars = new int[26];
        for(char c : s.toCharArray()){
            if(chars[c - 97]  > 0){
                deque.remove(c);
            }else {
                deque.offerLast(c);
                chars[c - 97] = 1;
            }
        }
        if(deque.isEmpty())
            return ' ';
        return deque.getFirst();

    }
}