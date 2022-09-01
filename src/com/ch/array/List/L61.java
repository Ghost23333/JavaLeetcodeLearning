package com.ch.array.List;

public class L61 {
}
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        int len = 0;
        while (cur.next !=null){
            len++;
            cur = cur.next;
        }
        len++;
        k = k % len;
        if(k == 0)
            return head;
        while(k>0){

            ListNode p1 = head;
            while(head.next !=null){
                cur = head;
                head = head.next;
            }
            ListNode p2 = head;
            p2.next = p1;
            head = p2;
            cur.next = null;
            k--;
        }
        return head;
    }
}


//快慢指针
class Solution61_2{
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head , tail = null;
        int len = 0;
        while (cur.next !=null){
            len++;
            cur = cur.next;
        }
        len++;
        k = k % len;
        if(k == 0)
            return head;
        ListNode fast = head , slow = head;
        for(int i = 0;i < k;i++)
            fast = fast.next;
        while(fast !=null){
            cur = slow;
            tail = fast;
            fast = fast.next;
            slow = slow.next;
        }
        cur.next = null;
        tail.next = head;
        return slow;
    }
}