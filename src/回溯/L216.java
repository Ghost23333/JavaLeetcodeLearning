package 回溯;

import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L216.java
 * @Description TODO
 * @createTime 2022年09月19日 10:55:00
 */
public class L216 {
}
class Solution216 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> cur = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k,n,1,0);
        return ans;
    }

    public void backTracking(int k, int n,int startIndex,int curValue){
        if(curValue > n){
            return;
        }
        if(cur.size() == k){
            if(curValue == n){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for(int i =startIndex;i<= 9 - (k - cur.size()) + 1;i++){
            cur.add(i);
            backTracking(k,n,i+1,curValue + i);
            cur.removeLast();
        }
    }
}