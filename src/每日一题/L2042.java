package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L2042.java
 * @Description TODO
 * @createTime 2023年01月05日 20:19:00
 */
public class L2042 {
}
class Solution2042 {
    public boolean areNumbersAscending(String s) {
        String[] strings = s.split(" ");
        int pre = 0;
        for (String string : strings) {
            if(Character.isDigit(string.charAt(0))){
                Integer cur = Integer.valueOf(string);
                if(cur > pre){
                    pre = cur;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}