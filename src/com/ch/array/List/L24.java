package com.ch.array.List;

public class L24 {
}
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode n1 =head,n2 = head.next,cur = head;
        while(true){
            n1.next = n2.next;   //交换
            n2.next = n1;
            if(n1 == head)       //处理头节点问题
                head = n2;
            else
                cur.next = n2;   //处理前一个节点连接问题
            cur = n1;
            n1 = n1.next;
            if(n1 == null)
                return head;
            n2 = n1.next;
            if(n2 == null)
                return head;
        }
    }
}



//递归

class Solution24_2{
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)  //中止条件
            return head;
        ListNode firstNode = head,secondNode = head.next;

        firstNode.next = swapPairs(secondNode.next);
        secondNode.next =firstNode;
        return secondNode;
    }
}