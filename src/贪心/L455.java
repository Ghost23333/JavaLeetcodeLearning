package 贪心;

import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L455.java
 * @Description TODO
 * @createTime 2022年09月26日 15:05:00
 */
public class L455 {
}
class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;
        for(int i =0,j=0;i<g.length && j<s.length;){
            if(s[j] >= g[i]){
                count++;
                j++;
                i++;
            }else {
                j++;
            }
        }
        return count;
    }
}