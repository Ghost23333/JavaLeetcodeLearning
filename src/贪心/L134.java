package 贪心;

import org.ietf.jgss.GSSContext;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L134.java
 * @Description TODO
 * @createTime 2022年09月29日 21:49:00
 */
public class L134 {
    public static void main(String[] args) {
        L134 l = new L134();
        l.canCompleteCircuit134_2(new int[]{2,3,4},new int[]{3,4,3});
    }
    public int canCompleteCircuit134(int[] gas, int[] cost) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i < gas.length; i++) {
            if(gas[i] > cost[i]){
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            int j = list.get(i);
            boolean flag = true;
            for(;j<gas.length;j++){
                sum += gas[j] - cost[j];
                if(sum < 0){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                continue;
            }
            for(int k = 0;k<j;k++){
                sum += gas[k] - cost[k];
                if(sum < 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return list.get(i);
            }
        }
        return -1;
    }

    public int canCompleteCircuit134_2(int[] gas, int[] cost){
        int curRest = 0;
        int totalRest = 0;
        int ans = 0;
        for (int i = 0; i < gas.length; i++) {
            curRest += gas[i] - cost[i];
            totalRest += gas[i] - cost[i];
            if(curRest <0){
                ans = i + 1;
                curRest = 0;
            }
        }
        if(totalRest < 0 )
            return -1;
        return ans;
    }
}
