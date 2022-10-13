package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L763.java
 * @Description TODO
 * @createTime 2022年10月05日 10:57:00
 */
public class L763 {
    public static void main(String[] args) {
        Solution763 s = new Solution763();
        s.partitionLabels("eaaaabaaec");
    }
}

class Solution763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] numOfLastShow = new int[26];
        Arrays.fill(numOfLastShow, -1);
        for (int i = 0; i < s.length(); i++) {
            numOfLastShow[s.charAt(i) - 'a'] = i;
        }
        int curMaxIndex = numOfLastShow[s.charAt(0) -'a'];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count++;
            int num = numOfLastShow[s.charAt(i) - 'a'];
            if(i == curMaxIndex){
                ans.add(count);
                count = 0;
                if(i < s.length() - 1){
                    curMaxIndex = numOfLastShow[s.charAt(i + 1) - 'a'];
                }
            }else if(num >curMaxIndex){
                curMaxIndex = num;
            }
        }
        return ans;
    }
}