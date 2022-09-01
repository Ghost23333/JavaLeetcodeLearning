package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 有效的字母异位词.java
 * @Description TODO
 * @createTime 2022年04月12日 16:54:00
 */
public class 有效的字母异位词 {
}
class Solution242 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
       int []chars = new int[26];
       char []ss = s.toCharArray();
       char []tt = t.toCharArray();
        for (char c : ss) {
            chars[c-'a']++;
        }
        for (char c : tt) {
            chars[c-'a']--;
            if(chars[c-'a'] < 0){
                return false;
            }
        }
        for (int aChar : chars) {
            if(aChar != 0)
                return false;
        }
        return true;

    }
}