package 每日一题;

import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L773.java
 * @Description TODO
 * @createTime 2022年10月29日 15:15:00
 */
public class L1773 {
}
class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int key = 2;
        if("type".equals(ruleKey))
            key = 0;
        else if("color".equals(ruleKey))
            key = 1;
        int ans = 0;
        for (List<String> item : items) {
            if(item.get(key).equals(ruleValue))
                ans++;
        }
        return ans;
    }
}