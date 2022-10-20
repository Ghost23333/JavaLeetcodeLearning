package 每日一题;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L1700.java
 * @Description TODO
 * @createTime 2022年10月19日 15:17:00
 */
public class L1700 {
}
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int student : students) {
            deque.add(student);
        }
        for (int sandwich : sandwiches) {
            int len = deque.size();
            int i = 0;
            for (; i < len; i++) {
                int temp = deque.removeFirst(); //用temp保存当前队列头的学生喜好
                if(temp == sandwich){
                    //若当前学生可以吃这个三明治，则继续循环三明治数组
                    break;
                }else {
                    //否则将这么学生加入队列尾部
                    deque.offerLast(temp);
                }
            }
            //如果当前队列中所有学生都不喜欢这个三明治，则放回结果
            if(i == len){
                return len;
            }
        }
    return 0;
    }
}