package 贪心;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L860.java
 * @Description TODO
 * @createTime 2022年10月03日 20:04:00
 */
public class L860 {
    public static void main(String[] args) {
        Solution860 s = new Solution860();
        s.lemonadeChange(new int[]{5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5});
    }
}

class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int numOf5 = 0, numOf10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                numOf5++;
            else if (bills[i] == 10) {
                numOf10++;
                if (--numOf5 < 0) {
                    return false;
                }
            } else if (bills[i] == 20) {
                if(numOf5 >= 1 && numOf10 >= 1){
                    numOf5--;
                    numOf10--;
                }else if(numOf5 >= 3){
                    numOf5 -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}