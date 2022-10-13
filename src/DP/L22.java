package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L22.java
 * @Description TODO
 * @createTime 2022年10月13日 17:11:00
 */
public class L22 {
}
class Solution22 {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        char []chars = new char[2 * n];
        Arrays.fill(chars,'(');
        backTracking(chars,0,0,n);
        return ans;
    }

    public void backTracking(char []chars,int left,int right,int n){
        if(left > n || right > n)
            return;
        if(left == n && right == n){
            ans.add(new String(chars));
            return;
        }
        backTracking(chars,left + 1,right,n);
        if(left > right){
            chars[left + right] = ')';
            backTracking(chars,left,right+1,n );
            chars[left + right] = '('; //回溯
        }
    }
}