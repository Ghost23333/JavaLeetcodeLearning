package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L84.java
 * @Description TODO
 * @createTime 2020年10月11日 20:06:00
 */
public class L84 {
}

//单调栈  wrong
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0)
            return 0;
        if(len == 1)
           return heights[0];
        int left_boundary = 0; //左边界
        int left_min = heights[0];
        int pre = -1;
        int ans = 0;
        for(int i = 0;i<len;i++){
            if(heights[i] == 0){
                pre = -1;
                left_boundary = i+1;
            }
            else{
                if(pre != -1){
                    left_min = Math.min(left_min,heights[i]);
                    int neighboring_rect = Math.min(pre,heights[i]) * 2;
                    int long_rect = (i - left_boundary + 1) * left_min;
                    ans = max(ans,neighboring_rect,long_rect);
                    pre = heights[i];
                }
                else{
                    pre = heights[i];
                    ans = pre;
                    left_min = pre;

                }
            }
        }
        return ans;
    }
    private int max(int a,int b, int c){
        if(a >= b){
            if(a >= c)
                return a;
            else
                return c;
        }
        if(b > c)
            return b;
        return c;
    }
}

//单调栈
//找出柱子左边最接近该柱子且小于该柱子的下标i(如果未找出，则下标为-1，表示该柱子左边所有柱子都大于等于该柱子)
// 找出该柱子右边最接近且小于该柱子的下标j（如果未找到则为 len）该柱子能围成的最大矩形面积为 (j-1-1)*该柱子的高
class Solution{
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int []left = new int[len];
        int []right = new int[len];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i =0;i<len;i++){
            while(!stack.isEmpty()&&heights[stack.peek()]>= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty()? -1: stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i = len-1;i>=0;i--){
            while(!stack.isEmpty()&&heights[stack.peek()]>=heights[i])
                stack.pop();
            right[i] = stack.isEmpty()?len:stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for(int i =0;i<len;i++){
            ans = Math.max(ans,(right[i]-left[i] - 1)*heights[i]);
        }
        return ans;
    }
}