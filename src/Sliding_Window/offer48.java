package Sliding_Window;

import java.util.HashMap;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName offer48.java
 * @Description TODO
 * @createTime 2020年12月03日 10:11:00
 */
public class offer48 {
    public static void main(String[] args) {
        String str = "abcabcbb";
        Solution48 s = new Solution48();
        s.lengthOfLongestSubstring(str);
    }
}


class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2)
            return s.length();
        char []chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int cur = 0;
        int left_index = 0;
        for(int i =0;i<s.length();i++){
            if(map.containsKey(chars[i])){
                int j = map.get(chars[i]);
                ans = Math.max(ans,cur);
                cur -= j - left_index;
                for(int k = left_index;k < j;k++ ){
                    map.remove(chars[k]);
                }
                left_index = j + 1;
                map.put(chars[i],i);
            }else{
                map.put(chars[i],i);
                cur ++;
            }
        }
        return Math.max(ans,cur);
    }
}