package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1790.java
 * @Description TODO
 * @createTime 2022年10月11日 09:25:00
 */
public class L1790 {
}

class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() == 1)
            return s1.equals(s2);
        int count = 0;//代表目前不相等的字母数量
        int [][]chars = new int[2][2];
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                if(count == 2){
                    return false;
                }
                chars[count][0] = s1.charAt(i);
                chars[count][1] = s2.charAt(i);
                count++;
            }
        }
        return count == 0 ||count == 2 && chars[0][0] == chars[1][1] && chars[0][1] == chars[1][0];

    }
}