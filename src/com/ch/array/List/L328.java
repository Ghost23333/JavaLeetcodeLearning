package com.ch.array.List;

public class L328 {
}
class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode cur = head.next.next.next; //第四个节点
        ListNode tail1 = head.next.next;
        ListNode h1 = head;
        ListNode tail2 = cur;
        ListNode h2 = head.next;
        h1.next = tail1;
        h2.next = tail2;
        tail1.next = h2;
        while(cur != null){
            if(cur.next != null)
            {
                tail1.next = cur.next;
                tail1 = tail1.next;
                cur = cur.next.next;
                tail1.next = h2;
                tail2.next = cur;
                tail2 = cur;
            }
            else {
                tail2.next = null;
                break;
            }
        }
        return head;

    }
}
