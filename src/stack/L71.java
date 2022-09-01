package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chenhong
 * @version 1.0.0
 * @ClassName L71.java
 * @Description TODO
 * @createTime 2020年10月19日 11:05:00
 */
public class L71 {
    public static void main(String[] args) {
        //System.out.println(ans);
    }
}
//class Solution71 {
//    public String simplifyPath(String path) {
//        if(path.equals(""))
//            return path;
//        Deque<Character> stack = new ArrayDeque<>();
//        for(int i =0;i<path.length();i++){
//            char c = path.charAt(i);
//            if(!stack.isEmpty()){
//                if(stack.peek() == '/'){
//                    if(c == '/')
//                        continue;
//                    else
//                        stack.push(c);
//                }
//                else if(stack.peek() == '.'){
//                    if(c == '.'){
//                        if(stack.size() == 2)
//                            stack.pop();
//                        else{
//                            stack.pop();
//                            stack.pop();
//                            while(stack.peek()!='/'){
//                                stack.pop();
//                            }
//                        }
//                    }
//                    else if(c == '/'){
//                        stack.pop();
//                    }
//                    else
//                        stack.push(c);
//                }
//                else
//                    stack.push(c);
//            }else {
//                stack.push(c);
//            }
//        }
//        StringBuilder ans = new StringBuilder();
//        if(stack.peek() == '.')
//            stack.pop();
//        if(stack.getLast()!='/')
//            ans.append('/');
//        if(stack.size()!=1&&stack.peek() == '/')
//            stack.pop();
//        while(!stack.isEmpty())
//            ans.append(stack.removeLast());
//        return ans.toString();
//    }
//}



