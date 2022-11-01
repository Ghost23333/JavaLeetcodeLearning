package 每日一题;

import javax.print.CancelablePrintJob;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L784.java
 * @Description TODO
 * @createTime 2022年10月30日 09:28:00
 */
public class L784 {
    public static void main(String[] args) {
        new Solution784().letterCasePermutation("a1b2");
    }
}

class Solution784 {
    List<String> ans = new ArrayList<>();
    StringBuffer path = new StringBuffer();
    public List<String> letterCasePermutation(String s) {
        backTracing(s,0);
        return ans;
    }

    public void backTracing(String s, int startIndex) {
        if (startIndex >= s.length()) {
            ans.add(new String(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            char ch = s.charAt(i);
            //小写
            if (ch >= 'a' && ch <= 'z') {
                path.append(Character.toUpperCase(ch));
                backTracing(s, i + 1);
                path.delete(i,path.length());  //删掉从i开始的值
            } else if (ch >= 'A' && ch <= 'Z'){
                path.append(Character.toLowerCase(ch));
                backTracing(s, i + 1);
                path.delete(i,path.length());  //删掉从i开始的值
            }
            path.append(ch);
        }
        ans.add(new String(path));
    }
}
