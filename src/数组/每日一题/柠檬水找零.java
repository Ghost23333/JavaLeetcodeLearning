package 数组.每日一题;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName 柠檬水找零.java
 * @Description TODO
 * @createTime 2020年12月10日 10:01:00
 */
public class 柠檬水找零 {
    public static void main(String[] args) {
        Solution860 s = new Solution860();
        boolean flag = s.lemonadeChange(new int []{5,5,5,20,5,5,5,20,5,5,5,10,5,20,10,20,10,20,5,5});
        System.out.println(flag);
    }


}

class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0)
            return true;
        if(bills[0] != 5)
            return false;
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(bills[0]);
        for(int i = 1;i< bills.length;i++){
            if(bills[i] == 10){
                if(!deque.isEmpty() && deque.removeFirst()== 5){
                   deque.offerLast(10);
                }else {
                    return false;
                }
            }
            else if(bills[i] == 20){
                if(deque.size() < 2)
                    return false;
                else if(deque.size()== 2 &&(deque.removeLast()!=10 || deque.removeFirst() != 5)){
                    return false;
                }else if(deque.size() > 2) {
                    if (deque.getLast() == 10 && deque.getFirst() == 5) {
                        deque.removeFirst();deque.removeLast();
                    }else if(!(deque.removeFirst()== 5 && deque.removeFirst() == 5 && deque.removeFirst() == 5))
                        return false;
                }

            }
            else {
                deque.offerFirst(5);
            }
        }
        return true;

    }
}
class Solution860_2 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
