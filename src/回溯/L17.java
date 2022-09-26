package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L17.java
 * @Description TODO
 * @createTime 2022年09月19日 19:01:00
 */
public class L17 {
}
class Solution17 {
    private String []letterMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private StringBuilder path = new StringBuilder();
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return ans;
        }
        backTracking(digits,0);
        return ans;

    }

    public void backTracking(String digits,int index){
        if(index == digits.length()){
            ans.add(path.toString());
            return;
        }

        String str = letterMap[digits.charAt(index) - '0'];
        for(int i = 0;i<str.length();i++){
            path.append(str.charAt(i));
            backTracking(digits,index + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}