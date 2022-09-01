package com.ch.array.List;

public class L143 {
}

class Solution143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null||head.next.next == null)
            return;
        int len = 0;
        ListNode cur = head;
        //求出链表长度
        while(cur!= null){
            len++;
            cur = cur.next;
        }

        //算出分割点
        int div = len /2 - 1;
        if(len % 2 ==1)
            div++;

        //通过快慢指针，求出分割点
        ListNode fast = head,slow = head,pre =null;
        for(int i =0;i<div;i++) {
            fast = fast.next;
        }
        while(fast !=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = null;
        //反转slow
        cur = slow.next;
        slow.next = null;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = slow;
            slow = cur;
            cur = temp;
        }
        //反转完成
        cur = head;
        while(slow !=null){
            ListNode temp1 = cur.next;
            ListNode temp2 = slow.next;
            cur.next = slow;
            slow.next = temp1;
            cur = temp1;
            slow = temp2;
        }

    }
}