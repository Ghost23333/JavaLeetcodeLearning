package stack;

import java.io.ObjectInputStream;
import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L316.java
 * @Description TODO
 * @createTime 2020年10月16日 11:26:00
 */
public class L316 {
    public static void main(String[] args) {
        Solution316 s = new Solution316();
        s.removeDuplicateLetters("cbacdcbc");
    }
}
/*
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        TreeSet<Character> treeSet = new TreeSet<>();
        char []ans = new char[chars.length];
        for (char c : chars) {
            if (!treeSet.contains(c)) {
                treeSet.add(c);
            }
        }
        Object[] arr = treeSet.toArray();
        int i;
        for(i = 0;i<arr.length;i++){
            ans[i] = (char)arr[i];
        }
        return String.valueOf(ans,0,i);
    }
}*/

class Solution316 {
    public  String  removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        HashMap<Character,Integer> lastShow = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();

        for(int i=0;i<s.length();i++)
            lastShow.put(s.charAt(i),i);

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!seen.contains(ch)){
                while(!stack.isEmpty() && ch < stack.peek()&& i < lastShow.get(stack.peek())){
                    seen.remove(stack.pop());
                }
                seen.add(ch);
                stack.push(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty())
            ans.append(stack.removeLast());
        return ans.toString();

    }
}
