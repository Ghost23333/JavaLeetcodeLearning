package com.ch.array.List;

import java.util.HashSet;

public class L82 {
}
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode cur = head.next,pre = head,prepre = dumy;
        while(cur != null){
           if(cur.val == pre.val)
           {
               while(cur != null && cur.val == pre.val)
                   cur = cur.next;
               prepre.next = cur;

               if(cur != null)
               {
                   pre = cur;
                   cur = cur.next;
               }
           }
           else
           {
               prepre = pre;
               pre = cur;
               cur = cur.next;
           }
        }
        return dumy.next;
    }
}

//递归

class Solution82_2{
    public ListNode deleteDuplicates(ListNode head){
        if(head == null || head.next == null)
            return head;
        if(head.val == head.next.val){
            while(head !=null && head.next!=null && head.val == head.next.val)
                head = head.next;
            return  deleteDuplicates(head.next);
        }else
        {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}