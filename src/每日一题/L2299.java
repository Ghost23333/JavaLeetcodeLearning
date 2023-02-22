package 每日一题;

import java.util.HashSet;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L2299.java
 * @Description TODO
 * @createTime 2023年01月19日 21:56:00
 */
public class L2299 {
}

class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8)
            return false;
        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
        char[] chars = "!@#$%^&*()-+".toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        char pre = ' ';
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch))
                flag1 = true;
            if (Character.isUpperCase(ch))
                flag2 = true;
            if (Character.isDigit(ch))
                flag3 = true;
            if (set.contains(ch))
                flag4 = true;
            if (pre == ch)
                return false;
            pre = ch;
        }
        return flag1 && flag2 && flag3 && flag4;
    }
}