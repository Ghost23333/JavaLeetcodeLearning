package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L940.java
 * @Description TODO
 * @createTime 2022年10月14日 09:48:00
 */
public class L940 {
    public static void main(String[] args) {
        String str = "pcrdhwdxmqdznbenhwjsenjhvulyve";
        int ans = new Solution940().distinctSubseqII(str);
        System.out.println(ans);

    }
}
class Solution940 {
    Long ans = 0L;
    public int distinctSubseqII(String s) {
        backTracking(s,0,new boolean[26]);
        return (int) (ans % (1e9 + 7));

    }

    //回溯法  会超时 很憨批的解法捏
    public void backTracking(String s, int startIndex, boolean []used){
        if(startIndex >= s.length())
            return;
        Arrays.fill(used,false);//重置used数组
        for(int i = startIndex;i<s.length();i++){
            if(!used[s.charAt(i)-'a']){
                ans++;
                used[s.charAt(i)-'a'] = true;
                backTracking(s,i + 1,new boolean[26]);
            }
        }
    }
}
//DP yyds
class Solution940_2 {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        //之前新增的个数
        int[] preCount = new int[26];
        int curAns = 1;
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            //新增的个数
            int newCount = curAns;
            //当前序列的个数 = 之前的 + 新增的 - 重复的
            curAns = ((curAns + newCount) % mod - preCount[chs[i] - 'a'] % mod + mod) % mod;
            //记录当前字符的 新增值, 下次碰到相同字符时ch时 ，ch仍会加在现在这个字符加过的后面，所以会造成重复，必须减掉
            preCount[chs[i] - 'a'] = newCount;
        }
        //减去空串
        return curAns - 1;
    }
}