package sort;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 有效的字母异位词.java
 * @Description TODO
 * @createTime 2020年12月06日 21:54:00
 */
public class 有效的字母异位词 {
}


class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = s.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}