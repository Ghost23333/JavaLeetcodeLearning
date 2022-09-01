/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 跳水板.java
 * @Description TODO
 * @createTime 2020年12月20日 21:49:00
 */
public class 跳水板 {
}


class Solution_tsb {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0)
            return new int[]{};
        if(shorter == longer){
            return new int[]{ shorter * k};
        }
        int []ans = new int[k + 1];
        for(int i = 0;i <= k; i++){
            ans[i] = shorter*(k-i)+longer*i;
        }
        return ans;

    }
}