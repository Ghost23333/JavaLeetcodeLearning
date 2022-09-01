package com.ch.array.List;

public class L19 {
}

//快慢指针
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head,slow = head,pre = slow;
        for(int i =0;i<n;i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        while(fast != null){
            fast = fast.next;
            pre = slow;
            slow =slow.next;
        }
        pre.next = slow.next;
        return head;
    }
}