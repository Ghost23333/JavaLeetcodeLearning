package DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L139.java
 * @Description TODO
 * @createTime 2022年11月10日 15:57:00
 */
public class L139 {
}
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}