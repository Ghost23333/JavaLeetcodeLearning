package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1668.java
 * @Description TODO
 * @createTime 2022年11月03日 09:32:00
 */
public class L1668 {
}

class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        if (sequence.length() < word.length())
            return 0;
        int ans = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == word.charAt(0)) {
                int j = 1;
                i++;
                while (i < sequence.length()) {
                    if(j >= word.length()){
                        j = 0;
                        count++;
                    }
                    if(sequence.charAt(i) == word.charAt(j)){
                        i++;
                        j++;
                    }else {
                        i--;
                        break;
                    }
                }
                ans = Math.max(ans,count);
                count = 0;
            }
        }
        return ans;
    }
}