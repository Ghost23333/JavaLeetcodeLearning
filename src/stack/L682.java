package stack;

public class L682 {
}
class Solution682 {
    public int calPoints(String[] ops) {
        int stack[] = new int[ops.length + 2];
        int top = 1;
        int count = 0;
        for(int i = 0;i<ops.length;i++){
            if(ops[i].equals("+"))
            {
                int temp = stack[top] + stack[top-1];
                count+=temp;
                stack[++top] = temp;
            } else if(ops[i].equals("D")){
                int temp = stack[top]*2;
                count+=temp;
                stack[++top] = temp;
            } else if(ops[i].equals(("C"))){
                count -= stack[top--];
            }else{
                stack[++top] = Integer.valueOf(ops[i]);
                count += stack[top];
            }

        }
        return count;
    }
}