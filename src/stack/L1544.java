package stack;

import java.util.Stack;

public class L1544{
    public static void main(String[] args) {
        Solution1544 s = new Solution1544();
        s.makeGood("abBAcC");
    }
}

class Solution1544 {
        public String makeGood(String s) {
            if(s.isEmpty()||s.length() ==1)
                return s;
            Stack<Character> stack = new Stack<>();
            char []arr = s.toCharArray();
            stack.push(arr[0]);
            for(int i = 1;i< s.length();i++){
                if(!stack.isEmpty()&&(Math.abs(arr[i]-stack.peek().charValue()) == 32))
                    stack.pop();
                else
                    stack.push(arr[i]);
            }
            int k = stack.size();
            int j = k-1;
            int i;
            for(i = 0;i<k;i++){
                arr[j--] = stack.pop();
            }
            return  String.valueOf(arr,0,i);
        }
    }

