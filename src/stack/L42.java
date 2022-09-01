package stack;

import java.util.Map;
import java.util.Stack;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L42.java
 * @Description TODO
 * @createTime 2020年10月11日 16:34:00
 */
public class L42 {
}

//单调栈（单调递减）
class Solution42 {
    public int trap(int[] height) {
        if(height.length<3)
            return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i<height.length){
            //栈不为空且当前柱子高度大于栈顶柱子高度
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty())
                    break;
                int distance = i - stack.peek() -1;
                int rain_height = Math.min(height[stack.peek()],height[i]) - height[top];
                ans += distance*rain_height;
            }
            stack.push(i++);
        }
        return ans;
    }
}


//动态规划

class Solution42_2{
    public int trap(int[] height) {
        if(height.length<3)
            return 0;
        int ans = 0;
        int len =height.length;
        int []left_max = new int[len];
        int []right_max = new int[len];
        left_max[0] = height[0];
        for(int i = 1;i<len;i++){
            left_max[i] = Math.max(height[i],left_max[i-1]);
        }
        right_max[len-1] = height[len-1];
        for(int i=len - 2;i>=0;i--){
            right_max[i] = Math.max(height[i],right_max[i+1]);
        }
        for(int i =1;i<len - 1;i++){
            ans += Math.min(left_max[i],right_max[i]) - height[i];
        }
        return ans;
    }
}


//双指针
class Solution42_3{
    public int trap(int[] height) {
        int left = 0,right = height.length-1;
        int ans =0;
        int left_max = 0,right_max = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= left_max){
                    left_max = height[left];
                }
                else{
                    ans += left_max- height[left];
                }
                left++;
            }
            else{
                if(height[right] >= right_max){
                    right_max = height[right];
                }else{
                    ans += right_max-height[right];
                }
                right--;
            }
        }
        return ans;
    }
}