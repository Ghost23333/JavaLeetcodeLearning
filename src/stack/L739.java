package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L739.java
 * @Description 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100]范围内的整数。
 * @createTime 2020年10月10日 10:58:00
 */
public class L739 {
    public static void main(String[] args) {
        Solution739 s = new Solution739();
        int []a = {55,38,53,81,61,93,97,32,43,78};
        s.dailyTemperatures(a);
    }
}
class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int []stack = new int[T.length + 2];
        if(T.length == 0)
            return stack;
        stack[0] = T[0];
        int top = 0;
        for(int i = 1;i<T.length;i++){
            if(T[i] > stack[top]) {
                T[top] = i - top;
                top++;
                stack[top] = T[top];
                T[top] = 0;
                i = top;
            }
            else if(i == T.length - 1){
                 top++;
                 stack[top] = T[top];
                 T[top] = 0;
                 i = top;
            }
        }
        T[T.length-1] = 0;
        return T;
    }
}
//单调栈
class Solution739_2{
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int ans[] = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++){
            while(!stack.isEmpty()&&T[i] > T[stack.peek()]){
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        System.gc();
        return ans;
    }
}