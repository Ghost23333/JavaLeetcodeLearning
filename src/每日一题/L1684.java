package 每日一题;

import java.util.HashMap;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1684.java
 * @Description TODO
 * @createTime 2022年11月08日 08:45:00
 */
public class L1684 {
    public static void main(String[] args) {
        new Solution1684().countConsistentStrings("ab",new String[]{"ad","bd","aaab","baa","badab"});
    }
}

class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] map = new int[26];
        for (int i = 0; i < allowed.length(); i++) {
            map[allowed.charAt(i) - 'a'] = 1;
        }
        int ans = 0;
        for (String word : words) {
            int i = 0;
            for (; i < word.length(); i++) {
                if (map[word.charAt(i) - 'a'] == 0) {
                    break;
                }
            }
            if (i == word.length()) {
                ans++;
            }
        }
        return ans;
    }
}