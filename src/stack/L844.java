package stack;

import java.util.Stack;

public class L844 {
    public static void main(String[] args) {
        Solution844 s = new Solution844();
        s.backspaceCompare("y#fo##f","y#f#o##f");
    }
}
class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        return compare(S).equals(compare(T));

    }
    private String compare(String S){
        char[]arr = new char[S.length()];
        int top = -1;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '#')
            {
                if(top != -1)
                    --top;
            }
            else
                arr[++top] = S.charAt(i);
        }
        return String.valueOf(arr,0,top+1);

    }
}