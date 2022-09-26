package 回溯;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L93.java
 * @Description TODO
 * @createTime 2022年09月23日 09:55:00
 */
public class L93 {
    public static void main(String[] args) {
        Solution93 s = new Solution93();
        s.restoreIpAddresses("101023");
    }
}

class Solution93 {
    List<String> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return ans;
        }
        for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)<'0' || s.charAt(i) > '5'){
                    return ans;
                }
        }
        backTracking(s,0);
        return ans;



    }

    public void backTracking(String s, int startIndex) {
        if(path.size() > 4){
            return;
        }
        if (startIndex >= s.length()) {
            if (path.size() == 4) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    stringBuilder.append(path.get(i));
                    stringBuilder.append(".");
                }
                stringBuilder.append(path.get(3));
                ans.add(stringBuilder.toString());
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if(isIpAddress(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
                backTracking(s,i  + 1);
                path.removeLast();
            }

        }
    }

    public boolean isIpAddress(String s,int start, int end) {
        int length = end - start+ 1;
        if (length > 3) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        if (s.charAt(start) == '0') {
            return false;
        }
        int num = Integer.parseInt(s.substring(start, end + 1));
        if (num >= 0 && num <= 255) {
            return true;
        }
        return false;
    }
}