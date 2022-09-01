package 数组.每日一题;

import java.util.HashMap;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L454.java
 * @Description TODO
 * @createTime 2020年11月27日 20:23:00
 */
public class L454 {
}

class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> countAB = new HashMap<>();

        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;

    }
}
