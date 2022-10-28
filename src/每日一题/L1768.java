package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1768.java
 * @Description TODO
 * @createTime 2022年10月23日 09:19:00
 */
public class L1768 {
}

class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuffer ans = new StringBuffer();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if(i<word1.length())
                ans.append(word1.charAt(i++));
            if(j<word2.length())
            ans.append(word2.charAt(j++));
        }
        return ans.toString();
    }
}