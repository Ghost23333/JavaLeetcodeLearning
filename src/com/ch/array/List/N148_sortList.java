package com.ch.array.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class N148_sortList {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode ll = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l.next = ll;
        ll.next = l3;
        l3.next = l4;
        l4.next = null;
        Solution s = new Solution();
        s.sortList(l);

    }
}
/*class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next ==null)
            return head;
        ArrayList<Integer> al = new ArrayList<Integer>();
        ListNode cur = head;
        while(cur !=null){
            al.add(cur.val);
            cur = cur.next;
        }
        Collections.sort(al);
        cur =head;
        for(int i : al){
            cur.val = i;
            cur = cur.next;
        }
        return head;
    }
}*/

//快慢指针+二路并归 + 递归
class Solution{
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode fast = head,slow = head, pre = head;
        while(fast !=null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next =null;
        return mergeTwoLists(sortList(head),sortList(slow));
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null )
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return  l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1,l2.next);
            return  l2;
        }
    }
}