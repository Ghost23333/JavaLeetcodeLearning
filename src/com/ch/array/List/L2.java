package com.ch.array.List;

public class L2 {
}
/*
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1,p2 = l2,pre = l1;
        int temp = 0;//进位
        while(p1 != null && p2 != null){
            if(temp + p1.val + p2.val > 9){
                p1.val = temp + p1.val + p2.val - 10;
                temp = 1;
            }
            else{
                p1.val = p1.val + p2.val + temp;
                temp = 0;
            }
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null && p2 == null){
            if(temp == 1){
                ListNode newNode = new ListNode(1);
                pre.next = newNode;
                newNode.next = null;
            }
            return l1;
        }
        if(p1 == null){
            pre.next = p2;
            while(p2 != null){
                if(p2.val + temp >9){
                    p2.val = p2.val + temp - 10;
                    temp = 1;
                }
                else {
                    p2.val = temp + p2.val;
                    temp = 0;
                }
                pre = p2;
                p2 = p2.next;
            }
            if(temp == 1){
                ListNode newNode = new ListNode(1);
                pre.next = newNode;
                newNode.next = null;
            }
            return l1;
        }
        if(p2 == null){
            while(p1 != null){
                if(p1.val + temp >9){
                    p1.val = p1.val + temp - 10;
                    temp = 1;
                }
                else {
                    p1.val = temp + p1.val;
                    temp = 0;
                }
                pre = p1;
                p1 = p1.next;
            }
            if(temp == 1){
                ListNode newNode = new ListNode(1);
                pre.next = newNode;
                newNode.next = null;
            }
            return l1;
        }
        return l1;

    }
}*/
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1,p2 = l2,pre = l1;
        int temp = 0;//进位
        while(p1 != null && p2 != null){
            if(temp + p1.val + p2.val > 9){
                p1.val = temp + p1.val + p2.val - 10;
                temp = 1;
            }
            else{
                p1.val = p1.val + p2.val + temp;
                temp = 0;
            }
            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null && p2 == null){
            if(temp == 1){
                ListNode newNode = new ListNode(1);
                pre.next = newNode;
                newNode.next = null;
            }
            return l1;
        }
        if(p1 == null){
            pre.next = p2;
            while(p2 != null){
                if(p2.val + temp >9){
                    p2.val = p2.val + temp - 10;
                    temp = 1;
                }
                else {
                    p2.val = temp + p2.val;
                    temp = 0;
                }
                pre = p2;
                p2 = p2.next;
            }
            if(temp == 1){
                ListNode newNode = new ListNode(1);
                pre.next = newNode;
                newNode.next = null;
            }
            return l1;
        }
        if(p2 == null){
            while(p1 != null){
                if(p1.val + temp >9){
                    p1.val = p1.val + temp - 10;
                    temp = 1;
                }
                else {
                    p1.val = temp + p1.val;
                    temp = 0;
                }
                pre = p1;
                p1 = p1.next;
            }
            if(temp == 1){
                ListNode newNode = new ListNode(1);
                pre.next = newNode;
                newNode.next = null;
            }
            return l1;
        }
        return l1;

    }
}