package 回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L131.java
 * @Description TODO
 * @createTime 2022年09月22日 09:36:00
 */
public class L131 {
}
class Solution131 {

    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return ans;
    }
    public void backTracking(String s,int startIndex){

        if(startIndex >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        int begin = startIndex;
        for(int i =startIndex;i<s.length();i++){
            String temp = s.substring(begin, i);
            if(isPalindrome(temp)){
                path.add(temp);
                backTracking(s,startIndex + 1);
                path.removeLast();
            }
        }
    }

    //判断字符串是否为回文串
    public boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        for(;i<s.length()/2;i++){
            stack.push(s.charAt(i));
        }
        if(s.length() % 2 == 1){
            i ++;
        }
        for(;i<s.length();i++){
            if(s.charAt(i) != stack.pop()){
                return false;
            }
        }
        return true;
    }

    //回溯法
    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition2(String s) {
        backTracking2(s,0);
        return ans;
    }
    public void backTracking2(String s,int startIndex){
        if(startIndex >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex;i<s.length();i++){
            if(isPalindrome2(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
                backTracking2(s,i+1);
                path.removeLast();
            }
        }
    }

    public boolean isPalindrome2(String s,int start,int end){
        for(int i =start,j = end;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}