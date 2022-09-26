package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L77.java
 * @Description TODO
 * @createTime 2022年09月19日 10:04:00
 */
public class L77 {
    public static void main(String[] args) {
        Solution77 s = new Solution77();
        List<List<Integer>> ans = s.combine(4,2);
        System.out.println(ans);
    }

}
class Solution77 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return ans;
    }
    public void backTracking(int n,int k,int startIndex){
        if(cur.size() == k){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = startIndex;i <= n - (k - cur.size()) + 1;i++){
            cur.add(i);
            backTracking(n,k,i + 1);
            cur.remove(cur.size()-1);
        }
    }
}