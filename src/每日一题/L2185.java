package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L2185.java
 * @Description TODO
 * @createTime 2023年01月08日 14:45:00
 */
public class L2185 {
}
class Solution2185 {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if(word.length() >= pref.length()){
                int i = 0;
                for(;i<pref.length();i++){
                    if(word.charAt(i) != pref.charAt(i)){
                        break;
                    }
                }
                if(i == pref.length()){
                    count ++;
                }

            }
        }
        return count;
    }
    public int prefixCount2(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if(word.startsWith(pref))
                count++;
        }
        return count;
    }
}