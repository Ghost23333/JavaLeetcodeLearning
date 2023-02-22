package 每日一题;

import java.awt.event.KeyAdapter;
import java.util.*;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1807.java
 * @Description TODO
 * @createTime 2023年01月12日 13:50:00
 */
public class L1807 {
    public static void main(String[] args) {

    }
}
class Solution1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> words = new HashMap<>();
        for (List<String> strings : knowledge) {
            words.put(strings.get(0),strings.get(1));
        }
        String[] split = s.split("\\(");
        StringBuffer ans = new StringBuffer();
        for (String s1 : split) {
            if(s1.contains(")")){
                String[] split1 = s1.split("\\)");
                if(words.containsKey(split1[0])){
                    split1[0] = words.get(split1[0]);
                }else {
                    split1[0] = "?";
                }
                s1 = "";
                for (String s2 : split1) {
                    s1 += s2;
                }
            }
            ans.append(s1);
        }
        return String.valueOf(ans);
    }
}
