package DP;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName beibao.java
 * @Description TODO
 * @createTime 2022年10月20日 16:38:00
 */
public class beibao {
    public static void main(String[] args) {
        int[] weight = {2, 2, 6, 5, 4};
        int[] value = {6,3,5,4,6};
        int bagWight = 10;
        testWeightBagProblem(weight, value, bagWight);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印结果
        System.out.println(dp[dp.length - 1]);

    }
}
