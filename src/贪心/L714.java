package 贪心;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L714.java
 * @Description TODO
 * @createTime 2022年10月06日 13:26:00
 */
public class L714 {
    public static void main(String[] args) {
        new Solution714().maxProfit(new int[]{1,3,7,5,10,3},3);
    }
}
class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 1)
            return 0;
        int buy = prices[0];
        int profits = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - buy - fee > 0){
                profits += prices[i] - buy - fee;
                buy = prices[i] - fee;
            }else if(prices[i] < buy){
                buy = prices[i];
            }
        }
        return profits;
    }
}