package 回溯;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName beibao.java
 * @createTime 2023年02月03日 16:28:00
 */
public class beibao {
    private static int finalValue = 0;
    private static int[]value;
    private static int[]weight;
    private static int bagWeight;

    public static void main(String[] args) {
        weight = new int[]{2, 2, 6, 5, 4};
        value = new int[]{6,3,5,4,6};
        bagWeight = 10;
        backTracking(0,0,0);
        System.out.println(finalValue);

    }
    public static void backTracking(int startIndex, int curValue, int curWeight){
        if(curWeight >= bagWeight)
            return;
        for(int i = startIndex;i<weight.length;i++){
            if(curWeight + weight[i] < bagWeight){
                finalValue = Math.max(finalValue,curValue + value[i]);
                backTracking(startIndex + 1, curValue + value[i],curWeight + weight[i]);
            }
        }
    }
}
