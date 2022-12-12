package 每日一题;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L808.java
 * @Description TODO
 * @createTime 2022年11月21日 09:11:00
 */
public class L808 {
    public static void main(String[] args) {
        new Solution888().soupServings(50);

    }
}

class Solution888 {
    public double soupServings(int n) {
        int[][] soup = new int[][]{{100, 0}, {75, 25}, {50, 50}, {25, 75}};
        double f = 0.0;
        for (int i = 0; i < 4; i++) {
            if(soup[i][0] <= n){
                if(soup[i][1] <= n)
                    f += 0.125;
                else if(soup[i][1] >n )
                    f += 0.25;
            }
        }
        return f;
    }
}