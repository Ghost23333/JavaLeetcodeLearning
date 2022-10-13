package 贪心;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L122.java
 * @Description TODO
 * @createTime 2022年09月28日 11:49:00
 */
public class L122 {
}
class Solution122 {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > buy){
                ans += prices[i] - buy;
                buy = prices[i];
            }else if(prices[i] < buy){
                buy = prices[i];
            }
        }
        return ans;
    }
}